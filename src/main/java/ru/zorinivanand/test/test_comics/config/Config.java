package ru.zorinivanand.test.test_comics.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import javax.sql.DataSource;



    @Configuration
    @ComponentScan("ru.zorinivanand")
    @EnableWebMvc
    public class Config implements WebMvcConfigurer{

        private final ApplicationContext applicationContext;

        @Autowired
        public Config(ApplicationContext applicationContext) {
            this.applicationContext = applicationContext;
        }

        @Bean
        public SpringResourceTemplateResolver templateResolver() {
            SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
            templateResolver.setApplicationContext(applicationContext);
            templateResolver.setPrefix("/WEB-INF/views/");
            templateResolver.setSuffix(".html");
            return templateResolver;
        }

        @Bean
        public SpringTemplateEngine templateEngine() {
            SpringTemplateEngine templateEngine = new SpringTemplateEngine();
            templateEngine.setTemplateResolver(templateResolver());
            templateEngine.setEnableSpringELCompiler(true);
            return templateEngine;
        }

        @Bean
        public DataSource dataSource(){
            DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
            driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
            driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/test_db");
            driverManagerDataSource.setUsername("postgres");
            driverManagerDataSource.setPassword("postgres");
            return driverManagerDataSource;
        }

        @Bean
        public JdbcTemplate jdbcTemplate(){
            return new JdbcTemplate(dataSource());
        }
    }

