package com.example.discordbot.command;

import com.example.discordbot.VO.RSSItemVO;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class RSSReader {

    private static RSSReader instance = null;
    private URL rssURL;
    private RSSReader() {}
    public static List<RSSItemVO> LOLVO = new ArrayList<>();
    public static List<RSSItemVO> TFTVO = new ArrayList<>();
    public static List<RSSItemVO> LostVO = new ArrayList<>();
    public static List<RSSItemVO> MapleVO = new ArrayList<>();

    public static RSSReader getInstance() {
        if (instance == null)
            instance = new RSSReader();
        return instance;
    }

    public void setURL(URL url) {
        rssURL = url;
    }


    public void writeFeedLOL() {

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(rssURL.openStream());

            NodeList items = doc.getElementsByTagName("item");
            NodeList imgs = doc.getDocumentElement().getElementsByTagName("media:content");
            for (int ii = 0; ii < 3 /*items.getLength()*/; ii++) {
                RSSItemVO riVO = new RSSItemVO();
                System.out.println("index : " + ii);
                Element item = (Element) items.item(ii);
                Element itemImg = (Element) imgs.item(ii);

                riVO.setTitle(getValue((Element) items.item(ii), "title"));
                riVO.setLink(getValue((Element) items.item(ii), "link"));
                riVO.setPubDate(getValue((Element) items.item(ii), "pubDate"));
                riVO.setImage(((Element) imgs.item(ii)).getAttribute("url"));

                LOLVO.add(riVO);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void writeFeedTFT() {

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(rssURL.openStream());

            NodeList items = doc.getElementsByTagName("item");
            NodeList imgs = doc.getDocumentElement().getElementsByTagName("media:content");
            for (int ii = 0; ii < 3 /*items.getLength()*/; ii++) {
                RSSItemVO riVO = new RSSItemVO();
                System.out.println("index : " + ii);
                Element item = (Element) items.item(ii);
                Element itemImg = (Element) imgs.item(ii);

                riVO.setTitle(getValue((Element) items.item(ii), "title"));
                riVO.setLink(getValue((Element) items.item(ii), "link"));
                riVO.setPubDate(getValue((Element) items.item(ii), "pubDate"));
                riVO.setImage(((Element) imgs.item(ii)).getAttribute("url"));

                TFTVO.add(riVO);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void writeFeedLost() {

        try {
            LostVO = new ArrayList<>();
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(rssURL.openStream());

            NodeList items = doc.getElementsByTagName("item");

            for (int ii = 0; ii < 3; ii++) {
                RSSItemVO riVO = new RSSItemVO();
                System.out.println("index : " + ii);
                Element item = (Element) items.item(ii);

                riVO.setTitle(getValue((Element) items.item(ii), "title"));
                riVO.setDescription(getValue((Element) items.item(ii), "description"));
                riVO.setLink(getValue((Element) items.item(ii), "link"));
                LostVO.add(riVO);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void writeFeedMaple() {
        try {

            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(rssURL.openStream());

            NodeList items = doc.getElementsByTagName("item");

            for (int ii = 0; ii < 3 ; ii++) {
                RSSItemVO riVO = new RSSItemVO();
                System.out.println("index : " + ii);
                Element item = (Element) items.item(ii);

                riVO.setTitle(getValue((Element) items.item(ii), "title"));
                riVO.setLink(getValue((Element) items.item(ii), "link"));
                riVO.setPubDate(getValue((Element) items.item(ii), "pubDate"));
                MapleVO.add(riVO);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getValue(Element parent, String nodeName) {
        return parent.getElementsByTagName(nodeName).item(0).getFirstChild().getNodeValue();
    }

    public static void start(String getUrl, String type) {
        String inUrl = "";
        inUrl = getUrl;

        try {
            RSSReader reader = RSSReader.getInstance();
            reader.setURL(new URL(inUrl));
            if( type.equals("LOL")){
                reader.writeFeedLOL();
                System.out.println("LOL"+LOLVO.toString());
            }else if( type.equals("TFT")){
                reader.writeFeedTFT();
                System.out.println("TFT"+TFTVO.toString());
            }else if( type.equals("lost")){
                reader.writeFeedLost();
                System.out.println("lost"+LostVO.toString());
            }else if( type.equals("maple")){
                reader.writeFeedMaple();
                System.out.println("maple"+MapleVO.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

