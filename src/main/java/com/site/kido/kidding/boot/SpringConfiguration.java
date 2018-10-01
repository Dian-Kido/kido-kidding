package com.site.kido.kidding.boot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/10/1.
 */

@Configuration
@ImportResource("classpath:spring-service.xml")
public class SpringConfiguration extends WebMvcConfigurerAdapter {
}
