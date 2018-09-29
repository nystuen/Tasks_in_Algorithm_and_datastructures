package Oving3;

import java.util.Date;
import java.util.Random;

public class Oving4 {


    public static boolean checkSort(int[] array){
        boolean check = true;

        for(int i = 0; i<array.length-1; i++){
            if(array[i] > array[i+1]){
                return false;
            }
        }

        return check;
    }

    public static String toString(int[] t) {
        String s = "";
        for(int i : t) {
            s += (i + ", ");
        }
        return s.substring(0, s.length()-2);
    }

    public static int[] randomArray(int size){
        int[] random = new int[size];
        Random rnd = new Random();
        for(int i = 0; i<size; i++){
            random[i] = rnd.nextInt();
        }
        return random;
    }

    public static int[] similarArray(int size){
        int[] similar = new int[size];
        Random rnd = new Random();
        for(int i = 0; i<size; i++){
            similar[i] = rnd.nextInt();
            i++;
            if(i<size){
                similar[i] = similar[i-1];
            }
        }
        return similar;
    }

    public static int[] sortedArray(int size){
        int[] sorted = new int[size];
        for(int i = 0; i<size; i++){
            sorted[i] = i;
        }
        return sorted;
    }

    /**
     *
     * arrayType = 0 > random
     * arrayType = 1 > sorted
     * arrayType = 2 > similar
     *
     * sortType = 0 > quicksort
     * sortType = 1 > heapsort
     *
     */
    public static void takeTimeSort(int arrayType, int arraySize, int sortType){
        int[] tabell;
        if(arrayType == 0){
            tabell = randomArray(arraySize);
        } else if (arrayType == 1){
            tabell = sortedArray(arraySize);
        } else if (arrayType == 2){
            tabell = similarArray(arraySize); // generer tabell
        } else {
            throw new Error("feil arrayType");
        }

        double r[];
        Date start = new Date();
        int runder = 0;
        double tid;
        Date slutt;
        do {

            if(sortType == 0 ){
           Quicksort.quickSort(tabell, 0, tabell.length-1);
            } else if (sortType == 1){
                HeapSort.sort(tabell);
            } else {
                throw new Error("feil sortType");
            }


            slutt = new Date();
            ++runder;
        } while (slutt.getTime()-start.getTime() < 1000);
        tid = (double)
                (slutt.getTime()-start.getTime()) / runder;

        if(checkSort(tabell)){
            System.out.println("Tid: " + tid + " ms - Korrekt sortert");
        } else {
            System.out.println("TABELL ER IKKE KORREKT SORTERT.");
        }

    }

        public static void main(String[] args){

        int arrayType = 0;
        int arraySize = 100000;
        int sortType = 0;

        System.out.println("----Sammenligning mellom quicksort og heapsort----");
        System.out.println("\nRandom tabell 100000 elementer - Quicksort:");
        takeTimeSort(0, 100000, 0);
        System.out.println("\nRandom tabell 100000 elementer - Heapsort:");
        takeTimeSort(0, 100000, 1);

        System.out.println("\nSortert tabell 100000 elementer - Quicksort:");
        takeTimeSort(1, 100000, 0);
        System.out.println("\nSortert tabell 100000 elementer - Heapsort:");
        takeTimeSort(1, 100000, 1);

        System.out.println("\nSimilar tabell 100000 elementer - Quicksort:");
        takeTimeSort(2, 100000, 0);
        System.out.println("\nSimilar tabell 100000 elementer - Heapsort:");
        takeTimeSort(2, 100000, 1);

        }
}