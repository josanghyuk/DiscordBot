//package com.example.discordbot.command;
//
//import com.sun.syndication.feed.synd.SyndCategoryImpl;
//import com.sun.syndication.feed.synd.SyndEntry;
//import com.sun.syndication.feed.synd.SyndFeed;
//import com.sun.syndication.io.SyndFeedInput;
//
//import javax.sql.rowset.spi.XmlReader;
//import java.net.URL;
//import java.util.List;
//
//public class RSSReaderA {
////    private static String url ="https://createfeed.fivefilters.org/extract.php?url=https%3A%2F%2Fwww.leagueoflegends.com%2Fko-kr%2Fnews%2Ftags%2Fpatch-notes%2F&item=li%5Bclass%5E%3D%22style__Item%22%5D&item_title=h2&item_desc=div%5Bclass%5E%3D%22style__Category%22%5D&item_date=time+%40datetime&item_image=img+%40src&unique_url=1&max=5&order=document&guid=0";
//
//    @SuppressWarnings("unchecked")
//    public static void start(String getUrl) throws Exception {
//
//        URL feedUrl = new URL(getUrl);
//        SyndFeedInput input = new SyndFeedInput();
////        SyndFeed syndFeed = input.build(new XmlReader(feedUrl));
//
//        /*RSS*/
//        System.out.println("### getFeedType 	[" + syndFeed.getFeedType() +"]");
//        System.out.println("### getLanguage 	[" + syndFeed.getLanguage() +"]");
//        System.out.println("### getTitle 		[" + syndFeed.getTitle() +"]");
//        System.out.println("### getPublishedDate 	[" + syndFeed.getPublishedDate() +"]");
//
//        List<SyndEntry> entries = syndFeed.getEntries();
//        SyndEntry entry = null;
//
//        /*발행정보*/
//        for(int i=0, j=entries.size(); i<j ; i++) {
//            entry = entries.get(i);
//            System.out.println("### getTitle 		[" + entry.getTitle() +"]");
//            System.out.println("### getUri 			[" + entry.getUri() +"]");
//            System.out.println("### getDescription 	[" + entry.getDescription().getValue() +"]");
//            System.out.println("### getPublishedDate[" + entry.getPublishedDate().getTime() +"]");
//
//            /*카테고리*/
//            StringBuffer cate = new StringBuffer();
//            if(entry.getCategories()!=null && entry.getCategories().size()>0){
//                for(int ii=0,jj=entry.getCategories().size(); ii<jj; ii++){
//                    SyndCategoryImpl ss = (SyndCategoryImpl)entry.getCategories().get(ii);
//                    cate.append(CommonUtils.replace(ss.getName(), " ", "") ).append(",");
//                }
//            }
//            System.out.println("### category		[" + cate.toString() +"]");
//        }
//    }
//    public static String stripTags(String text) {
//        if (text != null) {
//            return text.replaceAll("\\<.*?>","").trim();
//        } else {
//            return "";
//        }
//    }
//}