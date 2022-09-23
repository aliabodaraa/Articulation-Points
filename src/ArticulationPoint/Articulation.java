/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArticulationPoint;

import java.util.*;  
import javafx.util.Pair; 
import java.util.Random;
import DFS.Dfs;
/**
 *
 * @author DELL
 */
public class Articulation {
    int count=0;
    int currentVertix;
    private List<Pair<Integer, String>> articulationPoints=new ArrayList<Pair<Integer, String>>();
    private boolean isArticulation [];
    private int [][] graph;
    private Dfs dfs;
    public Articulation(int[][] graph){
       dfs=new Dfs(graph);
       this.graph=graph;
       dfs.dfsRun(dfs.getRootNode());
       dfs.setTreeEdgesGraph();
       dfs.printTreeGraph();
       dfs.printTreeEdges();
       dfs.printBackwardEdges();
       this.isArticulation=new boolean[this.graph.length];
       this.setArticulationResult();
    }
    public void setArticulationResult(){
        for (int i = 0; i < graph.length; i++){
             this.isArticulation[i]=true;
        }
    }    
    public void printArticulationResult(){
       System.out.print("\nIsArticulation Array : ");
       for (int j = 0; j < graph.length; j++)
               System.out.print("\nthe node   "+j+" is "+isArticulation[j]);
    }
    public void discoverBackwardEdges(int nodeNumber){
        for(int i=0; i<this.graph.length;i++){
            if(this.dfs.getTreeEdgesGraph()[nodeNumber][i] == 1  ){
                //System.out.println("////"+nodeNumber+" --->"+i);
                    for(Pair edge:dfs.getBackwardEdges()){
                       if((int)edge.getKey() == i &&
                           dfs.getVisitTime()[this.currentVertix] > dfs.getVisitTime()[(int)edge.getValue()]
                          && dfs.getVisitTime()[this.currentVertix] < dfs.getVisitTime()[(int)edge.getKey()]  
                               ) {        
                           //System.out.println("////"+nodeNumber+" --->nn"+i+"/////count="+count+";;;;"+dfs.numChildren(this.currentVertix));
                           articulationPoints.add(new Pair<>(this.currentVertix,"Not Atrticulation There Is Path From "+
                           ((int)edge.getKey())+" To "+((int)edge.getValue())));
                           this.count++;
                           break;
                       }
                    }
                    if(this.count==0  && !dfs.isLeaf(i)){
                        discoverBackwardEdges(i);
                    }
                }
            }
        //System.out.println(dfs.numChildren(this.currentVertix)<=this.count);
            if(dfs.numChildren(this.currentVertix)<=this.count)
                this.isArticulation[this.currentVertix]=false;
            else
                this.isArticulation[this.currentVertix]=true; 
    }
    public void articulationPointRun(){
        for(int nodeNumber=0;nodeNumber<this.graph.length;nodeNumber++){
            if(dfs.isRooted(nodeNumber,dfs.getRootNode())){
                if(dfs.nodeHasMoreThanOneChild(nodeNumber)){
                    articulationPoints.add(new Pair<>(nodeNumber,"Root Atrticulation"));
                    this.isArticulation[nodeNumber]=true;
                }else{
                    articulationPoints.add(new Pair<>(nodeNumber,"Root Not Atrticulation"));
                    this.isArticulation[nodeNumber]=false;
                }
            }else if(dfs.isLeaf(nodeNumber)){
                articulationPoints.add(new Pair<>(nodeNumber,"Leaf Not Atrticulation"));
                this.isArticulation[nodeNumber]=false;
            }else{
                    this.count=0;
                    this.currentVertix=nodeNumber;
                    discoverBackwardEdges(nodeNumber); 
            }
    }//endfor
    this.printArticulationResult();
    }
}
