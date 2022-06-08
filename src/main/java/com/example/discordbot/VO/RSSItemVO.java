package com.example.discordbot.VO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RSSItemVO {
    private String title;
    private String description;
    private String link;
    private String pubDate;
    private String content;
    private String image;

}
