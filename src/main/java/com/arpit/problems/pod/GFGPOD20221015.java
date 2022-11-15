package com.arpit.problems.pod;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an array A of size N of integers. Your task is to find the sum of minimum and maximum element in the array.
 */
public class GFGPOD20221015 {
    static int shortestPath(int[][] grid, int[] source, int[] destination) {
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        int result =  shortestPath(grid, source, destination, new HashMap<>(),visited);

        if(result == Integer.MAX_VALUE){
            return -1;
        } else{
            return result -1;
        }
    }

    static int shortestPath(int[][] grid, int[] source, int[] destination, Map<String, Integer> map,boolean [][]visited) {
        String key = source[0] + "_" + source[1];
        Integer result = map.get(key);
        if (result != null) {
            return result;
        }

        if (source[0] < 0 || source[0] > grid.length - 1) {
            return Integer.MAX_VALUE;
        }
        if (source[1] < 0 || source[1] > grid[source[0]].length - 1) {
            return Integer.MAX_VALUE;
        }
        if(visited[source[0]][source[1]]){
            return Integer.MAX_VALUE;
        }
        if (grid[source[0]][source[1]] == 0) {
            return Integer.MAX_VALUE;
        }
        visited[source[0]][source[1]] = true;
        if (source[0] == destination[0] && source[1] == destination[1]) {
            visited[source[0]][source[1]] = false;
            return 1;
        }
        int val1 = shortestPath(grid, new int[]{source[0], source[1] + 1}, destination, map,visited);
        int val2 = shortestPath(grid, new int[]{source[0] + 1, source[1]}, destination, map,visited);
        int val3 = shortestPath(grid, new int[]{source[0], source[1] - 1}, destination, map,visited);
        int val4 = shortestPath(grid, new int[]{source[0] - 1, source[1]}, destination, map,visited);
        visited[source[0]][source[1]] = false;
        int min = Math.min(Math.min(Math.min(val1, val2), val3),val4);

        if (min == Integer.MAX_VALUE)
            return min;
        else
            min = min + 1;
        map.put(key, min);
        return min;
    }


    public static void main(String[] args) {
        assertEquals(3, shortestPath(new int[][]{
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}}, new int[]{0, 1}, new int[]{2, 2}));

        assertEquals(1, shortestPath(new int[][]{
                {1, 1}}, new int[]{0, 0}, new int[]{0, 1}));
        assertEquals(-1, shortestPath(new int[][]{
                {1, 0}}, new int[]{0, 0}, new int[]{0, 1}));
        assertEquals(2, shortestPath(new int[][]{
                {1, 1},
                {1, 1}}, new int[]{0, 0}, new int[]{1, 1}));

        assertEquals(-1, shortestPath(new int[][]{
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {1, 0, 1, 0, 1}}, new int[]{0, 0}, new int[]{3, 4}));
    }
}
