package Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Heap {

    List<Node> listNos;
    private Random random = new Random();

    public Heap() {
        this.listNos = new ArrayList<Node>();
    }

    // metodo auxiliar
    public int piso(double numPiso) {
        return (int) numPiso;
    }

    // subir elementos
    public void rise(int i) {

        int indexFather; // índice do pai de i
        Node temp;

        indexFather = piso((i - 1) / 2);

        if (indexFather >= 0 && this.listNos.get(i).getFc() < this.listNos.get(indexFather).getFc()) {

            // troca de posição
            temp = this.listNos.get(i);
            this.listNos.set(i, this.listNos.get(indexFather));
            this.listNos.set(indexFather, temp);

            // verificar se o valor de IndexFather sobe recursivamente
            rise(indexFather);

        } else if (indexFather >= 0 && this.listNos.get(i).getFc() == this.listNos.get(indexFather).getFc()) {

            // 0 ou 1
            int test = random.nextInt(2);

            if (test == 0) {

                temp = this.listNos.get(i);
                this.listNos.set(i, this.listNos.get(indexFather));
                this.listNos.set(indexFather, temp);

                // verificar se o valor de IndexFather sobe recursivamente
                rise(indexFather);
            }

        }

    }

    // descer elementos
    public void descend(int i, int tamHeap) {

        int indexSon; // índice do filho de i
        Node temp;

        // define um numero aleatorio 0 ou 1
        int test = random.nextInt(2);

        indexSon = (2 * i + 1);

        if (indexSon < tamHeap) {

            if (indexSon < tamHeap - 1) {

                if (this.listNos.get(indexSon).getFc() > this.listNos.get(indexSon + 1).getFc()) {
                    indexSon++;
                } else if (this.listNos.get(indexSon).getFc() == this.listNos.get(indexSon + 1)
                        .getFc()) {

                    if (test == 0) {
                        indexSon++;
                    }

                }
            }

            // caso o filho seja menor que o pai, troca posiçoes
            if (this.listNos.get(indexSon).getFc() < this.listNos.get(i).getFc()) {

                temp = this.listNos.get(i);
                this.listNos.set(i, this.listNos.get(indexSon));
                this.listNos.set(indexSon, temp);

                descend(indexSon, tamHeap);

                // caso o filho seja igual ao pai
            } else if (this.listNos.get(indexSon).getFc() == this.listNos.get(i).getFc()) {

                if (test == 0) {

                    temp = this.listNos.get(i);
                    this.listNos.set(i, this.listNos.get(indexSon));
                    this.listNos.set(indexSon, temp);
                }

            }

        }

    }

    public void insert(Node element) {

        int tamHeap = this.listNos.size();

        if (tamHeap == 0) {
            this.listNos.add(element);
        } else {

            listNos.add(element);
            rise(tamHeap - 1);
        }

    }

    public Node remove() {

        Node deleted = listNos.get(0);
        int tamHeap = this.listNos.size();

        if (listNos.size() != 0) {

            this.listNos.set(0, this.listNos.get(tamHeap - 1));
            this.listNos.remove(tamHeap - 1);

            descend(0, --tamHeap);

            return deleted;
        }

        return null;
    }

    // algoritmo dos nos internos
    public void build() {

        int tamHeap = this.listNos.size();

        for (int i = ((tamHeap - 1) / 2); i >= 0; i--) {
            descend(i, tamHeap);
        }

    }

    public void heapsort() {
        int tamHeap = listNos.size();
        int tamCurrente = tamHeap;

        build();

        Node temp;
        for (int i = tamHeap -1; i >=0 ; i--) {
            
            temp = listNos.get(i);
            listNos.set(i, listNos.get(0));
            listNos.set(0, temp);

            tamCurrente--;
            descend(0, tamCurrente);

        }
    }

    public void showProcess() {

        for (int i = 0; i < listNos.size(); i++) {
            System.out.println(listNos.get(i));
        }

    }

    public List<Node> getList() {
        return listNos;
    }

    public int size() {
        return listNos.size();

    }

    public Node getFirst() {
        return listNos.get(0);

    }

    public void setListProcess(List<Node> listNos) {
        this.listNos = listNos;
    }

}