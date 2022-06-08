package com.example.discordbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiscordBotApplication {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(DiscordBotApplication.class, args);
        //RSSReader.start("https://createfeed.fivefilters.org/extract.php?url=https%3A%2F%2Fwww.leagueoflegends.com%2Fko-kr%2Fnews%2Ftags%2Fpatch-notes%2F&item=li%5Bclass%5E%3D%22style__Item%22%5D&item_title=h2&item_desc=div%5Bclass%5E%3D%22style__Category%22%5D&item_date=time+%40datetime&item_image=img+%40src&unique_url=1&max=5&order=document&guid=0");
//        RSSReaderA.start("https://createfeed.fivefilters.org/extract.php?url=https%3A%2F%2Fwww.leagueoflegends.com%2Fko-kr%2Fnews%2Ftags%2Fpatch-notes%2F&item=li%5Bclass%5E%3D%22style__Item%22%5D&item_title=h2&item_desc=div%5Bclass%5E%3D%22style__Category%22%5D&item_date=time+%40datetime&item_image=img+%40src&unique_url=1&max=5&order=document&guid=0");
        System.out.println("성공   ");
    }

}
