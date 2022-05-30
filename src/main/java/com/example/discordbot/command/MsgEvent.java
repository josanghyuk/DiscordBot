package com.example.discordbot.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Arrays;

public class MsgEvent extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.isFromType(ChannelType.PRIVATE)) {
            System.out.printf("[PM] %s: %s\n", event.getAuthor().getName(), event.getMessage().getContentDisplay());
        } else {
            System.out.printf("[%s][%s] %s: %s\n", event.getGuild().getName(), event.getTextChannel().getName(), event.getMember().getEffectiveName(),
                    event.getMessage().getContentDisplay());
        }
        User user = event.getAuthor();
//        TextChannel tc = event.getTextChannel();
        Message msg = event.getMessage();

        if (msg.getContentRaw().charAt(0) == '^') {

            String[] args = msg.getContentRaw().substring(1).split(" ");

            EmbedBuilder commandEb = new EmbedBuilder();
            commandEb.setTitle("sanggubot commond", null) ;
            commandEb.setDescription("Text");
            commandEb.setColor(Color.red);
            commandEb.setColor(new Color(0xF40C0C));
            commandEb.setColor(new Color(184, 185, 189));
            commandEb.setDescription("Text");
            commandEb.addField("^test", "test", false);
            commandEb.addField("^ㅎㅇ", "ㅎㅇㅋㅋ", false);
            commandEb.addField("^패치노트", "test of field, ", false);
            commandEb.setAuthor("SANGGU BOT", null, null);
            commandEb.addBlankField(false);
            commandEb.setFooter("SANGGU BOT V0.1", "https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/zekroBot_Logo_-_round_small.png");
//            eb.setImage("https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/logo%20-%20title.png");
//            commandEb.setThumbnail("https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/logo%20-%20title.png");
            if (args.length <= 0) return;
            if (args[0].equalsIgnoreCase("test")) {
                event.getChannel().sendMessage("test").queue();

            } else if(args[0].equalsIgnoreCase("ㅎㅇ")) {
                event.getChannel().sendMessage("ㅎㅇㅋㅋ "+user.getAsMention()).queue();
            } else if(args[0].equalsIgnoreCase("명령어")) {

                event.getChannel().sendMessageEmbeds(commandEb.build()).queue();

            }
        }

    }
}
