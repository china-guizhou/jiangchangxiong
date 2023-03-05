package com.jiangchangxiong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Jiang
 * @since  2023-03-01
 */
@SpringBootApplication
@ComponentScan(basePackages={"cn.hutool.extra.spring"})
@Import(cn.hutool.extra.spring.SpringUtil.class)
public class AppBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(AppBootstrap.class, args);
    }

}
