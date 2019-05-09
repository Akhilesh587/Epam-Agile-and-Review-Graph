import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Roads-Librariesrer {
    
    private static ArrayList<Integer>[] adjCities;
    private static int connectedComponents;
    private static int total;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt(); // number of queries
        for(int a0 = 0; a0 < q; a0++){
            int cities = in.nextInt(); // number of cities
            int roads = in.nextInt(); // number of roads
            int libCost = in.nextInt(); // cost of building a library
            //System.out.println("Cost of building library: "+libCost);
            int roadCost = in.nextInt(); // cost of repairing a road
            //System.out.println("Cost of repairing road: "+roadCost);
            
            if (roadCost >= libCost){ // optimal scenario
                total = libCost*cities;
            }
            
            else{
                //Now we must try to get all the connected components
                
                adjCities = (ArrayList<Integer>[]) new ArrayList[cities];
                for (int c = 0; c < cities; c++) {
                    adjCities[c] = new ArrayList<Integer>();
                }
                
                boolean[] visited = new boolean[cities];
                
                //initializing adjCities
                for (int i = 0; i < roads; i++){
                    int c1 = in.nextInt();
                    int c2 = in.nextInt();
                    
                    adjCities[c1].add(c2);
                    adjCities[c2].add(c1);
                }
                
                //Checking our adjCities
                for (int i = 0; i <= roads; i++){
                    System.out.println(adjCities[i]);
                }

                
                for (int i = 0; i < cities; i++){
                    visited[i] = false;
                }
                
                for(int c = 1; c <= cities; c++) {
                    if(visited[c] == false) {
                        dfs(c, adjCities, visited);
                        connectedComponents++;
                    }
                }
           
            System.out.println(connectedComponents);
            }
        }
    }
    
    private static void dfs(int city, ArrayList<Integer>[] adjCities, boolean[] visited){
        visited[city] = true;
        for (int c = 0; c < adjCities[city].size(); c++){
            if(!visited[adjCities[city].get(c)]){
                dfs(adjCities[city].get(c), adjCities, visited);
            }
        }
    }
    
