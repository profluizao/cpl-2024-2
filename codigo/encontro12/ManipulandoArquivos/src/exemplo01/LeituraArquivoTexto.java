package exemplo01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeituraArquivoTexto {
    public static void Executar() {
        // Definindo o caminho do arquivo
        String caminhoArquivo = "caminho/do/seu/arquivo.txt";

        // Usando FileReader e BufferedReader para leitura
        try (FileReader fileReader = new FileReader(caminhoArquivo);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                System.out.println(linha);
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}