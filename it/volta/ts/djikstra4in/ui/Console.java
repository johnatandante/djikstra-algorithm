package it.volta.ts.djikstra4in.ui;

import it.volta.ts.djikstra4in.bean.*;
import it.volta.ts.djikstra4in.business.DjikstraAlg;

import java.util.*;

public class Console {
    
    DjikstraAlg djikstraAlg;

    /**
     * In Args ci sono le liste di adiacenza nella forma
     *  A|B:2|C1 B|C:22 C|A:23|D:10 D|A:1 
     * @param args liste di adiacenza
     */
    public Console(String[] args) {

        WeightedGraph graph = new WeightedGraph();


        // in ogni "arg" ci sarà un nodo con le sue liste di adiacenza
        for(int i = 0; i < args.length; i++) {

            String input = args[i];
            
            String[] items = input.split("|");
            for(int j = 1; j < items.length;j++){

                
                String[] subitems = items[j].split(":");

                Node node = new Node(subitems[j]);
                
                graph.addNode(node);
            }

        }

        djikstraAlg = new DjikstraAlg(graph);

    }

    public void run() {

        Node startNode = new Node("A");

        List<PathNode> paths = djikstraAlg.getShortestPathFrom(startNode);
        paths.forEach( node -> System.out.printf("Distance to %s: %d", node.getNode().getNodeName(), node.getPathLength()) );

    }

}
