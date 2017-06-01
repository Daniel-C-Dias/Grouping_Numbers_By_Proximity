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

        /*
       List<Integer> group1 = new ArrayList();
       List<Integer> group2 = new ArrayList();
       List<Integer> group3 = new ArrayList();
         */
        int n1 = 3;
        int n2 = 4;
        int n3 = 5;
        int group1[] = {16, 15, 14, 13, 34, 23, 24, 25, 26, 28, 45, 34, 23, 29, 12, 23, 45, 67, 23, 12, 34, 45, 23, 67, 23, 67};
        int group2[] = {16, 15, 14, 13, 34, 23, 24, 25, 26, 28, 45, 34, 23, 29, 12, 23, 45, 67, 23, 12, 34, 45, 23, 67, 23, 670};
        int group3[] = {160, 15, 14, 13, 34, 23, 24, 25, 26, 28, 45, 34, 23, 29, 12, 23, 45, 67, 23, 12, 34, 45, 23, 67, 23, 670};
        
        System.out.println(getSum(group1));
        
    }
    
    public static int groupUp(int[] array, int n) {
        return 0;
    }
    
    public static int getHighest(int[] array) {
        int highest = 0;
        
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                highest = array[i];
            } else {
                highest = array[i + 1];
            }
        }
        
        return highest;
    }
    
    public static int getSum(int[] array) {
        int sum = 0;
        
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
    
}
