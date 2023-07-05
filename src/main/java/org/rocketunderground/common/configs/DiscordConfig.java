package org.rocketunderground.common.configs;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.rocketunderground.discordbot.models.DiscordCommand;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiscordConfig {
    @Bean
    public JDA jda(@Value("${discord.token}") String discordToken, ObjectProvider<ListenerAdapter> listenerAdapters, ObjectProvider<DiscordCommand> discordCommands) {
        var listeners = listenerAdapters.stream().toArray();
        var jda = JDABuilder.createDefault(discordToken).enableIntents(GatewayIntent.MESSAGE_CONTENT).addEventListeners(listeners).build();

        var commands = discordCommands.stream()
          .map(DiscordCommand::getCommand)
          .toArray(SlashCommandData[]::new);

        jda.updateCommands().addCommands(commands).queue();

        return jda;
    }
}
