package com.yuanlrc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author yuanlrc
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class YuanlrcApplication
{
    public static void main(String[] args)
    {
        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(YuanlrcApplication.class, args);
        System.out.println("***********************“+ 启动成功   ************************8  \n");

    }
}