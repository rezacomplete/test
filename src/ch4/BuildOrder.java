package ch4;

import java.util.*;

public class BuildOrder {

    static class GraphNode {
        char value;
        LinkedList<GraphNode> parents = new LinkedList<>();
        LinkedList<GraphNode> children = new LinkedList<>();
    }

    static class Graph {
        LinkedList<GraphNode> nodes = new LinkedList<>();
    }

    static class Dependency {
        char first;
        char second; //depends on first

        public Dependency(char first, char second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        LinkedList<Character> projects = new LinkedList<>();
        projects.add('a');
        projects.add('b');
        projects.add('c');
        projects.add('d');
        projects.add('e');
        projects.add('f');

        LinkedList<Dependency> dependencies = new LinkedList<>();
        dependencies.add(new Dependency('a', 'd'));
        dependencies.add(new Dependency('f', 'b'));
        dependencies.add(new Dependency('b', 'd'));
        dependencies.add(new Dependency('f', 'a'));
        dependencies.add(new Dependency('d', 'c'));

        printBuildSequence(projects, dependencies);
    }

    public static void printBuildSequence(LinkedList<Character> projects, LinkedList<Dependency> dependencies) {
        Graph graph = buildDependencyGraph(dependencies, projects);

        Set<GraphNode> toBeRemovedFromGraphSet = new HashSet<>();

        while(!graph.nodes.isEmpty()) {
            for (GraphNode node : graph.nodes) {
                if (node.parents.isEmpty()) {
                    System.out.println(node.value);

                    for (GraphNode child : node.children) {
                        child.parents.remove(node);
                    }
                    node.children.clear();
                    toBeRemovedFromGraphSet.add(node);
                }
            }

            graph.nodes.removeAll(toBeRemovedFromGraphSet);
        }
    }

    private static Graph buildDependencyGraph(LinkedList<Dependency> dependencies, LinkedList<Character> projects) {
        Map<Character, GraphNode> map = new HashMap<>();

        for (Dependency d : dependencies) {
            GraphNode node1;
            if (!map.containsKey(d.first)) {
                node1 = new GraphNode();
                node1.value = d.first;
                map.put(node1.value, node1);
            } else {
                node1 = map.get(d.first);
            }

            GraphNode node2;
            if (!map.containsKey(d.second)) {
                node2 = new GraphNode();
                node2.value = d.second;
                map.put(node2.value, node2);
            } else {
                node2 = map.get(d.second);
            }

            node1.children.add(node2);
            node2.parents.add(node1);
        }

        for (Character c : projects) {
            if (!map.containsKey(c)) {
                GraphNode gn = new GraphNode();
                gn.value = c;
                map.put(c, gn);
            }
        }

        Graph graph = new Graph();
        graph.nodes.addAll(map.values());

        return graph;
    }
}
