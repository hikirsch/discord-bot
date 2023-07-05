package org.rocketunderground.common.listeners;

import jakarta.annotation.Nonnull;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.rocketunderground.common.configs.BotConfiguration;
import org.rocketunderground.common.models.DiscordRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public abstract class DiscordListener extends ListenerAdapter {
  @Autowired
  private BotConfiguration botConfiguration;

  @Override
  public void onReady(@Nonnull ReadyEvent event) {
    super.onReady(event);

    this.autoJoinChannels(event);
  }

  private void autoJoinChannels(ReadyEvent event) {
    if (this.botConfiguration.getAutoJoinChannels() == null ||
      this.botConfiguration.getAutoJoinChannels().isEmpty()) {
      return;
    }

    for (var info : this.botConfiguration.getAutoJoinChannels()) {
      this.autoJoinChannel(event, info);
    }
  }

  private void autoJoinChannel(ReadyEvent event, DiscordRoom info) {
    // if guild doesn't exist, stop
    var guild = event.getJDA().getGuildById(info.getServerId());
    if (guild == null) {
      return;
    }

    // If channel doesn't exist, stop
    var channel = guild.getTextChannelById(info.getChannelId());
    if (channel == null) {
      return;
    }

    // is there is an announcement message
    var autoJoinMessage = info.getAnnouncement();
    if (!StringUtils.hasText(autoJoinMessage)) {
      return;
    }

    channel.sendMessage(autoJoinMessage).queue();
  }
}
