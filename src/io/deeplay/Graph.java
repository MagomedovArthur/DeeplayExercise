package io.deeplay;

public class Graph {

    private int[][] graph = new int[4][4];

    public int[][] createGraph(String gameField, String character) throws Exception {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                int stringIndex = i * graph[i].length + j;
                char printChar = gameField.charAt(stringIndex);
                graph[i][j] = WeightsTable.getWeight(character, printChar);
            }
        }
        graph[0][0] = 0;
        return graph;
    }
}