package com.kexinzhida.backend;

import com.ruoyi.web.bootstrap.AdminBootstrap;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class, scanBasePackages = {"com.kexinzhida.backend.config", "com.kexinzhida.backend.convert",
        "com.kexinzhida.backend.service", "com.kexinzhida.backend.controller", "com.kexinzhida.backend.schedule"})
@Slf4j
@MapperScan("com.kexinzhida.backend.mapper")
@Import({AdminBootstrap.class})
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
        log.info("(♥◠‿◠)ﾉﾞ  科信志达web启动成功   ლ(´ڡ`ლ)ﾞ");
    }

}
