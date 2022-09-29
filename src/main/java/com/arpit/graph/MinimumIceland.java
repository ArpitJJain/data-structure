package com.arpit.graph;

import java.util.HashSet;
import java.util.Set;

public class MinimumIceland {

    static int countIceland(String [][] grid){
        int minIceland = Integer.MAX_VALUE;
        Set<String> visited = new HashSet<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                int size = explore(grid,i,j,visited);
                if(size != 0)
                    minIceland = Math.min(minIceland,size);
            }
        }
        return minIceland;
    }

    private static int explore(String [][]grid, int r, int c, Set<String> visited){
        boolean rowCheck = r>= 0 && r<=grid.length-1;
        if(!rowCheck)
            return 0;

        boolean columCheck = c>= 0 && c<=grid[r].length-1;
        if(!columCheck)
            return 0;
        boolean waterCheck = "W".equals(grid[r][c]);
        if(visited.contains(r+"_"+c) || waterCheck)
            return 0;

        visited.add(r+"_"+c);
        int val =  explore(grid,r-1,c,visited)+explore(grid,r+1,c,visited)+explore(grid,r,c+1,visited)+explore(grid,r,c-1,visited);
        return val+1;
    }

    public static void main(String[] args) {
        String [][] grid = new String[6][5];
        grid[0][0] = "W";
        grid[0][1] = "L";
        grid[0][2] = "W";
        grid[0][3] = "W";
        grid[0][4] = "W";

        grid[1][0] = "W";
        grid[1][1] = "L";
        grid[1][2] = "W";
        grid[1][3] = "W";
        grid[1][4] = "W";

        grid[2][0] = "W";
        grid[2][1] = "W";
        grid[2][2] = "W";
        grid[2][3] = "L";
        grid[2][4] = "W";

        grid[3][0] = "W";
        grid[3][1] = "W";
        grid[3][2] = "L";
        grid[3][3] = "L";
        grid[3][4] = "W";

        grid[4][0] = "L";
        grid[4][1] = "W";
        grid[4][2] = "W";
        grid[4][3] = "L";
        grid[4][4] = "L";

        grid[5][0] = "L";
        grid[5][1] = "L";
        grid[5][2] = "W";
        grid[5][3] = "W";
        grid[5][4] = "W";

        System.out.println(countIceland(grid));
    }
}
