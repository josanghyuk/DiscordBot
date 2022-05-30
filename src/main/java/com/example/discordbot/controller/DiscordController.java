package com.example.discordbot.controller;


import com.example.discordbot.VO.DiscordBotVO;
import com.example.discordbot.service.DiscordService;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping(value = "/")
public class DiscordController {
    private final DiscordService service ;
    JDA jda = JDABuilder.createDefault("OTc2NzIwNzIxMjg1ODgxODk2.GSiUrQ.E99ka_WCTom-6hkPkNvBuebX05hAlWIsWYQ4YQ").build();


    @Autowired
    public DiscordController(DiscordService service) throws LoginException {
        jda.getPresence().setStatus(OnlineStatus.OFFLINE);

        this.service = service;
    }
//    /**
//     * 기능
//     * @return jsp
//     */
//    @RequestMapping(value = "/index.jsp")
//    public String home() {
//
//        System.out.println("home   ");
//
//        return "index";
//    }
    @ResponseBody
    @RequestMapping(value = "/setStatus/online.ajax", method = RequestMethod.POST)
    public Map<String, Object> setOnline(Model model ,DiscordBotVO dbVO) throws LoginException {
        System.out.println("SET ONLINE ");
        System.out.println("VO "+dbVO.toString());
//        JDA jda = JDABuilder.createDefault("OTc2NzIwNzIxMjg1ODgxODk2.GSiUrQ.E99ka_WCTom-6hkPkNvBuebX05hAlWIsWYQ4YQ").build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);


        String botNm = String.valueOf(jda.getSelfUser());
        String status = String.valueOf(jda.getPresence().getStatus());
        if(Objects.equals(status, "ONLINE")) {
            jda.addEventListener(new MsgEvent());
        }

        Map<String,Object>  j  = new HashMap<String, Object>();
        j.put("status",status);
        j.put("botNm",botNm);
        dbVO.setBotNm(botNm);
        dbVO.setStatus(status);
        System.out.println("J MAP  "+ j);
        System.out.println("상태 1 :"+status);
        System.out.println("상태 2 :"+botNm);
        return j;
    }

    @ResponseBody
    @RequestMapping(value = "/setStatus/offline.ajax", method = RequestMethod.POST)
    public Map<String, Object> setOffline(Model model ,DiscordBotVO dbVO) throws LoginException {
        jda.getPresence().setStatus(OnlineStatus.OFFLINE);
        String botNm = String.valueOf(jda.getSelfUser());
        String status = String.valueOf(jda.getPresence().getStatus());
        Map<String,Object>  j  = new HashMap<String, Object>();
        j.put("status",status);
        j.put("botNm",botNm);
        dbVO.setBotNm(botNm);
        dbVO.setStatus(status);
        System.out.println("J MAP  "+ j);
        System.out.println("상태 1 :"+status);
        System.out.println("상태 2 :"+botNm);
        return j;
    }


}

