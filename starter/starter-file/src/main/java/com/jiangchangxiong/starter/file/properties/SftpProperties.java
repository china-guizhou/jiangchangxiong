package com.jiangchangxiong.starter.file.properties;

import com.jcraft.jsch.ChannelSftp;
import com.jiangchangxiong.constants.AppConstant;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 集成SFTP实现上传下载的配置
 *
 * @author JiangChangXiong
 * @since  2021-12-02
 */
@ConfigurationProperties(prefix = AppConstant.CONFIG_PREFIX + ".file.sftp")
public class SftpProperties {

    private String host;

    private int port;

    private String username;

    private String password;

    private Pool pool = new Pool();

    public static class Pool extends GenericObjectPoolConfig<ChannelSftp> {

        /**
         * 最大连接数
         * 设置为100个
         */
        private int maxTotal = DEFAULT_MAX_TOTAL;

        /**
         * 最大空闲数量
         * 设置为10个
         */
        private int maxIdle = DEFAULT_MAX_IDLE;

        /**
         * 最小空闲数量
         *
         * 设置为5个
         */
        private int minIdle = DEFAULT_MIN_IDLE;

        /**
         * 最大等待时间
         */
        private long maxWaitMillis = DEFAULT_MAX_WAIT_MILLIS;

        public Pool() {
            super();
        }

        @Override
        public int getMaxTotal() {
            return maxTotal;
        }

        @Override
        public void setMaxTotal(int maxTotal) {
            this.maxTotal = maxTotal;
        }

        @Override
        public int getMaxIdle() {
            return maxIdle;
        }

        @Override
        public void setMaxIdle(int maxIdle) {
            this.maxIdle = maxIdle;
        }

        @Override
        public int getMinIdle() {
            return minIdle;
        }

        @Override
        public void setMinIdle(int minIdle) {
            this.minIdle = minIdle;
        }

        @Override
        public long getMaxWaitMillis() {
            return maxWaitMillis;
        }

        @Override
        public void setMaxWaitMillis(long maxWaitMillis) {
            this.maxWaitMillis = maxWaitMillis;
        }
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }
}
