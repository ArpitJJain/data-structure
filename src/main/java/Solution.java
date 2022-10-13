// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;


class pair{
    int a,b,c;
    public pair(int a,int b,int c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
}
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine());
            pair p[]=new pair[n];
            for(int i=0;i<n;i++){
                String s[]=in.readLine().trim().split(" ");
                p[i]=new pair(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]));
            }
            Solution ob=new Solution();
            long ans=ob.maxScore(n,p);
            out.println(ans);
        }
        out.close();
    }
}// } Driver Code Ends


//User function Template for Java

/*
class pair{
    int a,b,c;
    public pair(int a,int b,int c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }
}
*/
class Solution
{
    public static long maxScore(int n, pair arr[])
    {
        Graph g = new Graph();
        for(pair p : arr){
            g.addPair(p.a,p.b,p.c);
        }
        long count = Long.MIN_VALUE;
        for(Integer edge : g.map.keySet()){
            long sum  = DFS(edge, g.nodeCount(),g);
            count = Math.max(count,sum);
        }
        return count;
    }

    static long  DFS(Integer v, int size,Graph g)
    {
        long count = Long.MIN_VALUE;
        if(g.map.get(v).size() > 0)
        for(Integer e : g.map.get(v).keySet()) {
            boolean visited[] = new boolean[size];
            ArrayList<Integer> l = new ArrayList<>();
            DFSUtil(v, e, visited, l, g);
            long sum = l.stream().reduce(0, (a, b) -> a + b);
            count = Math.max(count,sum);
        }
        return count;
    }


    static void  DFSUtil(Integer i, Integer v, boolean visited[],ArrayList<Integer> result,Graph g)
    {
        // Mark the current node as visited and print it
        visited[v-1] = true;
        result.add(g.map.get(i).get(v));

        // Recur for all the vertices adjacent to this
        // vertex
        if(null != g.map.get(v)) {
            for (Integer n : g.map.get(v).keySet()) {
                if (!visited[n - 1])
                    DFSUtil(n,v, visited, result, g);
            }
        }
    }

    static class Graph{
        public Map<Integer, HashMap<Integer, Integer>> map = new LinkedHashMap<Integer, HashMap<Integer, Integer>>();
        public void addPair(int ... data){
            HashMap<Integer, Integer> l = map.get(data[0]);
            if (l == null){
                l = new HashMap<Integer, Integer>();
                map.put(data[0],l);
            }
            if(l.containsKey(data[1])){
                if(l.get(data[1]) < data[2]){
                    l.put(data[1],data[2]);
                }
            }else{
                l.put(data[1],data[2]);
            }
            if(!map.containsKey(data[1])){
                map.put(data[1],new HashMap<Integer, Integer>());
            }
        }

        public int nodeCount(){
            return map.size();
        }


    }
}