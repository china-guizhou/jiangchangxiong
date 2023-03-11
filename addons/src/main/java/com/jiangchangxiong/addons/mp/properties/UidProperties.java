package com.jiangchangxiong.addons.mp.properties;

import com.jiangchangxiong.constants.AppConstant;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Jiang
 * @since  2023-03-04
 */
@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = AppConstant.CONFIG_PREFIX)
public class UidProperties {

    private Uid uid = new Uid();

    /**
     * 唯一ID生成配置
     */
    @Data
    public static class Uid {
        /**
         * 终端ID (0-31)      单机配置0 即可。 集群部署，根据情况每个实例自增即可。
         */
        private Long workerId = 0L;

        /**
         * 数据中心ID (0-31)   单机配置0 即可。 集群部署，根据情况每个实例自增即可。
         */
        private Long dataCenterId = 0L;
    }

}
