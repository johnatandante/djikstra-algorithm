package it.volta.ts.djikstra4in.bean;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
    
    private List<Node> nodes; 

    public WeightedGraph() {
     
        this.nodes = new ArrayList<>();

    }

    public void addNode(Node node) {

        if(node != null && 
            nodes.indexOf(node) < 0) {
            nodes.add(node);
            
            for(int i = 0; i < node.getNeighbors().size(); i++){
                Arc arc = node.getNeighbors().get(i);
                this.addNode(arc.getNext());
            }

        }

    }

    public List<Node> getNodes() {
        return this.nodes;
    }

}
