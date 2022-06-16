package com.example.discordbot.command;

import com.example.discordbot.VO.RSSItemVO;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.util.List;

public class CommandEmbed {

    public static EmbedBuilder commandEb (){
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
        commandEb.setAuthor("SANGGU BOT", null, "https://github.com/josanghyuk/discordBot/blob/master/src/main/resources/templates/img/sanggu.jpg?raw=true");
        commandEb.addBlankField(false);
        commandEb.setFooter("- SANGGU BOT V0.1", null);
//            eb.setImage("https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/logo%20-%20title.png");
        commandEb.setThumbnail("https://github.com/josanghyuk/discordBot/blob/master/src/main/resources/templates/img/sanggu.jpg?raw=true");

        return commandEb;
    }
    public static EmbedBuilder patchEb (){
        EmbedBuilder patchEb = new EmbedBuilder();

        patchEb.setAuthor("SANGGU BOT", null, "https://github.com/josanghyuk/discordBot/blob/master/src/main/resources/templates/img/sanggu.jpg?raw=true");
        patchEb.setTitle("패치노트", null) ;
        patchEb.setColor(Color.red);
        patchEb.setColor(new Color(0xb083cc));
        patchEb.setColor(new Color(184, 185, 189));
        patchEb.addField("- 롤", "^패치노트 LOL", false);
        patchEb.addField("- 롤토체스", "^패치노트 TFT", false);
        patchEb.addField("- 로아", "^패치노트 로아", false);
        patchEb.addField("- 메이플", "^패치노트 메이플", false);
        patchEb.setFooter("SANGGU BOT V0.1", null);
//            eb.setImage("https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/logo%20-%20title.png");
        patchEb.setThumbnail("https://github.com/josanghyuk/discordBot/blob/master/src/main/resources/templates/img/sanggu.jpg?raw=true");

        return patchEb;
    }

    public static EmbedBuilder patchNote_lol(List<RSSItemVO> LoLVO, int idx) {
        EmbedBuilder patchEbLoL = new EmbedBuilder();
        System.out.println("title "+LoLVO.get(0).getTitle());
        System.out.println("title1 "+LoLVO.get(1).getTitle());
        patchEbLoL.setColor(new Color(0xb083cc));

        patchEbLoL.setTitle(LoLVO.get(idx).getTitle(), LoLVO.get(0).getLink());
        patchEbLoL.setColor(new Color(184, 185, 189));
//        patchEbLoL.setDescription(rssVO.get(idx).getDescription());
        patchEbLoL.setImage(LoLVO.get(idx).getImage());
        patchEbLoL.setFooter(LoLVO.get(idx).getPubDate());


        return patchEbLoL;
    }

    public static EmbedBuilder patchNote_tft(List<RSSItemVO> LoLVO, int idx) {
        EmbedBuilder patchEbtft = new EmbedBuilder();
        System.out.println("title "+LoLVO.get(0).getTitle());
        System.out.println("title1 "+LoLVO.get(1).getTitle());
        patchEbtft.setColor(new Color(0xb083cc));

        patchEbtft.setTitle(LoLVO.get(idx).getTitle(), LoLVO.get(0).getLink());
        patchEbtft.setColor(new Color(184, 185, 189));
//        patchEbtft.setDescription(rssVO.get(idx).getDescription());
        patchEbtft.setImage(LoLVO.get(idx).getImage());
        patchEbtft.setFooter(LoLVO.get(idx).getPubDate());


        return patchEbtft;
    }

    public static EmbedBuilder patchNote_maple(List<RSSItemVO> MapleVO, int idx) {
        EmbedBuilder patchEbMaple = new EmbedBuilder();
        System.out.println("title "+MapleVO.get(0).getTitle());
        System.out.println("title1 "+MapleVO.get(1).getTitle());
        patchEbMaple.setColor(new Color(0xb083cc));

        patchEbMaple.setTitle(MapleVO.get(idx).getTitle(), MapleVO.get(0).getLink());
        patchEbMaple.setColor(new Color(184, 185, 189));
//        patchEbMaple.setDescription(rssVO.get(idx).getDescription());
        patchEbMaple.setImage(MapleVO.get(idx).getImage());
        patchEbMaple.setFooter(MapleVO.get(idx).getPubDate());


        return patchEbMaple;
    }
    public static EmbedBuilder patchNote_lost(List<RSSItemVO> LostVO, int idx) {
        EmbedBuilder patchEbLost = new EmbedBuilder();
        System.out.println("title "+LostVO.get(0).getTitle());
        System.out.println("title1 "+LostVO.get(1).getTitle());
        patchEbLost.setColor(new Color(0xb083cc));

        patchEbLost.setTitle(LostVO.get(idx).getTitle(), LostVO.get(0).getLink());
        patchEbLost.setColor(new Color(184, 185, 189));
        patchEbLost.setDescription(LostVO.get(idx).getDescription());
        patchEbLost.setImage(LostVO.get(idx).getImage());
        patchEbLost.setFooter(LostVO.get(idx).getPubDate());
        return patchEbLost;
    }

}


