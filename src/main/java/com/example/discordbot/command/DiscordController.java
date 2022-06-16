package com.example.discordbot.command;


import com.example.discordbot.VO.DiscordBotVO;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Controller
public class DiscordController {

    private setToken botToken;

    @Autowired
    public DiscordController(setToken botToken) throws LoginException {

        this.botToken = botToken;
    }
       JDA jda = setToken.setBot();

    /**
     * 기능
     * @return jsp
     */
    @RequestMapping(value = "/")
    public String home(Model model) {

//        jda.getPresence().setStatus(OnlineStatus.OFFLINE);
        String botNm = String.valueOf(jda.getSelfUser());
        String status = String.valueOf(jda.getPresence().getStatus());

        System.out.println("home   ");


        model.addAttribute("botNm",botNm);
        model.addAttribute("status",status);
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/discord/setOnline.ajax", method = RequestMethod.POST)
    public Map<String, Object> setOnline(DiscordBotVO dbVO){


//        JDA jda = JDABuilder.createDefault(test).build();

        System.out.println("SET ONLINE ");
        System.out.println("VO "+dbVO.toString());

        jda.getPresence().setStatus(OnlineStatus.ONLINE);


        String botNm = String.valueOf(jda.getSelfUser());
        String status = String.valueOf(jda.getPresence().getStatus());
        if(Objects.equals(status, "ONLINE")) {
            jda.addEventListener(new MsgEvent());
        }

        Map<String,Object>  j  = new HashMap<String, Object>();
        j.put("status",status);
        j.put("botNm",botNm);
//        dbVO.setBotNm(botNm);
//        dbVO.setStatus(status);
        System.out.println("봇 상태 :"+status);
        System.out.println("봇 이름:"+botNm);
        return j;
    }

    @ResponseBody
    @RequestMapping(value = "/discord/setOffline.ajax", method = RequestMethod.POST)
    public Map<String, Object> setOffline(DiscordBotVO dbVO){


//        JDA jda = JDABuilder.createDefault(test).build();
        jda.getPresence().setStatus(OnlineStatus.OFFLINE);
        jda.shutdownNow(); // JDA 인스턴스를 즉시 종료하고 모든 연결을 닫습니다.
        jda.removeEventListener(new MsgEvent());
        String botNm = String.valueOf(jda.getSelfUser());
        String status = String.valueOf(jda.getPresence().getStatus());
        Map<String,Object>  j  = new HashMap<String, Object>();
        j.put("status",status);
        j.put("botNm",botNm);
//        dbVO.setBotNm(botNm);
//        dbVO.setStatus(status);

        System.out.println("봇 상태 :"+status);
        System.out.println("봇 이름:"+botNm);
        return j;
    }

//    @ResponseBody
//    @RequestMapping(value = "/discord/eventList.ajax", method = RequestMethod.POST)
//    public Map<String, Object> eventList(Model model ,DiscordBotVO dbVO) throws LoginException {
//
//
////        JDA jda = JDABuilder.createDefault(test).build();
//        String msg = String.valueOf(jda.getEventManager());
//
//        Map<String,Object>  j  = new HashMap<String, Object>();
//        j.put("msg",msg);
//
//        System.out.println("J MAP  "+ j);
//        System.out.println("MSG  :"+msg);
//        return j;
//    }

}

