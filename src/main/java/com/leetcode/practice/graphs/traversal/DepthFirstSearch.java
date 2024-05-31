package com.leetcode.practice.graphs.traversal;

import com.leetcode.practice.graphs.adt.GraphAdjacencyListADT;
import com.leetcode.practice.graphs.adt.Pair;

import java.util.*;

public class DepthFirstSearch {

    private static final List<Integer> visitedNodes = new ArrayList<>();
    private static final Stack<Integer> explicitStack = new Stack<>();

    public static void displayVisitedNodes() {
        visitedNodes.forEach(System.out::println);
        visitedNodes.clear();
        explicitStack.clear();
    }

    public static void DFSTraversalIterative(GraphAdjacencyListADT graph, int startVertex) {
        int currentVertex;
        ArrayList<Integer> relatedNodes;

        explicitStack.push(startVertex);

        while(!explicitStack.isEmpty()) {
            currentVertex = explicitStack.pop();
            if(!visitedNodes.contains(currentVertex)) {
                visitedNodes.add(currentVertex);
                relatedNodes = graph.getNeighbors(currentVertex);
                if (relatedNodes != null) {
                    relatedNodes.stream().filter(k -> !visitedNodes.contains(k)).forEach(explicitStack::push);
                }
            }
        }
        displayVisitedNodes();
    }

    public static void DFSTraversalRecursive(GraphAdjacencyListADT graph, int startVertex) {
        if(!visitedNodes.contains(startVertex)) {
            visitedNodes.add(startVertex);
            graph.getNeighbors(startVertex)
                    .stream()
                    .filter(k -> !visitedNodes.contains(k))
                    .forEach(k -> DFSTraversalRecursive(graph, k));
        }
    }

    public static void main(String[] args) {

        GraphAdjacencyListADT graph = new GraphAdjacencyListADT();

        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(0, 3);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 4);
        graph.addEdge(1, 2);

        List<Pair<Integer, Integer>> graphEdges = graph.getEdges();

        System.out.printf("No of Vertices: %s && No of Edges: %s%nGet Edges:%n", graph.getVertexCount(),
                graph.getEdgeCount());

        graphEdges.forEach(k -> {
            System.out.printf("%s -> %s%n", k.getFirst(), k.getSecond());
        });

        System.out.println("DFS TRAVERSAL (USING ITERATIVE APPROACH): ");
        DFSTraversalIterative(graph, 0);

        System.out.println("DFS TRAVERSAL (USING RECURSIVE APPROACH): ");
        DFSTraversalRecursive(graph, 0);
        displayVisitedNodes();
    }

}
