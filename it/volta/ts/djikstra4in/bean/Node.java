package it.volta.ts.djikstra4in.bean;

import java.util.ArrayList;
import java.util.List;

public class Node {
    
    private static int nodes = 0;
    private String nodeName;
    private List<Arc> neighbors;

    public Node() {
        this.neighbors = new ArrayList<Arc>();
        this.nodeName = String.valueOf(++nodes);
    }

    public Node(String nodeName) {
        this.neighbors = new ArrayList<>();
    }

    public String getNodeName() {
        return this.nodeName;
    }

    public List<Arc> getNeighbors() {
        return this.neighbors;
    }

}
