package org.rocketunderground.common.configs;

import lombok.Getter;
import lombok.Setter;
import org.rocketunderground.common.models.DiscordRoom;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "bot")
@Getter
@Setter
public class BotConfiguration {
  private int serverId;
  private List<DiscordRoom> autoJoinChannels;
}
