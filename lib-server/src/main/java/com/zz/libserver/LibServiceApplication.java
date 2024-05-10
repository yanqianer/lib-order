package com.zz.libserver;

import cn.dev33.satoken.SaManager;
import org.babyfish.jimmer.client.EnableImplicitApi;
import org.babyfish.jimmer.sql.EnableDtoGeneration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableImplicitApi
@EnableDtoGeneration
public class LibServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(LibServiceApplication.class, args);
    System.out.println("启动成功，Sa-Token 配置如下：" + SaManager.getConfig());
  }

}
