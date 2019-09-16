/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcrawlerso1;

/**
 *
 * @author Brenan Wanderley
 */
public class Event implements Listener{
    private int num=0;
    
    @Override
    public void update(String img){
        Extractor thread = new Extractor(img,num);
        thread.start();
        num++;
    }
    
}
