/*
 * Project xQA.
 * Copyright (c) 2000-2021 xQuant Co.,Ltd All Rights Reserved.
 */
package org.shardingtables.config;

import com.google.common.collect.Range;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description : 日期（年）范围分片算法
 * FileName : DateRangeShardingAlgorithm.java
 *
 * @author : XU Tao
 * @version : 3.0
 * @date : 2021-06-16 16:13
 */
@Service
public class ComplexDateRangeShardingAlgorithm implements ComplexKeysShardingAlgorithm<String> {


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

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, ComplexKeysShardingValue<String> complexKeysShardingValue) {
        final String begDate = "beg_date";
        final String endDate = "end_date";
        Map<String, Range<String>> columnNameAndRangeValuesMap = complexKeysShardingValue.getColumnNameAndRangeValuesMap();
        Integer lowerBound = null, upperBound = null;
        for (Map.Entry<String, Range<String>> entry : columnNameAndRangeValuesMap.entrySet()) {
            if (CollectionUtils.isEmpty(Collections.singleton(entry.getValue()))) {
                continue;
            }
            if (begDate.equals(entry.getKey())) {
                lowerBound = Integer.valueOf(entry.getValue().lowerEndpoint().substring(5, 7));
            }
            if (endDate.equals(entry.getKey())) {
                upperBound = Integer.valueOf(entry.getValue().upperEndpoint().substring(5, 7));
            }
        }
        Collection<String> result = new LinkedHashSet<>(availableTargetNames.size());
        List<Integer> list_0 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list_1 = Arrays.asList(5, 6, 7, 8);
        List<Integer> list_2 = Arrays.asList(9, 10, 11, 12);
        while (lowerBound <= upperBound) {
            StringBuffer tableName = new StringBuffer();
            if (list_0.contains(lowerBound)) {
                tableName.append(complexKeysShardingValue.getLogicTableName())
                        .append("_").append(0);
            } else if (list_1.contains(lowerBound)) {
                tableName.append(complexKeysShardingValue.getLogicTableName())
                        .append("_").append(1);
            } else {
                tableName.append(complexKeysShardingValue.getLogicTableName())
                        .append("_").append(2);
            }
            result.add(tableName.toString());
            lowerBound++;
        }
        return result;
    }

    public boolean rangeInDefined(int current, int min, int max){
        return Math.max(min, current) == Math.min(current, max);
    }

}
