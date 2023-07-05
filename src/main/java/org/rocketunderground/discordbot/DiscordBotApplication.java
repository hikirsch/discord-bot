package org.rocketunderground.discordbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@AutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = {"org.rocketunderground"})
public class DiscordBotApplication {
  public static void main(String[] args) {
    SpringApplication.run(DiscordBotApplication.class, args);
  }
}
