package com.leetcode.practice.graphs;

import com.leetcode.practice.graphs.adt.GraphAdjacencyMatrixADT;

public class GraphMain {

    public static void main(String[] args) {

        GraphAdjacencyMatrixADT graphAdjacencyMatrixADT = new GraphAdjacencyMatrixADT(
                new boolean[][] {{false, true, true}, {true, false, false}, {true, false, false}}
        );

        System.out.println("graph: " + graphAdjacencyMatrixADT.toString());

        System.out.println("vertex count: " + graphAdjacencyMatrixADT.getVertexCount());

        System.out.println("Edges count: " + graphAdjacencyMatrixADT.getEdgeCount());

        System.out.println("Adding vertex between 1 & 2...");
        graphAdjacencyMatrixADT.addEdge(1, 2);

        System.out.println("graph: " + graphAdjacencyMatrixADT.toString());

        System.out.println("vertex count: " + graphAdjacencyMatrixADT.getVertexCount());

        System.out.println("Edges count: " + graphAdjacencyMatrixADT.getEdgeCount());

        System.out.println("Get all edges: " + graphAdjacencyMatrixADT.getEdges().toString());

        System.out.println("Removing vertex between 1 & 2...");
        graphAdjacencyMatrixADT.removeEdge(1, 2);

        System.out.println("graph: " + graphAdjacencyMatrixADT.toString());

        System.out.println("vertex count: " + graphAdjacencyMatrixADT.getVertexCount());

        System.out.println("Edges count: " + graphAdjacencyMatrixADT.getEdgeCount());

        System.out.println("Get Neighbours of 0: " + graphAdjacencyMatrixADT.getNeighbours(0).toString());

        System.out.println("Get all edges: " + graphAdjacencyMatrixADT.getEdges().toString());

    }

}
