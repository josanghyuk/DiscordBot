package com.example.discordbot.controller;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Scanner;

public class MsgEvent extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.isFromType(ChannelType.PRIVATE)){
            System.out.printf("[PM] %s: %s\n", event.getAuthor().getName(), event.getMessage().getContentDisplay());
        } else {
            System.out.printf("[%s][%s] %s: %s\n", event.getGuild().getName(), event.getTextChannel().getName(), event.getMember().getEffectiveName(),
                    event.getMessage().getContentDisplay());
        }

        if(event.getMessage().getContentRaw().equals("!test")){
            event.getChannel().sendMessage("test").queue();
        }else if(event.getMessage().getContentRaw().equals("!야")) {
            String txt = "";
            Scanner sc = new Scanner(System.in);
            txt = sc.next();
            event.getChannel().sendMessage(txt).queue();
        }
        if(event.getAuthor().isBot()){
            return;
        }

//        User user = event.getAuthor();
//        TextChannel tc = event.getTextChannel();
//        Message msg = event.getMessage();
//
//        if(user.isBot()) return; // 루프 방지
//
//        if(msg.getContentRaw().charAt(0) == '^'){
//            String[] args = msg.getContentRaw().substring(1).split(" ");
//            if(args.length <= 0) return;
//            if(args[0].equalsIgnoreCase("test")){
//                tc.sendMessage("ㅎㅇ"+user.getAsMention()).queue();
//            }else if(args[0].equalsIgnoreCase("ㅎㅇ")){
//                tc.sendMessage("ㅂㅇ"+user.getAsMention()).queue();
//            }
//        }

    }


}
