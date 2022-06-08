package test;

import io.deeplay.ShortestPath;
import io.deeplay.Graph;
import org.junit.Assert;

public class SolutionTest {

    @org.junit.Test
    public void whenSTWSWTPPTPTTPWPPAndHuman() throws Exception {
        String gameField = "STWSWTPPTPTTPWPP";
        String character = "Human";
        int expected = 10;
        Graph graph = new Graph();
        int[][] matrix = graph.createGraph(gameField, character);
        ShortestPath shortestPath = new ShortestPath(matrix);
        int result = shortestPath.getShortestDistance();
        Assert.assertEquals(expected, result);
    }

    @org.junit.Test
    public void whenSTWSWTPPTPTTPWPPAndWoodman() throws Exception {
        String gameField = "STWSWTPPTPTTPWPP";
        String character = "Woodman";
        int expected = 12;
        Graph graph = new Graph();
        int[][] matrix = graph.createGraph(gameField, character);
        ShortestPath shortestPath = new ShortestPath(matrix);
        int result = shortestPath.getShortestDistance();
        Assert.assertEquals(expected, result);
    }

    @org.junit.Test
    public void whenSTWSWTPPTPTTPWPTAndSwamper() throws Exception {
        String gameField = "STWSWTPPTPTTPWPT";
        String character = "Swamper";
        int expected = 16;
        Graph graph = new Graph();
        int[][] matrix = graph.createGraph(gameField, character);
        ShortestPath shortestPath = new ShortestPath(matrix);
        int result = shortestPath.getShortestDistance();
        Assert.assertEquals(expected, result);
    }
}