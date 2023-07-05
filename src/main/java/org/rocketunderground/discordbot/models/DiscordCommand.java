package org.rocketunderground.discordbot.models;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

public abstract class DiscordCommand extends ListenerAdapter {
    public abstract SlashCommandData getCommand();

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("ping")) {
            return;
        }

        super.onSlashCommandInteraction(event);
    }
}
