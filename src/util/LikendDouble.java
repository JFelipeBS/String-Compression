package util;

public class LikendDouble<T> implements InterfaceDouble<T> {

    class Node {
        T data;
        Node next;
        Node prev;

        public Node(T elemente) {
            data = elemente;
            next = null;
            prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LikendDouble() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }

        return false;
    }

    @Override
    public void addFirst(T elemente) {

        Node novo = new Node(elemente);

        // Primeiro elemeto sendo adicionado
        if (head == null) {
            head = novo;
            tail = novo;
        } else {

            novo.next = head;
            head.prev = novo;
            head = novo;
        }

        size++;
    }

    @Override
    public void addLast(T elemente) {

        Node novo = new Node(elemente);

        // Primeiro elemeto sendo adicionado
        if (head == null) {
            head = novo;
            tail = novo;
        } else {

            novo.prev = tail;
            tail.next = novo;
            tail = novo;

        }

        size++;

    }

    @Override
    public void addAfter(T elemente, T criterio) {

        Node retorno = searchNode(criterio);

        if (retorno == null) {
            System.out.println("Null: Item nao existe");
        } else {

            Node novo = new Node(elemente);

            if (retorno.next == null) {
                tail = novo;
            }

            // adicionado no meio
            novo.next = retorno.next;
            novo.prev = retorno;
            retorno.next = novo;

            Node frente = novo.next;

            if (frente != null) {
                frente.prev = novo;
            }

            size++;
        }

    }

    @Override
    public T removeFirst() {

        T elemente = null;

        if (head == null) {
            System.out.println("Null: Lista Vazia");

        } else {

            Node aponta = head;

            elemente = aponta.data;

            // Um unico elemento na lista
            if (head == tail) {
                head = null;
                tail = null;

            } else {
                // mais de um elemento na lista
                head = head.next;
                head.prev = null;

                // isolar elemento
                aponta.next = null;

            }

            size--;

        }

        return elemente;
    }

    @Override
    public T removeLast() {

        T elemente = null;

        if (head == null) {
            System.out.println("Null: Lista Vazia");
            return elemente;
        } else {

            elemente = tail.data;

            if (tail == head) {
                head = null;
                tail = null;
            }

            Node antecessor = tail.prev;

            tail.prev = null;
            tail = antecessor;
            tail.next = null;

            size--;

        }
        return elemente;
    }

    @Override
    public T remove(T criterio) {

        T elemente = null;

        if (head == null) {
            System.out.println("Null: Lista Vazia");
            return elemente;
        }
        Node retorno = searchNode(criterio);
        Node antecessor = null;

        // evital um nullpoint
        if (retorno != null) {
            antecessor = retorno.prev;
        }

        // removendo do inicio
        if (antecessor == null) {

            if (head.data.equals(criterio) == false) {
                System.out.println("Null: Item nao existe");
            } else {
                return removeFirst();
            }

        } else {

            // removendo do final
            if (retorno == tail) {

                return removeLast();

            } else {

                // removendo do meio
                Node frente = retorno.next;

                antecessor.next = frente;
                frente.prev = antecessor;

                retorno.next = null;
                retorno.prev = null;

                size--;
                elemente = retorno.data;

                return elemente;

            }
        }
        return elemente;

    }

    private Node searchNode(T criterio) {

        Node aponta = head;

        while (aponta != null) {

            if (aponta.data.equals(criterio)) {
                return aponta;
            }

            aponta = aponta.next;
        }

        return null;

    }

    @Override
    public T search(T elemente) {

        Node retorno = searchNode(elemente);

        if (retorno == null) {

            return null;
        }

        return retorno.data;

    }

    @Override
    public void show() {
        Node aponta = head;

        if (head == null) {
            System.out.println("Null: Lista Vazia");
        } else {
            while (aponta != null) {

                System.out.print("[" + aponta.data + "] ");
                aponta = aponta.next;
            }
        }

    }

    @Override
    public T peekFirst() {

        if (head == null) {
            System.out.println("Null: Lista Vazia");
            return null;
        }

        return head.data;

    }

    @Override
    public T peekLast() {

        if (head == null) {
            System.out.println("Null: Lista Vazia");
            return null;
        }

        return tail.data;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    

}
