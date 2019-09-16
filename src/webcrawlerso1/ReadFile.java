/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcrawlerso1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Brenan Wanderley
 */
public class ReadFile {
    public static void read(String nome) throws IOException, Exception {
        Discovery thread;
        try {
              FileReader arq = new FileReader(nome);
              BufferedReader lerArq = new BufferedReader(arq);

              String linha = lerArq.readLine();
              while (linha != null) {
                    thread = new Discovery(linha);
                    thread.start();
                    System.out.printf("%s\n", linha);

                    linha = lerArq.readLine(); // lê da segunda até a última linha
              }

              arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
              e.getMessage());
        }
    }
}
