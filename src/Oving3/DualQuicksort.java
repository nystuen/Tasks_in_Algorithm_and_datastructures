package Oving3;

public class DualQuicksort {

    /*
     * Sorterer array med quicksort med bruk av 2 delingsverdier, low = startpunkt, high = sluttpunt
     */

    static void dualQuickSort(int[] arr, int lowIndex, int highIndex) {

        if(highIndex <= lowIndex) {
            return;
        }

        if(arr[lowIndex] > arr[highIndex]) {
            swap(arr, lowIndex, highIndex);
        }

        int pivot1 = arr[lowIndex];
        int pivot2 = arr[highIndex];

        int lt = lowIndex + 1;
        int gt = highIndex - 1;
        int i = lowIndex + 1;

        while(i <= gt) {
            if(arr[i] < pivot1) {
                swap(arr, i, lt);
                lt++;
                i++;
            } else if(arr[i] > pivot2) {
                swap(arr, i, gt);
                gt--;
            } else {
                i++;
            }
        }

        swap(arr, lowIndex, lt-1);
        swap(arr, gt+1, highIndex);

        lt--;
        gt++;

        dualQuickSort(arr, lowIndex, lt-1);
        dualQuickSort(arr, lt+1, gt-1);
        dualQuickSort(arr, gt+1, highIndex);

    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


}
