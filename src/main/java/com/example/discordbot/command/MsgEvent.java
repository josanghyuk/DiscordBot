package com.example.discordbot.command;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static com.example.discordbot.command.RSSReader.*;


public class MsgEvent extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) throws StringIndexOutOfBoundsException{
        if (event.isFromType(ChannelType.PRIVATE)) {
            System.out.printf("[PM] %s: %s\n", event.getAuthor().getName(), event.getMessage().getContentDisplay());
        } else {
            System.out.printf("[%s][%s] %s: %s\n", event.getGuild().getName(), event.getTextChannel().getName(), event.getMember().getEffectiveName(),
                    event.getMessage().getContentDisplay());
        }

        User user = event.getAuthor();
        Message msg = event.getMessage();

        if(msg.getContentRaw().charAt(0) == '^'){
            String[] args = msg.getContentRaw().substring(1).split(" ");
            if(args.length <= 0) return;
            if (args[0].equalsIgnoreCase("롤전적")) {
                if(args.length < 2) return;
                event.getChannel().sendMessage("TEST VALUE " + args[1]).queue();
                if(args[1].equalsIgnoreCase("LOL")){

                }
            } else if (args[0].equalsIgnoreCase("ㅎㅇ")) {
                event.getChannel().sendMessage("ㅎㅇㅋㅋ " + user.getAsMention()).queue();
            } else if (args[0].equalsIgnoreCase("help")) {
                event.getChannel().sendMessage("명령어").setEmbeds(CommandEmbed.commandEb().build()).queue();
//                event.getChannel().sendMessageEmbeds().queue();
            } else if (args[0].equalsIgnoreCase("패치노트")) {

                event.getChannel().sendMessage("ㅤ").setEmbeds(CommandEmbed.patchEb().build()).queue();

                if(args.length < 2) return;
                if(args[1].equalsIgnoreCase("LOL")){
                    RSSReader.start("https://createfeed.fivefilters.org/extract.php?url=https%3A%2F%2Fwww.leagueoflegends.com%2Fko-kr%2Fnews%2Ftags%2Fpatch-notes%2F&item=li%5Bclass%5E%3D%22style__Item%22%5D&item_title=h2&item_desc=div%5Bclass%5E%3D%22style__Category%22%5D&item_date=time+%40datetime&item_image=img+%40src&unique_url=1&max=5&order=document&guid=0","LOL");
                    for(int i =0; i < 3 ; i++) {
                        event.getChannel().sendMessage("ㅤ").setEmbeds(CommandEmbed.patchNote_lol(LOLVO, i).build()).queue();
                    }
                }else if(args[1].equalsIgnoreCase("TFT")){
//                    RSSReader.start("https://createfeed.fivefilters.org/extract.php?url=https%3A%2F%2Fwww.leagueoflegends.com%2Fko-kr%2Flatest-news%2F&item=li%5Bclass%5E%3D%22style__Item%22%5D&item_title=h2&item_desc=div%5Bclass%5E%3D%22style__Category%22%5D&item_date=time+%40datetime&item_image=img+%40src&unique_url=1&max=5&order=document&guid=0");
                    RSSReader.start("https://createfeed.fivefilters.org/extract.php?url=https%3A%2F%2Fteamfighttactics.leagueoflegends.com%2Fko-kr%2Fnews%2F&item=li%5Bclass%5E%3D%22style__Item%22%5D&item_title=h2&item_desc=div%5Bclass%5E%3D%22style__Category%22%5D&item_date=time+%40datetime&item_image=img+%40src&unique_url=1&max=5&order=document&guid=0","TFT");

                    for(int i =0; i < 3 ; i++) {
                        event.getChannel().sendMessage("ㅤ").setEmbeds(CommandEmbed.patchNote_tft(TFTVO, i).build()).queue();
                    }
                }else if(args[1].equalsIgnoreCase("로아")){
//                    RSSReader.start("https://createfeed.fivefilters.org/extract.php?url=https%3A%2F%2Flostark.game.onstove.com%2FNews%2FNotice%2FList%3Fnoticetype%3Dinspection&item=div.list+li%3Anot%28.list__item--notice%29&item_title=div.list__subject&item_desc=div.list__category&max=5&order=document&guid=0");
                    RSSReader.start("https://createfeed.fivefilters.org/extract.php?url=https%3A%2F%2Flostark.game.onstove.com%2FNews%2FNotice%2FList&item=div.list+li%3Anot%28.list__item--notice%29&item_title=div.list__subject&item_desc=div.list__category&max=5&order=document&guid=0","lost");

                    for(int i =0; i < 3 ; i++) {
                        event.getChannel().sendMessage("ㅤ").setEmbeds(CommandEmbed.patchNote_lost(LostVO, i).build()).queue();
                    }
                }else if(args[1].equalsIgnoreCase("메이플")){
                    RSSReader.start("https://createfeed.fivefilters.org/extract.php?url=https%3A%2F%2Fmaplestory.nexon.com%2FNews%2FUpdate&item=.update_board+li&item_date=dd&item_date_format=Y.m.d&max=5&order=document&guid=0","maple");
                    for(int i =0; i < 3 ; i++) {
                        event.getChannel().sendMessage("ㅤ").setEmbeds(CommandEmbed.patchNote_maple(MapleVO, i).build()).queue();
                    }
                }
            }
        }


    }
}
