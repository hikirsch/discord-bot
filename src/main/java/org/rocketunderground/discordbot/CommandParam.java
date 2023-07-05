package org.rocketunderground.discordbot;

import lombok.Getter;
import org.apache.logging.log4j.Logger;

public enum CommandParam {
  USER("user"),
  DISCORD("discord"),
  TRACKER_URL("tracker-url"),
  SALARY("salary");

  @Getter
  private final String name;

  CommandParam(String name) {
    this.name = name;
  }
}
