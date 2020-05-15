package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.Scanner;


public class wikibot {
    static Document doc;
    static Elements content = new Elements();
    static Elements pel = new Elements();
    static Elements refs = new Elements();
    static int point;
    static int point1;
    static boolean chance = true;
    static Scanner sc = new Scanner(System.in);

    public static void main(String [] args) {
        System.out.println("Make your request: ");
        String request = sc.nextLine();
        getReq(request);
    }
    public static void getRefers(){
        Elements ref2 = new Elements();
        for (int i = point1, j = 1; i < point1+5; i++,j++) {
            ref2.add(refs.get(i));
            System.out.print(j + "." + refs.get(i).attr("title") + "  ");
        }
        System.out.println("6. more info...    7. New request");
        int ref = -1;
        while(ref==-1) {
            ref = sc.nextInt();
            if (ref == 0) {
                System.out.println("Bye bye...");
            } else if (ref<6) {
                pel.clear();
                content.clear();
                System.out.println(ref2.get(ref-1).attr("title"));
                getReq(ref2.get(ref-1).attr("title"));
            }
            else if (ref == 6)
                moreInfo();
            else if (ref==7){
                System.out.println("Make request: ");
                String req = sc.nextLine();
                getReq(req);
            }
            else {
                System.out.println("Make correct input");
                ref = -1;
            }
        }
    }//get references from article

    private static void moreInfo() {
        String info = "";
        for (int i = point; i < point+2; i++)
            info += pel.get(i).text() + "\n";
        point += 2;
        point1 += 5;
        int i = 0;
        System.out.println(info);
        getRefers();
    }// get information text or supplement

    private static void getplist() {
        Elements li = content.select("li");
        for (int i = 0; i < li.size(); i++)
            System.out.println(i + 1 + ". " + li.get(i).text());
        int d = sc.nextInt();
        content.clear();
        getReq(li.get(d-1).getElementsByTag("a").get(0).attr("title"));

    }// get list of articles

    public  static void getReq(String query){
        query = query.substring(0, 1).toUpperCase() + query.substring(1);
        String q2 = query.replaceAll(" ", "_");
        chance = true;
        while (chance) {
            try {
                doc = Jsoup.connect("https://ru.wikipedia.org/wiki/" + q2).get();
                content = doc.getElementsByAttributeValue("class", "mw-parser-output").get(0).getAllElements();
                chance = false;
                if (content.text().contains("Список значений слова или словосочетания со ссылками на соответствующие статьи"))
                    getplist();
                else if(content.text().contains("В Википедии нет статьи")){
                    System.out.println("0. Exit \n Please, change your request:");
                    String s = sc.nextLine();
                    getReq(s);
                }
                else {
                    String tags = "p h2 h3 h4";
                    int first = 0;
                    for (int i = 0; i < 1000; i++) {
                        if (content.get(i).tagName().equals("p")) {
                            first = i;
                            break;
                        }
                    }
                    for (int i = first; i<content.size(); i++) {
                        if (content.get(i).text().contains("См. также") && content.get(i).className().equals("mw-headline"))
                            break;
                        else if (tags.contains(content.get(i).tagName()) && !content.get(i).parents().hasClass("reference"))
                            pel.add(content.get(i));
                    }
                    refs = new Elements();
                    for (int i = 0; i<pel.size(); i++) {
                        for (int j = 0; j < pel.get(i).getElementsByTag("a").size(); j++) {
                            if (pel.get(i).getElementsByTag("a").get(j).hasAttr("title"))
                                if (pel.get(i).getElementsByTag("a").get(j).hasClass("mw-editsection-visualeditor"))
                                    i++;
                                else
                                    refs.add(pel.get(i).getElementsByTag("a").get(j));
                        }
                    }
                    point = 0;
                    point1 = 0;
                    moreInfo();
                }
            } catch (Exception ignored){}//all exceptions to ignore

        }

    }// main operation
}