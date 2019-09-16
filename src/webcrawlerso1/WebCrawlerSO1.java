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
public class WebCrawlerSO1 {
    public static BufferQueue buffer = new BufferQueue();

    public static void main(String[] args) throws Exception {
        Event set = new Event();
        buffer.dispatcher(set);
        ReadFile.read("url.txt");
    }
}
