package com.example.discordbot.command;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import javax.security.auth.login.LoginException;

@Controller
public class setToken {

    private static String botToken;

    @Value("${discord.token}")
    public void setDiscordToken(String token){
        botToken = token;
    }
    //    @Value("${discord.token}")
    //    public String botToken;


    public static JDA setBot() throws LoginException {
        JDA jdaa = JDABuilder.createDefault(botToken).build();

        return jdaa;
    }
}
