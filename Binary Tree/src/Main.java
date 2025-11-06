import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        List<Integer> meusNumeros = Arrays.asList(2, 4, 0, 3, 9, 6, 4);

        BinarySearchTree bst = new BinarySearchTree();

        System.out.println("Construindo a árvore com: " + meusNumeros);
        for (int num : meusNumeros) {
            bst.inserir(num);
        }

        bst.imprimirProfundidade();
    }


    static class Node {
        int key;
        Node left;
        Node right;


        public Node(int item) {
            key = item;
            left = null;
            right = null;
        }
    }


    static class BinarySearchTree {

        private Node root;


        public BinarySearchTree() {
            root = null;
        }

        public void inserir(int key) {
            root = inserirRec(root, key);
        }

        private Node inserirRec(Node root, int key) {
            if (root == null) {
                root = new Node(key);
                return root;
            }

            if (key < root.key) {
                root.left = inserirRec(root.left, key);
            } else if (key > root.key) {
                root.right = inserirRec(root.right, key);
            }

            return root;
        }


        public void imprimirProfundidade() {
            System.out.println("\n--- Impressão por Profundidade (Pré-Ordem) ---");
            // Chama a função recursiva, começando na raiz (root) e profundidade 0
            imprimirProfundidadeRec(this.root, 0);
            System.out.println("----------------------------------------------");
        }

        private void imprimirProfundidadeRec(Node node, int depth) {

            if (node == null) {
                return;
            }

            StringBuilder prefixo = new StringBuilder();
            for (int i = 0; i < depth; i++) {

                prefixo.append("- ");
            }

            System.out.println(prefixo.toString() + node.key);


            imprimirProfundidadeRec(node.left, depth + 1);

            imprimirProfundidadeRec(node.right, depth + 1);
        }
    }
}