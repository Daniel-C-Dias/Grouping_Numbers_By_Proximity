/*
Grouping based on absolut value difference between elements in the input array, using index position of maximum values
*/


package groupinnumbersbyproximity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Daniel Dias
 */
public class Group {

    public void agrupar(int[] arrayInput, int nrOfGroups) {

        int arraySize = arrayInput.length;
        if (nrOfGroups > arraySize) {
            System.out.println("Number of groups higher than number of elements in array!");
        } else {
            Arrays.sort(arrayInput);
            System.out.println("Orginal Array Sorted: " + Arrays.toString(arrayInput));
            int nrMaximos = nrOfGroups - 1;
            int[] maximusArray = new int[nrOfGroups];
            maximusArray[0] = 0;

            List<Integer> differenceList = new ArrayList();
            for (int i = 1; i < arraySize; i++) {
                differenceList.add(arrayInput[i] - arrayInput[i - 1]);
            }

            for (int i = 1; i < nrOfGroups; i++) {
                int max = Collections.max(differenceList);
                int indexMax = differenceList.indexOf(max);
                maximusArray[i] = indexMax;
                differenceList.set(indexMax, -1);
            }

            Arrays.sort(maximusArray);

            List<int[]> groupsList = new ArrayList();
            for (int i = 0; i < nrMaximos; i++) {
                if (i == 0) {
                    groupsList.add(Arrays.copyOfRange(arrayInput, maximusArray[i], maximusArray[i + 1] + 1));
                } else {
                    groupsList.add(Arrays.copyOfRange(arrayInput, maximusArray[i] + 1, maximusArray[i + 1] + 1));
                }
            }
            groupsList.add(Arrays.copyOfRange(arrayInput, maximusArray[maximusArray.length - 1] + 1, arraySize));

            System.out.println("The resulting groups are presented below: ");

            groupsList.stream().forEach((array) -> {
                System.out.println(Arrays.toString(array));
            });
        }
    }

}
