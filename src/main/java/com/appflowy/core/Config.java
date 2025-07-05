package com.appflowy.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Не удалось найти config.properties");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка загрузки config.properties", e);
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public static String getApiBaseUrl() {
        return properties.getProperty("api.base.url");
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    public static int getTimeout() {
        return Integer.parseInt(properties.getProperty("timeout.seconds"));
    }

    public static String getTestUserEmail() {
        return properties.getProperty("test.user.email");
    }

    public static String getTestUserPassword() {
        return properties.getProperty("test.user.password");
    }
}
