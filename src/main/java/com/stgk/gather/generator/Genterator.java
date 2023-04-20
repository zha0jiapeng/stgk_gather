package com.stgk.gather.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;

import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class Genterator{

        public static void main(String[] args) {
            String url = System.getProperty("user.dir")+"/src/main/";

            FastAutoGenerator.create("jdbc:mysql://localhost:3306/stgk_monitor?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8", "root", "123456")
                    .globalConfig(builder -> {
                        builder.author("mashir0zhao") // 设置作者
                                .enableSwagger() // 开启 swagger 模式
                                .fileOverride() // 覆盖已生成文件
                                .disableOpenDir()
                                .outputDir(url + "java"); // 指定输出目录
                    })
                    .packageConfig(builder -> {
                        builder.parent("com.stgk.gather") // 设置父包名
                                .moduleName("") // 设置父包模块名
                                .pathInfo(Collections.singletonMap(OutputFile.xml, url + "resources/mapper")); // 设置mapperXml生成路径
                    })
                    .strategyConfig(builder -> {
                        builder.addInclude("stgk_voltage_cabinet") // 设置需要生成的表名
                                .addTablePrefix("stgk_"); // 设置过滤表前缀

                    })
                    .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                    .execute();
        }
}
