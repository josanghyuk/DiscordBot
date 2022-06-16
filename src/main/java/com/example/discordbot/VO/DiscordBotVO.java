package com.example.discordbot.VO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DiscordBotVO {
    private String status;
    private String statusMsg;
    private String BotNm;
    private String userNm;
    private String msg;

}
