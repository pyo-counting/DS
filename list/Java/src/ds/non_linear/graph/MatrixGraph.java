package ds.non_linear.graph;

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

    public void DFS(int fromVertex, boolean useRecursive) {
        if (fromVertex < 0 || fromVertex >= matrix.length)
            throw new IndexOutOfBoundsException("Index parameter is out of bound");

        if (useRecursive) {
            boolean[] isSearched = new boolean[matrix.length];
            recursiveDFS(fromVertex, isSearched);
        } else {
            stackDFS(fromVertex);
        }
    }

    private void recursiveDFS(int fromVertex, boolean[] isSearched) {
        System.out.print(fromVertex + " ");
        isSearched[fromVertex] = true;

        for (int toVertex = 0; toVertex < matrix.length; toVertex++) {
            if (matrix[fromVertex][toVertex] == 1 && !isSearched[toVertex])
                recursiveDFS(toVertex, isSearched);
        }
    }

    private void stackDFS(int fromVertex) {
//        Stack<Integer> stack = new Stack<>();
//        boolean[] isSearched = new boolean[matrix.length];
//
//        while (true) {
//            if(!isSearched[fromVertex]) {
//                System.out.print(fromVertex + " ");
//                isSearched[fromVertex] = true;
//            }
//            for (int toVertex = 0; toVertex < matrix.length; toVertex++) {
//                if (matrix[fromVertex][toVertex] == 1 && !isSearched[toVertex]) {
//                    stack.push(fromVertex);
//                    fromVertex = toVertex;
//                    break;
//                } else if (toVertex == matrix.length - 1){
//                    fromVertex = stack.pop();
//                }
//            }
//            if(stack.empty()){
//                return;
//            }
//        }
    }

    public static void main(String[] args) {
        MatrixGraph graph = new MatrixGraph(4, false);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.DFS(2, false);
    }
}
