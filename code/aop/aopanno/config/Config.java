package cn.longq.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @description: 配置类
 * @author: Liu Hualong
 * @created: 2021/04/27 11:10
 */
@Configuration
@ComponentScan(basePackages = {"cn.longq.aopanno"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Config {
}
