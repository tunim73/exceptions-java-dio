package br.com.dio.exceptions;

import javax.swing.*;
import java.io.*;

//Imprimir um arquivo no console.
public class CheckedException {
    public static void main(String[] args) {
        String nomeDoArquivo = "romance-blake-crouch.txt";

        try {
            imprimirArquivoNoConsole(nomeDoArquivo);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Revise o nome do arquivo que você deseja imprimir! " + e.getCause());
            e.printStackTrace();
        } catch (IOException e){
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Ocorreu um erro inesperado! Entre em contato com o suporte! " + e.getCause());
        } finally {
            System.out.println("Chegou no finally!");
        }

        System.out.println("Apesar da exception ou não, o programa continua...");
    }

    public static void imprimirArquivoNoConsole(String nomeDoArquivo) throws IOException { 
        
        /* Aqui  ocorre a abertura e leitura de arquivos e são utilizados métodos que exigem que seja feito
        o tratamento das exceções. Então de duas uma...
        - Ou você trata o a exception aqui, dentro do método, com try e catch.
        - Ou você lança uma exception para quem chamar esse método, imprimirArquivoNoConsole, quem chamar vai ser obrigado a fazer um try catch. ou simplesmente lançar uma exception para o próximo método que o chamou, até chegar a main.

        Obs. se ir de método a método não tratando a exception e deixando para o método main, e no método main não tratar, e simplesmente lançar a exception no main mesmo, o compilador irá parar de reclamar, mas se a exception 
        for lançada durante a execução o interpretador pegará e irá parar o programa como de praste.  
        
        , quem chamar esse método será obrigado a 
        
        */
        File file = new File(nomeDoArquivo);

        BufferedReader br = new BufferedReader(new FileReader(file.getName()));
        String line = br.readLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        do{
            bw.write(line);
            bw.newLine();
            line=br.readLine();
        } while(line != null);
        bw.flush();
        br.close();
    }
}
