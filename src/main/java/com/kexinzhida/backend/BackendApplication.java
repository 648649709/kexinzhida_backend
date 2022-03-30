package com.kexinzhida.backend;

import com.ruoyi.bootstrap.RuoyiAdminBootstrap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@Slf4j
@Import(RuoyiAdminBootstrap.class)
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
        log.info("(♥◠‿◠)ﾉﾞ  科信志达web启动成功   ლ(´ڡ`ლ)ﾞ");
    }

}
