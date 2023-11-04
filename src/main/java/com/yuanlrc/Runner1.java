package com.yuanlrc;

import com.yuanlrc.framework.util.HardWareUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1) //指定顺序
public class Runner1 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

                String writepath = System.getProperty("user.dir");
        String cputID = HardWareUtils.getCPUSerial();
              // writepath



            //String writepath = System.out.println(System.getProperty("user.dir"));
            //File file = new F


            // File file = ResourceUtils.getFile("classpath:application.yml");
            // String path = file.getPath();
             //System.out.println(path);
             //String filepath = path.substring(0,path.indexOf("\\"));
             //System.out.println(filepath);




             //检测本地license文件是否存在
             //没有本地文件就写入一个
             //有本地文件就
    }
}