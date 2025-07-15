package cn.hjblogs.hjblogs.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author JUHE
 * @version 1.0
 * @date: 2025-07-15 16:52
 * @description: Mybatis Plus 配置文件
 */
@Configuration
@MapperScan("cn.hjblogs.hjblogs.common.domain.mapper")
public class MybatisPlusConfig {
}
