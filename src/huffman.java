import Node.Heap;
import Node.Node;
import util.LikendDouble;

public class huffman {

    Node root;
    Node[] codifique;
    Heap listPriority;
    int temp = 0;

    public void bildTree(int n, Node[] caracteres) {

        listPriority = new Heap();

        for (int i = 0; i < n; i++) {

            listPriority.insert(caracteres[i]);

        }

        codifique = new Node[listPriority.size()];
        root = null;

        while (listPriority.size() > 1) {

            Node x = listPriority.remove();
            Node y = listPriority.remove();

            Node z = new Node('-', x.getFc() + y.getFc(), x, y);

            listPriority.insert(z);

        }

        root = listPriority.getFirst();

        if (root == null) {
            root = listPriority.getFirst();
        }

    }

    public String stringComprim(String origin) {

        code(root, "");
        String strigncomp = "";
        for (int i = 0; i < origin.length(); i++) {

            for (int j = 0; j < codifique.length; j++) {

                if (codifique[j].getCharacter() == origin.charAt(i)) {
                    strigncomp += codifique[j].getBits();
                    break;
                }
            }
        }

        return strigncomp;
    }

    public void code(Node no, String s) {

        if (no.getPrev() == null && no.getNext() == null) {

            no.setBits(s);
            codifique[temp] = new Node(no.getCharacter(), no.getBits());
            temp++;
            return;

        }

        code(no.getPrev(), s + "0");
        code(no.getNext(), s + "1");

    }

    

    public void printNivel() {

        LikendDouble<Node> queu = new LikendDouble<Node>();

        int size = 0;

        queu.addLast(root);
        Node temp;

        while (!queu.isEmpty()) {
            size = queu.getSize();

            // loop por niveis
            while (size-- > 0) {
                temp = queu.removeFirst();

                if (temp.getPrev() != null) {
                    queu.addLast(temp.getPrev());
                }

                if (temp.getNext() != null) {
                    queu.addLast(temp.getNext());
                }

                System.out.print(temp.getCharacter() + "/" + temp.getFc());
                System.out.print("    ");
            }

            System.out.println();

        }

    }

    

    public void imprimir() {
        System.out.println("Tabela de codificada");
        imprimir(root, "");
    }

    public void imprimir(Node no, String s) {

        if (no.getPrev() == null && no.getNext() == null) {
            System.out.println(no.getCharacter() + ": " + s);
            return;

        }

        imprimir(no.getPrev(), s + "0");
        imprimir(no.getNext(), s + "1");

    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

}