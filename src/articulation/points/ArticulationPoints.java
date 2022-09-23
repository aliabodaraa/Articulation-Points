/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package articulation.points;
import DFS.Dfs;
import ArticulationPoint.Articulation;
import java.util.Random;
import java.util.Scanner;  // Import the Scanner class
import javafx.util.Pair;
/**
 *
 * @author DELL
 */
public class ArticulationPoints {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] graph1={
                     {0,1,1,0,1},
                     {1,0,0,0,0},
                     {1,0,0,1,1},
                     {0,0,1,0,0},
                     {1,0,1,0,0}
                    };
       int[][] graph2={
                     {0,1,0,1,0,0},
                     {1,0,1,0,1,0},
                     {0,1,0,1,1,1},
                     {1,0,1,0,0,0},
                     {0,1,1,0,0,1},
                     {0,0,1,0,1,0}
                    };
              int[][] graph3={
                     {0,1,1},
                     {1,0,0},
                     {1,0,0}
                    };
              int[][] graph4={
                     {0,1,1},
                     {1,0,1},
                     {1,1,0}
                    };
          int[][] graph5={
                     {0,1,0,1},
                     {1,0,1,0},
                     {0,1,0,1},
                     {1,0,1,0}
                    };
          int[][] graph6={
                     {0,1,1,1,0,0,0,0,0,0},
                     {1,0,1,0,1,0,0,0,0,0},
                     {1,1,0,1,1,0,0,0,0,0},
                     {1,0,1,0,0,0,0,0,0,0},
                     {0,1,1,0,0,1,0,0,1,1},
                     {0,0,0,0,1,0,1,1,0,0},
                     {0,0,0,0,0,1,0,1,0,0},
                     {0,0,0,0,0,1,1,0,0,0},
                     {0,0,0,0,1,0,0,0,0,1},
                     {0,0,0,0,1,0,0,0,1,0},
                    };
        //Dfs dfs=new Dfs(graph1);
        Articulation articulation=new Articulation(graph6);
        articulation.articulationPointRun();
        //articulation.
        // dfs=new Dfs(graph3);
    }
    
}
