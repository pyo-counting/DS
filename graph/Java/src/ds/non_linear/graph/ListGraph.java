package ds.non_linear.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ListGraph {

    private LinkedList<Integer>[] graph;
    private boolean isDirected;

    public ListGraph(int numOfVertex, boolean isDirected) {
        this.graph = new LinkedList[numOfVertex];

        for (int index = 0; index < graph.length; index++)
            graph[index] = new LinkedList<>();

        this.isDirected = isDirected;
    }

    public void addVertex(int indexOfVertex) {

    }

    public void removeVertex(int indexOfVertex) {

    }

    public void addEdge(int fromVertex, int toVertex) {
        if (fromVertex < 0 || toVertex < 0 || fromVertex >= graph.length || toVertex >= graph.length)
            throw new IndexOutOfBoundsException("Index parameter is out of bound");

        this.graph[fromVertex].add(toVertex);

        if (!isDirected)
            this.graph[toVertex].add(fromVertex);
    }

    public void removeEdge(int fromVertex, int toVertex) {
        if (fromVertex < 0 || toVertex < 0 || fromVertex >= graph.length || toVertex >= graph.length)
            throw new IndexOutOfBoundsException("Index parameter is out of bound");

        this.graph[fromVertex].remove(toVertex);
        if (!isDirected)
            this.graph[toVertex].remove(fromVertex);
    }

    public void DFS(int initVertex, boolean useRecursive) {
        if (initVertex < 0 || initVertex >= graph.length)
            throw new IndexOutOfBoundsException("Index parameter is out of bound");

        if (useRecursive) {
            boolean[] isVisited = new boolean[graph.length];
            recursiveDFS(initVertex, isVisited);
        } else {
            stackDFS(initVertex);
        }
        System.out.println();
    }

    private void recursiveDFS(int fromVertex, boolean[] isVisited) {
        isVisited[fromVertex] = true;
        System.out.print(fromVertex + " ");

        for (int toVertex : graph[fromVertex]) {
            if (!isVisited[toVertex]) {
                recursiveDFS(toVertex, isVisited);
            }
        }

    }

    private void stackDFS(int initVertex) {
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[graph.length];

        stack.push(initVertex);
        isVisited[initVertex] = true;

        while (!stack.isEmpty()) {
            int fromVertex = stack.pop();
            System.out.print(fromVertex + " ");

            for (int index = graph[fromVertex].size() - 1; index >= 0; index--) {
                if (!isVisited[graph[fromVertex].get(index)]) {
                    isVisited[graph[fromVertex].get(index)] = true;
                    stack.push(graph[fromVertex].get(index));
                }
            }
        }
    }

    public void BFS(int initVertex) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[graph.length];

        isVisited[initVertex] = true;
        queue.offer(initVertex);

        while (!queue.isEmpty()) {
            int fromVertex = queue.poll();
            System.out.print(fromVertex + " ");

            for (int toVertex : graph[fromVertex]) {
                if (!isVisited[toVertex]) {
                    isVisited[toVertex] = true;
                    queue.offer(toVertex);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListGraph graph = new ListGraph(4, true);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.DFS(2, true);
        graph.DFS(2, false);
        graph.BFS(2);
    }
}
