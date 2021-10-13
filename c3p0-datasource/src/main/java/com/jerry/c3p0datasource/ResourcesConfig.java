package com.jerry.c3p0datasource;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ImportResource(locations = { "classpath:appContext-db.xml"})
@EnableConfigurationProperties
public class ResourcesConfig {
}
