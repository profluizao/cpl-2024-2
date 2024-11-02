import java.util.LinkedList;
import java.util.Queue;

public class BufferExample {
    private static final int BUFFER_SIZE = 5; // Tamanho do buffer
    private Queue<String> primaryBuffer = new LinkedList<>(); // Buffer primário
    private Queue<String> secondaryBuffer = new LinkedList<>(); // Buffer secundário

    // Método para adicionar dados ao buffer secundário
    public void addToSecondaryBuffer(String data) {
        if (secondaryBuffer.size() < BUFFER_SIZE) {
            secondaryBuffer.offer(data);
            System.out.println("Adicionado ao buffer secundário: " + data);
        } else {
            System.out.println("Buffer secundário cheio. Não é possível adicionar: " + data);
        }
    }

    // Método para transferir dados do buffer secundário para o buffer primário
    public void transferToPrimaryBuffer() {
        while (!secondaryBuffer.isEmpty() && primaryBuffer.size() < BUFFER_SIZE) {
            String data = secondaryBuffer.poll(); // Remove do buffer secundário
            primaryBuffer.offer(data); // Adiciona ao buffer primário
            System.out.println("Transferido para o buffer primário: " + data);
        }
    }

    // Método para processar os dados do buffer primário
    public void processPrimaryBuffer() {
        while (!primaryBuffer.isEmpty()) {
            String data = primaryBuffer.poll(); // Remove do buffer primário
            System.out.println("Processando: " + data);
        }
    }
}
