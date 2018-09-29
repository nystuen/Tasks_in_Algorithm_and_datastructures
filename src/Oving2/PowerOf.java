package Oving2;

import java.util.Date;

public class PowerOf {

    public static double power1(double x, int n){
        if(n == 0){
            return 1;
        } else {
            return x*power1(x, n-1);
        }
    }

    public static double power3(double x, int n){
        if(n == 0){
            return 1;
        } else if (n%2==0){//partall
            return power3((x*x), n/2);
        } else {//oddetall
            return x * power3((x*x), ((n-1)/2));
        }
    }


    public static void main(String[] args){
  /*      System.out.println(power1(87,100));
        System.out.println(Math.pow(87,100) );
        System.out.println(power3(87, 100 ));  */
        double r;
        Date start = new Date();
        int runder = 0;
        double tid;
        Date slutt;
        do {
            r = Math.pow(5, 100);
            slutt = new Date();
            ++runder;
        } while (slutt.getTime()-start.getTime() < 1000);
        tid = (double)
                (slutt.getTime()-start.getTime()) / runder;
        System.out.println("Millisekund pr. runde:" + tid);

    }
}
