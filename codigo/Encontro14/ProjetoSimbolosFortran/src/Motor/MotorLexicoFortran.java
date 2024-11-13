package Motor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MotorLexicoFortran {

    private final String captureComment = "^(?:\\s*[cC]|\\s*!).*";
    private final String captureNumbers = "(?<!\\w)(?:-?\\d+(?:\\.\\d+)?)(?!\\w)";
    private final String captureLiteral = "'(?:[^']|'')*'";
    private final String captureWords   = "\\w+";
    private final String captureCharacters = "(?::=|>=|<=|<>|>|<|=|\\+|\\-|\\*|\\/|[:;,.()\\[\\]{}])";
    private final String captureIdentifier = "^[A-Za-z][A-Za-z0-9_]*$";
    private String capture;

    private BufferedReader reader;

    private ArrayList<String> bufferPrimario;
    private ArrayList<String> bufferSecundario;

    public void CarregarArquivo(String caminhoCompleto) {
        System.out.println("----------------------------------------");
        System.out.println("##### Carregar Arquivo Texto #####");
        this.CarregarBufferPrimario(caminhoCompleto);
    }

    private void CarregarBufferPrimario(String caminhoCompleto) {
        this.reader = null;
        try {
            this.reader = new BufferedReader(new FileReader(caminhoCompleto));
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public void ProcessarBufferPrimario() {
        this.bufferPrimario = new ArrayList<>();
        try {
            String linha;
            while ((linha = this.reader.readLine()) != null) {
                bufferPrimario.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Erro ao fechar o arquivo: " + e.getMessage());
                }
            }
        }
    }

    public void ImprimirBufferPrimario(){
        System.out.println("----------------------------------------");
        System.out.println("##### Conteúdo do Buffer primário: #####");
        for (String texto : this.bufferPrimario) {
            System.out.println(texto);
        }
        System.out.println("----------------------------------------");        
    }

    public void ProcessarBufferSecundario()
    {        
        this.capture = captureComment.concat("|")
            .concat(captureNumbers).concat("|")
            .concat(captureLiteral).concat("|")
            .concat(captureWords).concat("|")
            .concat(captureCharacters);

        this.bufferSecundario = new ArrayList<>();

        Pattern pattern = Pattern.compile(this.capture);

        for (String texto : bufferPrimario) {
            Matcher matcher = pattern.matcher(texto);
            while(matcher.find()){
                String lexema = matcher.group();
                if (this.bufferSecundario.contains(lexema) == false){
                    this.bufferSecundario.add(lexema);
                }
            }
        }
        bufferSecundario.removeIf(value -> value.startsWith("//") || value.startsWith("(*"));
    } 

    public void ImprimirBufferSecundario(){
        System.out.println("----------------------------------------");
        System.out.println("##### Conteúdo do Buffer secundário: #####");
        for (String texto : this.bufferSecundario) {
            System.out.println(texto);
        }
        System.out.println("----------------------------------------");        
    }     
}