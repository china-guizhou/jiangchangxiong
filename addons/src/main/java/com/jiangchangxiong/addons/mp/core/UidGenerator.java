package com.jiangchangxiong.addons.mp.core;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * 使用 hutool 生成ID
 *
 * @author Jiang
 * @since  2023-02-20
 */
public class UidGenerator {

    private final Snowflake snowflake;

    public UidGenerator(long workerId, long datacenterId) {
        this.snowflake = IdUtil.getSnowflake(workerId, datacenterId);
    }

    public long getUid() {
        return snowflake.nextId();
    }

    public String parseUid(long uid) {
        long workerId = snowflake.getWorkerId(uid);
        long dataCenterId = snowflake.getDataCenterId(uid);
        long timestamp = snowflake.getGenerateDateTime(uid);

        return String.format("{\"UID\":\"%d\",\"timestamp\":\"%d\",\"workerId\":\"%d\",\"dataCenterId\":\"%d\"}",
                uid, timestamp, workerId, dataCenterId);
    }

}
