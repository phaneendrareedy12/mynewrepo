/**
 * 
 */
package com.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Admin
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.rest.controller,com.beans")
public class TestConfiguration {

}
