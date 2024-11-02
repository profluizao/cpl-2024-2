public class App {
    public static void main(String[] args) throws Exception {
        BufferExample bufferExample = new BufferExample();

        // Adicionando dados ao buffer secundário
        bufferExample.addToSecondaryBuffer("Token1");
        bufferExample.addToSecondaryBuffer("Token2");
        bufferExample.addToSecondaryBuffer("Token3");

        // Transferindo dados para o buffer primário
        bufferExample.transferToPrimaryBuffer();

        // Processando os dados do buffer primário
        bufferExample.processPrimaryBuffer();

        // Adicionando mais dados ao buffer secundário
        bufferExample.addToSecondaryBuffer("Token4");
        bufferExample.addToSecondaryBuffer("Token5");

        // Transferindo e processando novamente
        bufferExample.transferToPrimaryBuffer();
        bufferExample.processPrimaryBuffer();
    }    
}
