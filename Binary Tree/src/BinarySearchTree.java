import java.util.List;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void construirEImprimir(List<Integer> numeros) {
        System.out.println("Iniciando a construção da árvore com os números: " + numeros);

        for (int num : numeros) {
            this.inserir(num);
        }

        System.out.println("\n--- Representação Visual da Árvore (deitada) ---");
        System.out.println("(A raiz fica mais à esquerda e a árvore 'cresce' para a direita)\n");
        imprimirArvoreVisual(this.root, 0);
        System.out.println("\n-------------------------------------------------");

        imprimirInOrder(this.root);
        System.out.println("\n-------------------------------------------------");
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

    private void imprimirArvoreVisual(Node node, int space) {
        final int COUNT = 5; // Define o espaçamento entre os níveis

        if (node == null) {
            return;
        }

        space += COUNT;

        imprimirArvoreVisual(node.right, space);

        System.out.println();
        for (int i = COUNT; i < space; i++) {
            System.out.print(" ");
        }
        System.out.println(node.key);

        imprimirArvoreVisual(node.left, space);
    }

    private void imprimirInOrder(Node node) {
        if (node != null) {
            imprimirInOrder(node.left);
            System.out.print(node.key + " ");
            imprimirInOrder(node.right);
        }
    }
}