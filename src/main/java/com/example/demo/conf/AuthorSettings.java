package com.example.demo.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
/**
 * @ConfigurationProperties 在spring boot1.5以上无法使用lications，具体可查看
 * https://www.jianshu.com/p/b71845c142d0
 */
//@ConfigurationProperties(prefix = "author", locations = {"classpath:config/author.properties"})
@ConfigurationProperties(prefix = "author")
@PropertySource("classpath:config/author.properties")
public class AuthorSettings {
    private String name;
    private Long age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
