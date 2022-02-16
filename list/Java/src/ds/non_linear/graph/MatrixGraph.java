package ds.non_linear.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MatrixGraph {
    private int[][] matrix;
    private boolean isDirected;

    public MatrixGraph(int numOfVertex, boolean isDirected) {
        this.matrix = new int[numOfVertex][numOfVertex];
        this.isDirected = isDirected;
    }

    public void addVertex(int indexOfVertex) {

    }

    public void removeVertex(int indexOfVertex) {

    }

    public void addEdge(int fromVertex, int toVertex) {
        if (fromVertex < 0 || toVertex < 0 || fromVertex >= matrix.length || toVertex >= matrix.length)
            throw new IndexOutOfBoundsException("Index parameter is out of bound");

        matrix[fromVertex][toVertex] = 1;
        if (!isDirected)
            matrix[toVertex][fromVertex] = 1;
    }

    public void removeEdge(int fromVertex, int toVertex) {
        if (fromVertex < 0 || toVertex < 0 || fromVertex >= matrix.length || toVertex >= matrix.length)
            throw new IndexOutOfBoundsException("Index parameter is out of bound");

        matrix[fromVertex][toVertex] = 0;
        if (!isDirected)
            matrix[toVertex][fromVertex] = 0;
    }

    public void DFS(int initVertex, boolean useRecursive) {
        if (initVertex < 0 || initVertex >= matrix.length)
            throw new IndexOutOfBoundsException("Index parameter is out of bound");

        if (useRecursive) {
            boolean[] isSearched = new boolean[matrix.length];
            recursiveDFS(initVertex, isSearched);
        } else {
            stackDFS(initVertex);
        }
        System.out.println();
    }

    private void recursiveDFS(int fromVertex, boolean[] isSearched) {
        System.out.print(fromVertex + " ");
        isSearched[fromVertex] = true;

        for (int toVertex = 0; toVertex < matrix.length; toVertex++) {
            if (matrix[fromVertex][toVertex] == 1 && !isSearched[toVertex])
                recursiveDFS(toVertex, isSearched);
        }
    }

    private void stackDFS(int initVertex) {
        Stack<Integer> stack = new Stack<>();
        boolean[] isSearched = new boolean[matrix.length];
        stack.push(initVertex);

        while(!stack.isEmpty()){
            int fromVertex = stack.pop();
            System.out.print(fromVertex + " ");
            isSearched[fromVertex] = true;

            for (int toVertex = 0; toVertex < matrix.length; toVertex++) {
                if (!isSearched[toVertex] && matrix[fromVertex][toVertex] == 1){
                    stack.push(toVertex);
                    break;
                }
            }
        }
    }

    public void BFS(int initVertex) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isSearched = new boolean[matrix.length];
        queue.offer(initVertex);
        isSearched[initVertex] = true;

        while (!queue.isEmpty()) {
            int fromVertex = queue.poll();
            System.out.print(fromVertex + " ");

            for (int toVertex = 0; toVertex < matrix.length; toVertex++) {
                if (!isSearched[toVertex] && matrix[fromVertex][toVertex] == 1){
                    queue.offer(toVertex);
                    isSearched[toVertex] = true;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MatrixGraph graph1 = new MatrixGraph(4, true);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 0);
        graph1.addEdge(1, 3);
        graph1.addEdge(3, 3);

        graph1.DFS(2, true);
        graph1.DFS(2, false);

        MatrixGraph graph2 = new MatrixGraph(6, false);
        graph2.addEdge(0, 1);
        graph2.addEdge(0, 2);
        graph2.addEdge(1, 3);
        graph2.addEdge(1, 4);
        graph2.addEdge(3, 4);
        graph2.addEdge(3, 5);
        graph2.addEdge(2, 4);
        graph2.addEdge(4, 5);

        graph2.BFS(0);
    }
}