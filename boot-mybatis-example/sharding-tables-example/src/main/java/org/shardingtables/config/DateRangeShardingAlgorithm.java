/*
 * Project xQA.
 * Copyright (c) 2000-2021 xQuant Co.,Ltd All Rights Reserved.
 */
package org.shardingtables.config;

import com.google.common.collect.Range;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Description : 日期（年）范围分片算法
 * FileName : DateRangeShardingAlgorithm.java
 *
 * @author : XU Tao
 * @version : 3.0
 * @date : 2021-06-16 16:13
 */
@Service
public class DateRangeShardingAlgorithm implements StandardShardingAlgorithm<String> {


    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<String> rangeShardingValue) {
        Collection<String> result = new LinkedHashSet<>(collection.size());
        Range<String> dateRange = rangeShardingValue.getValueRange();
        String beginDate = dateRange.lowerEndpoint();
        String endDate = dateRange.upperEndpoint();
        Integer beginYear = Integer.valueOf(beginDate.substring(5, 7));
        Integer endYear = Integer.valueOf(endDate.substring(5, 7));
        List<Integer> list_0 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list_1 = Arrays.asList(5, 6, 7, 8);
        List<Integer> list_2 = Arrays.asList(9, 10, 11, 12);
        while (beginYear <= endYear) {
            StringBuffer tableName = new StringBuffer();
            if (list_0.contains(beginYear)) {
                tableName.append(rangeShardingValue.getLogicTableName())
                        .append("_").append(0);
            } else if (list_1.contains(beginYear)) {
                tableName.append(rangeShardingValue.getLogicTableName())
                        .append("_").append(1);
            } else {
                tableName.append(rangeShardingValue.getLogicTableName())
                        .append("_").append(2);
            }
            result.add(tableName.toString());
            beginYear++;
        }
        return result;
    }

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
        String tableName = preciseShardingValue.getLogicTableName();
        String date = preciseShardingValue.getValue();
        StringBuffer tableNameBuffer = new StringBuffer();
        List<Integer> list_0 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list_1 = Arrays.asList(5, 6, 7, 8);
        List<Integer> list_2 = Arrays.asList(9, 10, 11, 12);
        Integer month = Integer.parseInt(date.substring(5, 7));
        if (list_0.contains(month)) {
            tableNameBuffer.append(tableName).append("_").append(0);
        } else if (list_1.contains(month)) {
            tableNameBuffer.append(tableName).append("_").append(1);
        } else {
            tableNameBuffer.append(tableName).append("_").append(2);
        }
        return tableNameBuffer.toString();
    }


    @Override
    public void init() {

    }

    @Override
    public String getType() {
        return "RANGE_DATE";
    }

    @Override
    public Properties getProps() {
        return null;
    }

    @Override
    public void setProps(Properties properties) {

    }
}
