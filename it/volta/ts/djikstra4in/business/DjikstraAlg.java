package it.volta.ts.djikstra4in.business;

import it.volta.ts.djikstra4in.bean.*;
import java.util.*;

/**
 * Given a positively weighted graph and a starting node (A), 
 * Dijkstra determines the shortest path and distance from the source to all destinations in the graph:
 * 
 * The core idea of the Dijkstra algorithm is to continuously eliminate longer paths between 
 * the starting node and all possible destinations.
 * To keep track of the process, we need to have two distinct sets of nodes, settled and unsettled.
 * 
 * Steps:
 * - Set distance to startNode to zero.
 * - Set all other distances to an infinite value.
 * - We add the startNode to the unsettled nodes set.
 * - While the unsettled nodes set is not empty we:
 *  - Choose an evaluation node from the unsettled nodes set, the evaluation node should be the one 
 *      with the lowest distance from the source.
 *  - Calculate new distances to direct neighbors by keeping the lowest distance at each evaluation.
 *  - Add neighbors that are not yet settled to the unsettled nodes set.
 */
public class DjikstraAlg {
    
    public static int Infinite = -1;

    private WeightedGraph graph;
    private List<PathNode> settled;
    private List<PathNode> unsettled;
    private List<PathNode> all;

    public DjikstraAlg(WeightedGraph graph) {
        this.graph = graph;
        this.settled = new ArrayList<>();
        this.unsettled = new ArrayList<>();
        this.all = new ArrayList<>();
    }

    public List<PathNode> getShortestPathFrom(Node from) {

        init(from);

        run();

        return settled;

    }

    private void run() {

        while(unsettled.size() > 0) {
            unsettled.sort( (PathNode node1, PathNode node2) ->  { 
                return (node1.getPathLength() <= node2.getPathLength() ? 1 : 0);
            } );
            PathNode current = unsettled.remove(0);
            this.settled.add(current);

            if(current.getNode() != null) {
                current.getNode().getNeighbors().forEach( n -> {
                    PathNode local = this.all.stream()
                        .filter( item -> item.getNode() != null && 
                            item.getNode().getNodeName().equals(n.getNext().getNodeName()))
                        .findFirst()
                        .get();
                    local.setPathLength(n.getWeight());
                    this.unsettled.add(local);
                });
            }

        }

    }

    /**
     * - Set distance to startNode to zero.
     * - Set all other distances to an infinite value.
     * - We add the startNode to the unsettled nodes set.
     * @param from Start Node
     */
    private void init(Node from) {
        this.all.clear();
        this.settled.clear();
        this.unsettled.clear();

        graph.getNodes().forEach((Node item) -> {

            if(!item.getNodeName().equals(from.getNodeName())){
                item.getNeighbors().forEach( (Arc n ) -> {
                    if(n.getNext() != null && n.getNext().getNodeName().equals(from.getNodeName())){
                        this.all.add(new PathNode(item, Infinite));
                    } 
                } );
                
            } else {
                PathNode pn = new PathNode(item, 0);
                this.settled.add(pn);
                this.all.add(pn);
            }

        } );
    }

}
