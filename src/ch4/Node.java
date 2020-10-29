package ch4;

public class Node {
    int value;
    boolean visited;
    Node[] children;
    int level;

    public Node(int value) {
        this.value = value;
    }

    public void setChildren(Node... nodes) {
        this.children = new Node[nodes.length];

        for (int i = 0; i < nodes.length; i++) {
            this.children[i] = nodes[i];
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Node[] getChildren() {
        return children != null ? children : new Node[0];
    }
}
