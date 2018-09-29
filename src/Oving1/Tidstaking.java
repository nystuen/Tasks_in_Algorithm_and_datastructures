package Oving1;
import java.util.Date;

public class Tidstaking {

    static int[] valutaChange2 = {-1, 3, -9, 2, 2, -1, 2, -1, -5};
    static int[] result;
    private BestBuyAndSellDate o = new BestBuyAndSellDate(valutaChange2);

    public static int[] randomArray(int arraySize){

        int[] array = new int[arraySize];

        for(int i = 0; i<arraySize; i++){
            array[i] = (int)(Math.random() * 10*(Math.pow(-1, i)));
        }
        return array;
    }

    /*
        0.0137 - 100
        1.137 - 1000
        108.3 - 10000
        12420 - 100000
     */

    public static void main(String[] args){
        valutaChange2 = randomArray(10000);

        Date start = new Date();
        result  = BestBuyAndSellDate.biggestDifference(valutaChange2);
        int runder = 0;
        double tid;
        Date slutt;
        do {
            result  = BestBuyAndSellDate.biggestDifference(valutaChange2);
            slutt = new Date();
            ++runder;
        } while (slutt.getTime()-start.getTime() < 1000);
        tid = (double)
                (slutt.getTime()-start.getTime()) / runder;
        System.out.println("Millisekund pr. runde:" + tid);

        for(int i = 0; i<result.length; i++){
            System.out.println("\n" + result[i]);
        }

    }
}
