package Node;

public class Node {

    private char character;
    private int fc; // frequency counter
    private String bits;
    private int nivel;

    private Node next;
    private Node prev;

    public Node(char character) {
        this.character = character;
        this.fc = 1;
        this.next = null;
        this.prev = null;
    }

    public Node(char character, String bits) {
        this.character = character;
        this.bits = bits;
        this.fc = 1;
        this.next = null;
        this.prev = null;
    }

    public Node(char character, int fc, Node next, Node prev) {
        this.character = character;
        this.fc = fc;
        this.next = next;
        this.prev = prev;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getFc() {
        return fc;
    }

    public void setFc(int fc) {
        this.fc = fc;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public String getBits() {
        return bits;
    }

    public void setBits(String bits) {
        this.bits = bits;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Node [character=" + character + "fc=" + fc + "]";
    }

}
