/*
Create an algorithm that can take as an input an array of Integers and can group them into N groups depending on how close they are to each other.
The solution should solve the problem for any list of Integers and groups (provided the groups are less or equal to the total number of Integers). 
Furthermore, the solution needs to have the right level of automated testing to validate that it works, and that the code is resilient to modifications.

// Example 1:

group([16, 15, 14, 13, 34, 23, 24, 25, 26, 28, 45, 34, 23, 29, 12, 23, 45, 67, 23, 12, 34, 45, 23, 67, 23, 67], 3);


// generates 3 groups

[ [ 16, 15, 14, 13, 12, 12 ],

[ 34, 23, 24, 25, 26, 28, 34, 23, 29, 23, 23, 34, 23, 23 ],

[ 45, 45, 67, 45, 67, 67 ] ]



// Example 2:

group([16, 15, 14, 13, 34, 23, 24, 25, 26, 28, 45, 34, 23, 29, 12, 23, 45, 67, 23, 12, 34, 45, 23, 67, 23, 670], 3);


// generates 3 groups

[ [ 16, 15, 14, 13, 23, 24, 25, 26, 28, 23, 29, 12, 23, 23, 12, 23, 23 ],

[ 34, 45, 34, 45, 67, 34, 45, 67 ],

[ 670 ] ]



// Example 3:

group([160, 15, 14, 13, 34, 23, 24, 25, 26, 28, 45, 34, 23, 29, 12, 23, 45, 67, 23, 12, 34, 45, 23, 67, 23, 670], 4);


// generates 4 groups

[ [ 160 ],

[ 15, 14, 13, 23, 24, 25, 26, 28, 23, 29, 12, 23, 23, 12, 23, 23 ],

[ 34, 45, 34, 45, 67, 34, 45, 67 ],

[ 670 ] ]



// Example 4:

group([16, 15, 14, 13, 34, 23, 24, 25, 26, 28, 45, 34, 23, 29, 12, 23, 45, 67, 23, 12, 34, 45, 23, 67, 23, 67], 5);


// generates 5 groups

[ [ 16, 15, 14, 13, 12, 12 ],

[ 34, 34, 29, 34 ],

[ 23, 24, 25, 26, 28, 23, 23, 23, 23, 23 ],

[ 45, 45, 45 ],

[ 67, 67, 67 ] ]
 */
package groupinnumbersbyproximity;

import java.util.ArrayList;
import static java.util.Arrays.sort;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author Daniel Dias
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //represent the 3 different groups of integers given in the examples
        int group1[] = {16, 15, 14, 13, 34, 23, 24, 25, 26, 28, 45, 34, 23, 29, 12, 23, 45, 67, 23, 12, 34, 45, 23, 67, 23, 67};
        int group2[] = {16, 15, 14, 13, 34, 23, 24, 25, 26, 28, 45, 34, 23, 29, 12, 23, 45, 67, 23, 12, 34, 45, 23, 67, 23, 670};
        int group3[] = {160, 15, 14, 13, 34, 23, 24, 25, 26, 28, 45, 34, 23, 29, 12, 23, 45, 67, 23, 12, 34, 45, 23, 67, 23, 670};
        int k = 3;
       
  
        int V = group1.length;  // Number of vertices in group1 which is represented by the number of elements in the array
        int E = group1.length - 1 ; // Number of edges in group1 which is represented by the number of consective pairs in the array

        
        Graph graph = new Graph(V, E);

        
   
        //adding the edge values to the graph
        for (int i = 0; i < group1.length - 1; i++){
            graph.edge[i].src = group1[i];
            graph.edge[i].dest = group1[i+1];
            graph.edge[i].weight = Math.abs(group1[i] - group1[i+1]);
        }

        
        
        /* CENAS EM QUE FIZ UM MAU DEBUG
        for(int i = 0; i < graph.edge.length ; i++){
            System.out.println(graph.edge[i].toString());
        }
      
        System.out.println("==================================================================================================================");
        
        sort(graph.edge);
        
        
        for(int i = 0; i < graph.edge.length ; i++){
            System.out.println(graph.edge[i].toString());
        }
        */
        
        int clusters = group1.length;

        graph.KruskalMST();
    }

}



