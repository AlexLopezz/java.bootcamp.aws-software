package com.alexdev.springboot_CRUD.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "query")
public class JDBCQueries {
    public Map<String, String> user;
    public Map<String, String> profession;
}
