package org.rocketunderground.common.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiscordRoom {
  private String serverId;
  private String channelId;
  private String announcement;
}
