package com.jiangchangxiong.config;

import com.jiangchangxiong.addons.mp.core.UidGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 *
 * @author Jiang
 * @since  2023-03-11
 */
@Configuration
public class SecurityConfiguration {

    @Bean
    public UidGenerator uidGenerator() {
        return new UidGenerator(1L, 1L);
    }


}
