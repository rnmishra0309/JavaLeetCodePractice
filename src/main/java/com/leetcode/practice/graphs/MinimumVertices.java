package com.leetcode.practice.graphs;

/*

    Given a directed acyclic graph with n nodes labeled from 0 to n-1,
    determine the smallest number of initial nodes such that you can access all the nodes by traversing edges.
    Return these nodes.

    Examples:

    Input:

    n = 6
    edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
    Expected Output: [0,3]

    Justification: Starting from nodes 0 and 3, you can reach all other nodes in the graph.
                   Starting from node 0, you can reach nodes 1, 2, and 5.
                   Starting from node 3, you can reach nodes 4 and 2 (and by extension 5).

    Input:

    n = 3
    edges = [[0,1],[2,1]]
    Expected Output: [0,2]

    Justification: Nodes 0 and 2 are the only nodes that don't have incoming edges.
                   Hence, you need to start from these nodes to reach node 1.

    Input:

    n = 5
    edges = [[0,1],[2,1],[3,4]]
    Expected Output: [0,2,3]

    Justification: Node 1 can be reached from both nodes 0 and 2, but to cover all nodes,
                   you also need to start from node 3.

 */

import java.util.*;

public class MinimumVertices {

        public static int[] getInDegreeCount(int n, Map<Integer, List<Integer>> graph) {
            int[] inDegreeArray = new int[n];
            for(List<Integer> value: graph.values()) {
                value.forEach(k -> {
                    inDegreeArray[k]++;
                });
            }
            return inDegreeArray;
        }

        public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
            List<Integer> result = new ArrayList<>();
            Map<Integer, List<Integer>> graph = new HashMap<>(); // declare the graph
            // initialize the graph
            for(int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
            // add edges to the graph
            for(List<Integer> edge: edges) {
                graph.get(edge.get(0)).add(edge.get(1));
            }
            int[] inDegrees = getInDegreeCount(n, graph);
            for(int i=0; i<n; i++) {
                if(inDegrees[i] == 0) {
                    result.add(i);
                }
            }
            return result;
        }

        // Efficient because we don't need to create a graph from the edges list
        public static List<Integer> findSmallestSetOfVerticesEfficient (int n, List<List<Integer>> edges) {
            boolean[] hasIncomingEdge = new boolean[n];

            // Determine nodes with incoming edges
            for (List<Integer> edge : edges) {
                hasIncomingEdge[edge.get(1)] = true;
            }

            List<Integer> result = new ArrayList<>();
            // Gather nodes without incoming edges
            for (int i = 0; i < n; i++) {
                if (!hasIncomingEdge[i]) {
                    result.add(i);
                }
            }

            return result;
        }



}
