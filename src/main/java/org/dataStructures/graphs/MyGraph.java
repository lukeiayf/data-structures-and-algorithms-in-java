package org.dataStructures.graphs;

import java.util.ArrayList;
import java.util.Hashtable;

public class MyGraph {
    //Edge list graph
    int[][] graph = {
            {0, 2},
            {2, 3},
            {2, 1},
            {1, 3}
    };

    //Adjacent list
    int[][] aGraph = {
            {2},
            {2, 3},
            {0, 1, 3},
            {1, 2}
    };

    //Adjacent matrix
    int[][] matrix = {
            {0, 0, 1, 0},//0
            {0, 0, 1, 1},//1
            {1, 1, 0, 1},//2
            {0, 1, 1, 0}//3
    };

    int numberOfNodes = 0;
    Hashtable<Integer, ArrayList<Integer>> adjacentList = new Hashtable<>();

    public void addVertex(int node) {
        adjacentList.put(node, new ArrayList<>());
        numberOfNodes++;
    }

    public void addEdge(int node1, int node2) {
        adjacentList.get(node1).add(node2);
        adjacentList.get(node2).add(node1);
    }

    public void showConnections() {
        Object[] keys = adjacentList.keySet().toArray();
        for (Object key : keys) {
            System.out.println(key + " ---> " + adjacentList.get(Integer.parseInt(key.toString())));
        }
    }

    public static void main(String[] args) {
        MyGraph graph = new MyGraph();
        graph.addVertex(5);
        graph.addVertex(54);
        graph.addVertex(44);
        graph.addEdge(5, 54);
        graph.addEdge(5, 44);
        graph.showConnections();
    }
}
