/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcrawlerso1;

import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author Brenan Wanderley
 */
public class BufferQueue implements Listenable{
    private List <String> fila = new LinkedList<>();  
    private Listener ouvinte;
    
    public void insert(String url){
        fila.add(url); 
        CallListener();
        
    }
    //@Override
    public void dispatcher(Listener listener){
        this.ouvinte = listener;
    }
    
    @Override
    public void CallListener(){
        String img = null;
        if(fila.isEmpty()==false){
            img = fila.remove(0);
            this.ouvinte.update(img);
        }
    }

}
