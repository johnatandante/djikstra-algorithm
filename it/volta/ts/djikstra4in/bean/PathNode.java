package it.volta.ts.djikstra4in.bean;

public class PathNode {

    private Node node;
    private int pathLength;

    public PathNode(Node node, int pathLength) {
        this.node = node;
        this.pathLength = pathLength;
    }

    public Node getNode() {
        return this.node;
    }

    public int getPathLength() {
        return this.pathLength;
    }

    public void setPathLength(int value) {
        this.pathLength = value;
    }

}
