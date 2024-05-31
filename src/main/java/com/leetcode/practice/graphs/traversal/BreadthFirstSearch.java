package com.leetcode.practice.graphs.traversal;

import com.leetcode.practice.graphs.adt.GraphAdjacencyListADT;
import com.leetcode.practice.graphs.adt.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    private static final List<Integer> visitedNodes = new ArrayList<>();
    private static final Queue<Integer> explicitQueue = new LinkedList<>();

    public static void displayVisitedNodes() {
        visitedNodes.forEach(System.out::println);
        visitedNodes.clear();
        explicitQueue.clear();
    }

    public static void BFSTraversalIterative(GraphAdjacencyListADT graph, int startVertex) {
        explicitQueue.add(startVertex);
        while(!explicitQueue.isEmpty()) {
            int currentVertex = explicitQueue.poll();
            if(!visitedNodes.contains(currentVertex)) {
                visitedNodes.add(currentVertex);
                graph.getNeighbors(currentVertex).stream().filter(k -> !visitedNodes.contains(k))
                        .forEach(explicitQueue::add);
            }
        }
        displayVisitedNodes();
    }

    // BFS using recursion not an efficient solution as BFS uses queue and not stack but that said if anyone asks for it,
    // we can use queues inside the method call for the queue implementation.

    public static void BFSHelperFunction(GraphAdjacencyListADT graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        BFSTraversalRecursive(graph, queue);
        displayVisitedNodes();
    }

    public static void BFSTraversalRecursive(GraphAdjacencyListADT graph, Queue<Integer> queue) {
        if(queue.isEmpty()) return;
        int currentVertex = queue.poll();
        if(!visitedNodes.contains(currentVertex)) {
            visitedNodes.add(currentVertex);
            graph.getNeighbors(currentVertex).stream().filter(k -> !visitedNodes.contains(k))
                    .forEach(queue::add);
            BFSTraversalRecursive(graph, queue);
        }
    }

    public static void main(String[] args) {
        GraphAdjacencyListADT graphBFS = new GraphAdjacencyListADT();

        graphBFS.addVertex(0);
        graphBFS.addVertex(1);
        graphBFS.addVertex(2);
        graphBFS.addVertex(3);
        graphBFS.addVertex(4);
        graphBFS.addVertex(5);
        graphBFS.addVertex(6);

        graphBFS.addEdge(0, 1);
        graphBFS.addEdge(0, 2);
        graphBFS.addEdge(1, 3);
        graphBFS.addEdge(1, 4);
        graphBFS.addEdge(2, 5);
        graphBFS.addEdge(4, 5);

        List<Pair<Integer, Integer>> graphEdges = graphBFS.getEdges();

        System.out.printf("No of Vertices: %s && No of Edges: %s%nGet Edges:%n", graphBFS.getVertexCount(),
                graphBFS.getEdgeCount());

        graphEdges.forEach(k -> {
            System.out.printf("%s -> %s%n", k.getFirst(), k.getSecond());
        });

        System.out.println("BFS TRAVERSAL (USING ITERATIVE APPROACH): ");
        BFSTraversalIterative(graphBFS, 0);

        System.out.println("BFS TRAVERSAL (USING RECURSIVE APPROACH): ");
        BFSHelperFunction(graphBFS);
    }

}
