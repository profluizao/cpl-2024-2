package ExemploSimples;

import java.util.HashMap;
import java.util.Map;

public class InventorySystem {
    
    public void Execute() {
        
        // Criação do HashMap para armazenar produtos
        HashMap<String, String> inventory = new HashMap<>();

        // Adicionando produtos ao inventário
        inventory.put("P001", "Notebook");
        inventory.put("P002", "Smartphone");
        inventory.put("P003", "Monitor");
        inventory.put("P004", "Teclado");
        
        // Exibindo o inventário inicial
        System.out.println("Inventário inicial:");
        displayInventory(inventory);

        // Verificando se um produto existe no inventário
        String productCode = "P002";
        if (inventory.containsKey(productCode)) {
            System.out.println("Produto encontrado: " + inventory.get(productCode));
        } else {
            System.out.println("Produto com o código " + productCode + " não encontrado.");
        }

        // Removendo um produto do inventário
        inventory.remove("P003");
        System.out.println("\nInventário após remoção:");
        displayInventory(inventory);

        // Atualizando um produto no inventário
        inventory.put("P001", "Notebook (Atualizado)");
        System.out.println("\nInventário após atualização:");
        displayInventory(inventory);

        // Exibindo todos os produtos com chave e valor
        System.out.println("\nLista completa de produtos:");
        for (Map.Entry<String, String> entry : inventory.entrySet()) {
            System.out.println("Código: " + entry.getKey() + " - Produto: " + entry.getValue());
        }
    }

    // Método para exibir o inventário
    private static void displayInventory(HashMap<String, String> inventory) {
        if (inventory.isEmpty()) {
            System.out.println("O inventário está vazio.");
        } else {
            inventory.forEach((code, name) -> System.out.println("Código: " + code + ", Produto: " + name));
        }
    }
}
