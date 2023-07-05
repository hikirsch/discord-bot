package org.rocketunderground.discordbot.listeners;

import jakarta.annotation.Nonnull;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.rocketunderground.common.listeners.DiscordListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class LoggerListener extends DiscordListener {
  private static final Logger logger = LoggerFactory.getLogger(LoggerListener.class);

  @Override
  public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
    logger.info("Received message from channel: {}",
      event.getChannel().getName()
    );
    logger.info("User: {}", event.getAuthor().getName());
    logger.info("Message content: {}", event.getMessage().getContentDisplay());
    logger.info("Channel Name: {}", event.getChannel().getName());
  }
}
