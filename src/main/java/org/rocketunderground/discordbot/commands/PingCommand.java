package org.rocketunderground.discordbot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;
import org.rocketunderground.discordbot.models.DiscordCommand;
import org.springframework.stereotype.Component;


@Component
public class PingCommand extends DiscordCommand {
  public SlashCommandData getCommand() {
    return Commands.slash(
      "ping",
      "Ban a user from the server"
    );
  }

  @Override
  public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
    if (!event.getName().equals("ping")) {
      return;
    }

    long time = System.currentTimeMillis();
    event.reply("Pong!")
      .setEphemeral(true) // reply or acknowledge
      .flatMap(v -> event.getHook().editOriginalFormat("Pong: %d ms", System.currentTimeMillis() - time))
      .queue(); // Queue both reply and edit
  }
}
