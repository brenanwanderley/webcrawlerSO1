/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcrawlerso1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Brenan Wanderley
 */
public class Extractor extends Thread{
    private String imgUrl;
    private int n;
    
    public Extractor(String imgUrl, int n){
        this.imgUrl=imgUrl;
        this.n=n;
    }
    
    @Override
    public void run(){
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String destino = "C:\\Users\\Brenan Wanderley\\Documents\\NetBeansProjects\\WebCrawlerSO1\\imgExtracted\\";
        //System.out.println(imgUrl);
        try {
            URL url = new URL(imgUrl);
            inputStream = url.openStream();
            outputStream = new FileOutputStream(destino + "imgExt" + n + ".png");

            byte[] buffer = new byte[2048];
            int length;

            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            inputStream.close();
            outputStream.close();

        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException :- " + e.getMessage());

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException :- " + e.getMessage());

        } catch (IOException e) {
            ////System.out.println("IOException :- " + e.getMessage());

        }
    }
}
