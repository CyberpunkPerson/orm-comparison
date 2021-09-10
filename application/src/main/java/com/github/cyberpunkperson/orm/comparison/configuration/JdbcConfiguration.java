package com.github.cyberpunkperson.orm.comparison.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.NamingStrategy;

@Configuration
class JdbcConfiguration {

    @Bean
    NamingStrategy namingStrategy(@Value("${spring.datasource.hikari.schema}") String schemaName) {
        return new NamingStrategy() {
            @Override
            public String getSchema() {
                return schemaName;
            }
        };
    }

}
