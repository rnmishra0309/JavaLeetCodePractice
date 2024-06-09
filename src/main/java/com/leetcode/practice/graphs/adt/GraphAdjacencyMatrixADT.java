package com.leetcode.practice.graphs.adt;

/*

Operations that can be performed on any graphs:

    1. Adding a new vertex
    2. Removing a vertex
    3. Adding an edge between two vertices
    4. Removing an edge between two vertices
    5. Getting a list of all the vertices
    6. Checking if two graph nodes are adjacent to each other or not
    7. Getting count of the total vertices in the graph
    8. Getting count of the total edges in the graph
    9. Getting a list of the graph edges
    10. Getting neighbors of a graph vertex
    11. Graph Traversal
    12. Graph Searching

 */

import java.util.*;

public class GraphAdjacencyMatrixADT {

    private static boolean[][] graph;

    public GraphAdjacencyMatrixADT(int vertices) {
        graph = new boolean[vertices][vertices];
    }

    public GraphAdjacencyMatrixADT(boolean[][] graph) {
        GraphAdjacencyMatrixADT.graph = graph;
    }

    public void addEdge(int source, int destination) {
        graph[source][destination] = Boolean.TRUE;
        graph[destination][source] = Boolean.TRUE;
    }

    public void removeEdge(int source, int destination) {
        graph[source][destination] = Boolean.FALSE;
        graph[destination][source] = Boolean.FALSE;
    }

    public int getVertexCount() {
        return graph.length;
    }

    public int getEdgeCount() {
        int edges = 0;
        for(int i=0; i < this.getVertexCount(); i++) {
            for (int j = 0; j < this.getVertexCount(); j++) {
                if (graph[i][j]) edges++;
            }
        }
        return edges/2;
    }

    public boolean isAdjacent(int source, int destination) {
        return graph[source][destination];
    }

    public List<Integer> getNeighbours(int vertex) {
        List<Integer> neighbours = new ArrayList<>();
        if(graph.length > vertex) {
            for(int i = 0; i < getVertexCount(); i++) {
                if(isAdjacent(vertex, i)) neighbours.add(i);
            }
        }
        return neighbours;
    }

    public List<Pair<Integer, Integer>> getEdges() {
        List<Pair<Integer, Integer>> edges = new ArrayList<>();
        Pair<Integer, Integer> pair;
        for(int i = 0; i < getVertexCount(); i++) {
            for(int j = 0; j < getVertexCount(); j++) {
                if(isAdjacent(i, j)) {
                    pair = new Pair<>(i, j);
                    if(!edges.contains(pair)) {
                        edges.add(pair);
                    }
                }
            }
        }
        return edges;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(graph);
    }

}
