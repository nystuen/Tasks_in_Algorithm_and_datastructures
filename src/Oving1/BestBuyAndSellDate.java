package Oving1;
import java.util.Arrays;


public class BestBuyAndSellDate {

    static int[] valutaChange2 = {-1, 3, -9, 2, 2, -1, 2, -1, -5};
    static int[] valutaChange;

    public BestBuyAndSellDate(int[] valutaChange){
        this.valutaChange = valutaChange;
    }


    public static int[] biggestDifference(int[] array){

        int bestBuyDate = 0;                                // 1
        int bestSellDate = 0;                               // 1
        int biggestDifference = 0;                          // 1
        int[] diffHelp = new int[2];
        int[] result = new int[3];                          // 1

        for(int i = 0; i<array.length; i++){                // 2n + 1

            diffHelp = biggestDifferenceAtDay(i, array);    // n^2
            if (diffHelp[1] > biggestDifference){           // 2n
                bestBuyDate = i;                            // 1
                biggestDifference = diffHelp[1];            // 2n
                bestSellDate = diffHelp[0];                 // 2n
            }
        }

        result[0] = bestBuyDate;                            // 1
        result[1] = bestSellDate;                           // 1
        result[2] = biggestDifference;                      // 1

        return result;                                      // Forenklet utrykk: O(n^2)
    }

    public static int[] biggestDifferenceAtDay(int buyDate, int[] array){

        int difference = 0;

        int buyDifference = 0;
        int bestSellDate = -1;
        int bestDifference = -100;
        int[] result = new int[2];

        for(int i = 0; i<array.length; i++){

            // Sjekker først om i <) buydate. Dersom det er det brukes disse dagene på å kalkulere valuta fram til kjøpsdato.
            if(i<buyDate){
                difference += array[i];
                buyDifference = difference;
            } else { // etter buyDate brukes dagene for å finne den beste salgsdagen
                if(difference + array[i] > bestDifference){
                    difference += array[i];
                    bestDifference = difference;
                    bestSellDate = i+1;
                } else {
                    difference += array[i];
                }
            }
        }

        result[0] = bestSellDate;
        result[1] = getDifferenceBetweenTwoNumbers(buyDifference, bestDifference);

        return result;
    }


    public static int getDifferenceBetweenTwoNumbers(int buy, int sell){

        if(buy == sell){
            return 0;
        } else if (buy < sell){

            if(buy < 0 && sell < 0){
                return (buy*(-1) - sell*(-1));
            } else if (buy < 0 && sell > 0){
                return (buy*(-1) - sell);
            } else if (buy > 0 && sell > 0){
                return (buy*-1 - sell*(-1));
            } else if (buy == 0 && sell > 0){
                return sell;
            } else if (buy < 0 && sell == 0){
                return (-1)*buy;
            }

        } else if (sell > buy){

            if(buy > sell){
                if (buy > 0 && sell < 0){
                    return (buy*(-1) - sell);
                } else if (buy > 0 && sell > 0){
                    return (buy*(-1) - sell*(-1));
                } else if (buy < 0 && sell < 0){
                    return (buy*(-1) - sell*(-1));
                } else if (buy == 0 && sell < 0){
                    return (sell);
                } else if (buy > 0 && sell == 0){
                    return buy*(-1);
                }
            }
        }

        return -1000000;
    }

    public static void main(String args[]){
        BestBuyAndSellDate o = new BestBuyAndSellDate(valutaChange2);
    }



}