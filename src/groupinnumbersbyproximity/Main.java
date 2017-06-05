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
        int group4[] = {11,10,20,25,30,33};
        int k = 3; //number of clusters

        groupByProximity(group1, k);

    }

    public static void groupByProximity(int[] group, int k) {

        int E = group.length - 1; // Number of edges in group which is represented by the number of consective pairs in the array

        Edge edge[] = new Edge[E]; // collection of all edges

        //adding the edge values to the container
        for (int i = 0; i < E; i++) {
            edge[i] = new Edge();
            edge[i].src = group[i];
            edge[i].dest = group[i + 1];
            edge[i].weight = Math.abs(group[i] - group[i + 1]);
        }

        sort(edge); //sorting the edge container by the value of weight

        
        
        int[] weightArr = new int[edge.length];//an array with only the Weights of the edges, so we can extract the maximums required for clustering

        for (int i = 0; i < edge.length; i++) {
            weightArr[i] = edge[i].weight;
        }

        /*
        lets start now to get the n maximums required, in which n = k-1
        to group the numbers by proximity we are gonna use the maximuns values of the edges weight to create
        intervals which represent the proximity values to group the array
        */
        int max = 0;
        int large[] = new int[k - 1]; //array to store the n maximums required

        for (int j = 0; j < k - 1; j++) {
            max = weightArr[0];
            for (int i = 1; i < weightArr.length; i++) {
                if (max < weightArr[i] ) {
                    max = weightArr[i];
                }
            }
            large[j] = max;
            
            //deleting the all instances of the maximum found so that we only have one of each value
            for (int r = 0; r < weightArr.length; r++) {
                if (weightArr[r] == max) {
                    weightArr[r] = Integer.MIN_VALUE;
                }
            }
        }

        sort(large); //since the maximuns are stored in reverse, the array need to be sorted, for less confusing during the next steps

        //put the integers into clusters
        
        /*
        for this method it was supposed to generate the clusters where to store the integers and the intervals using the maximuns procedurally but
        I was unable to find a way to do that in time so I choose to limit the numbers of groups to five and write the cases to how the algorthim would
        behave for each scenario
        */
        
        //instance the clusters where to store the integers
        List<Integer> cluster1 = new ArrayList();
        List<Integer> cluster2 = new ArrayList();
        List<Integer> cluster3 = new ArrayList();
        List<Integer> cluster4 = new ArrayList();
        List<Integer> cluster5 = new ArrayList();

        //depending on the number of groups asked, the system will behave according
        switch (k) {

            case (1):
                for (int i = 0; i < group.length; i++) {
                    System.out.println(group[i]);
                }
                break;

            case (2):
                for (int i = 0; i < group.length; i++) {
                    if (group[i] <= large[0]) {
                        cluster1.add(group[i]);
                    } else if (group[i] > large[0]) {
                        cluster2.add(group[i]);
                    }
                }
                System.out.println(cluster1 + "\n" + cluster2);
                break;

            case (3):

                for (int i = 0; i < group.length; i++) {
                    if (group[i] <= large[0]) {
                        cluster1.add(group[i]);
                    } else if (group[i] <= large[1]) {
                        cluster2.add(group[i]);
                    } else if (group[i] > large[1]) {
                        cluster3.add(group[i]);
                    }

                }

                System.out.println(cluster1 + "\n" + cluster2 + "\n" + cluster3);
                break;

            case (4):
                for (int i = 0; i < group.length; i++) {
                    if (group[i] <= large[0]) {
                        cluster1.add(group[i]);
                    } else if (group[i] <= large[1]) {
                        cluster2.add(group[i]);
                    } else if (group[i] > large[1] && group[i] <= large[2]) {
                        cluster3.add(group[i]);
                    } else if (group[i] > large[2]) {
                        cluster4.add(group[i]);
                    }

                }

                System.out.println(cluster1 + "\n" + cluster2 + "\n" + cluster3 + "\n" + cluster4);
                break;

            case (5):
                for (int i = 0; i < group.length; i++) {
                    if (group[i] <= large[0]) {
                        cluster1.add(group[i]);
                    } else if (group[i] <= large[1]) {
                        cluster2.add(group[i]);
                    } else if (group[i] > large[1] && group[i] <= large[2]) {
                        cluster3.add(group[i]);
                    } else if (group[i] > large[2] && group[i] <= large[3]) {
                        cluster4.add(group[i]);
                    } else if (group[i] > large[3]) {
                        cluster5.add(group[i]);
                    }

                }

                System.out.println(cluster1 + "\n" + cluster2 + "\n" + cluster3 + "\n" + cluster4 + "\n" + cluster5);
                break;
        }
    }

}
