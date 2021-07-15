package org.shardingtables.config;


import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.Collection;
import java.util.Properties;

public class DateShardingAlgorithm implements StandardShardingAlgorithm<String> {


    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
        String tableName = preciseShardingValue.getLogicTableName();
        String date = preciseShardingValue.getValue();
        StringBuffer tableNameBuffer = new StringBuffer();
        tableNameBuffer.append(tableName).append("_").append(Integer.parseInt(date.substring(5, 7)) % 3);
        return tableNameBuffer.toString();
    }
    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<String> rangeShardingValue) {
        return null;
    }
    @Override
    public void init() {
    }
    @Override
    public String getType() {
        return "CLASS_BASED";
    }
    @Override
    public Properties getProps() {
        return null;
    }

    @Override
    public void setProps(Properties properties) {

    }
}

