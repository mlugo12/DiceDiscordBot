package org.example;

import events.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        final String token = "MTE4NDk3Mjc0OTE4MjA5MTMxNQ.G0CVO-.ssqoa8OSPHGHLr6yubihWYCVgnc5hb_cXUVad0";
        JDABuilder jdabuilder = JDABuilder.createDefault(token);

        JDA jda = jdabuilder
                .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
                .addEventListeners(new ReadyEventListener(), new MessageEventListener(), new InteractionEventListener())
                .build();

        jda.upsertCommand("roll", "Roll any kind of dice. Ex: '1d6'")
                .addOption(OptionType.STRING, "dice", "Roll Something", true)
                .setGuildOnly(true).queue();
    }
}