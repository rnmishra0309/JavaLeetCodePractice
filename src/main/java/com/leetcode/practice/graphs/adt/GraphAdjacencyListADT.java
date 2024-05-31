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

public class GraphAdjacencyListADT { // Un-Directed graph

    Map<Integer, ArrayList<Integer>> adjacencyList;

    public GraphAdjacencyListADT() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) { // Add a new vertex to the graph.
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void removeVertex(int vertex) { // Remove a vertex from the graph.
        if(adjacencyList.containsKey(vertex)) {
            for(int edgeVertex: adjacencyList.get(vertex)) {
                removeEdge(vertex, edgeVertex);
            }
            adjacencyList.remove(vertex);
        }
    }

    public void addEdge(int vertex1, int vertex2) { // Add an edge between two vertices.
        adjacencyList.computeIfAbsent(vertex1, k -> new ArrayList<>()).add(vertex2);
        adjacencyList.computeIfAbsent(vertex2, k -> new ArrayList<>()).add(vertex1);
    }

    public void removeEdge(int vertex1, int vertex2) { // Remove an edge between two vertices.
        if (adjacencyList.containsKey(vertex1) && adjacencyList.containsKey(vertex2)) {
            adjacencyList.get(vertex1).removeIf(v -> v == vertex2);
            adjacencyList.get(vertex2).removeIf(v -> v == vertex1);
        }
    }

    public Set<Integer> getVertices() { // get all vertices
        return adjacencyList.keySet();
    }

    public boolean isAdjacent(int vertex1, int vertex2) { // Check if two vertices are adjacent.
        return (adjacencyList.containsKey(vertex1) && (adjacencyList.get(vertex1).contains(vertex2)));
    }

    public int getVertexCount() { // Get the total number of vertices.
        return adjacencyList.size();
    }

    public int getEdgeCount() { // Get the total number of edges.
        int count = 0;
        for(ArrayList<Integer> value: adjacencyList.values()) count += value.size();
        return count / 2;
    }

    public List<Pair<Integer, Integer>> getEdges() { // Get a list of all edges.
        List<Pair<Integer, Integer>> edges = new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<Integer>> entry: adjacencyList.entrySet()) {
            for(int value: entry.getValue()) {
                if (entry.getKey() < value) {
                    edges.add(new Pair<>(entry.getKey(), value));
                }
            }
        }
        return edges;
    }

    public ArrayList<Integer> getNeighbors(int vertex) {
        return adjacencyList.getOrDefault(vertex, null);
    }

}
