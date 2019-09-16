/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcrawlerso1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Brenan Wanderley
 */
public class Discovery extends Thread{
    private String site;
    
    public Discovery(String site){
        this.site = site;
    }
    
    @Override
    public void run() {
        try {
            String html;
            int cont = 0;
            html = getHTML(site);
            String regex = "http(s?)://([\\w-]+\\.)+[\\w-]+(/[\\w- ./]*)+\\.(?:[gG][iI][fF]|[jJ][pP][gG]|[jJ][pP][eE][gG]|[pP][nN][gG]|[bB][mM][pP])";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(html);
            String url;
            while (m.find()) {
                url = m.group();
                WebCrawlerSO1.buffer.insert(url);
                cont++;
            }
            System.out.println("Foram encontradas "+cont+" imagens no site: "+site);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
    private static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        InputStreamReader isr = new InputStreamReader(conn.getInputStream());
        BufferedReader rd = new BufferedReader(isr);
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }
    
}
