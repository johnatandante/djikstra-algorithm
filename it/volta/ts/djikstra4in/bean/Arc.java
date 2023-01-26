package it.volta.ts.djikstra4in.bean;

public class Arc {
    
    private int weight;
    private Node next;

    public Arc(Node next, int weight) {
        this.weight = weight;
        this.next = next;
    }

    public int getWeight() {
        return this.weight;
    }

    public Node getNext() {
        return this.next;
    }


}
