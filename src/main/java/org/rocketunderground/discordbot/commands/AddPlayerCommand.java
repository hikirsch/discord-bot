package org.rocketunderground.discordbot.commands;

import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;
import org.rocketunderground.discordbot.CommandParam;
import org.rocketunderground.discordbot.models.DiscordCommand;
import org.springframework.stereotype.Component;

@Component
public class AddPlayerCommand extends DiscordCommand {
  public SlashCommandData getCommand() {
    return Commands.slash("add-player", "Add a new player")
      .setGuildOnly(true)
      .addOption(OptionType.STRING, CommandParam.USER.getName(), "Name", true, true)
      .addOption(OptionType.USER, CommandParam.DISCORD.getName(), "Discord", true)
      .addOption(OptionType.STRING, CommandParam.TRACKER_URL.getName(), "Tracker Url", true)
      .addOption(OptionType.ATTACHMENT, "blah", "attach", true)
      .addOption(OptionType.STRING, CommandParam.SALARY.getName(), "Salary");
  }

  @Override
  public void onCommandAutoCompleteInteraction(
    CommandAutoCompleteInteractionEvent event
  ) {
    super.onCommandAutoCompleteInteraction(event);

    var choice = new Command.Choice("name1", "value1");
    var choice2 = new Command.Choice("name2", "value2");
    var choices = new Command.Choice[]{choice, choice2};

    event.replyChoices(choices).queue();
  }

  @Override
  public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
    if (!event.getName().equals("add-player")) {
      return;
    }

    var user = event.getOption(CommandParam.USER.getName()).getAsString();

    event.reply("Another pong!!" + user).setEphemeral(true).queue();
  }
}
