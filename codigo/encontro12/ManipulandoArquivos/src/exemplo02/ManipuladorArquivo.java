package exemplo02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManipuladorArquivo {

    // Método para ler o conteúdo do arquivo e exibir no console
    public static void leitor(String caminhoArquivo) {
        try{ 
            FileReader fileReader = new FileReader(caminhoArquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                System.out.println(linha);
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    // Método para escrever um texto no arquivo especificado
    public static void escritor(String caminhoArquivo, String conteudo) {
        try{
            FileWriter fileWriter = new FileWriter(caminhoArquivo);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(conteudo);
            System.out.println("Conteúdo escrito com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}

