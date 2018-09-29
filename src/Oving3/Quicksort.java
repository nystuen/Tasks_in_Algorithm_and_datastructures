package Oving3;

public class Quicksort {

    public static void quickSort(int[] arr, int v, int h) {
        if (h - v > 2) {
            int delepos = splitt(arr,v,h);
            quickSort(arr,v,delepos - 1);
            quickSort(arr,delepos + 1,h);
        } else {
            median3sort(arr,v,h);
        }

    }


    private static int median3sort(int[] arr, int v, int h){
        int m = ((v+h)/2);
        if(arr[v] > arr[m] ){ bytt(arr,v,m);}
        if(arr[m] > arr[h]) {
            bytt(arr,m,h);
            if(arr[v]>arr[m]){
                bytt(arr,v,m);
            }
        }
        return m;
    }

    private static int splitt(int[] arr, int v, int h){
        int iv, ih;
        int m = median3sort(arr,v,h);
        int dv = arr[m];
        bytt(arr,m,(h-1));
        iv = v; ih = h-1;
        while(true){
            while(arr[++iv] < dv);
            while(arr[--ih] > dv);
            if(iv >= ih) break;
            bytt(arr,iv,ih);
        }
        bytt(arr,iv,h-1);

        return iv;
    }

    private static void bytt(int[] arr, int i, int j){
        int k = arr[j];
        arr[j] = arr[i];
        arr[i] = k;
    }

}
