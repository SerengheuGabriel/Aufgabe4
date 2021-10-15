package map;

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) {
        /*
        Aufgabe 1 Test
        int[] tast = {40, 35, 70, 15, 45};
        System.out.println(billigste(tast));*/
        /*
        Aufgabe 2
        int[] tast = {15, 20, 10, 35};
        int[] usb = {20, 15, 40, 15};
        System.out.println(teuerste(tast, usb));*/
        /*
        Aufgabe 3
        int[] usb = {15, 45, 20};
        int budget = 30;
        System.out.println(teuerste_budget(usb, budget));
         */
        //Aufgabe 4
        //int[] tast = {40,50,60}; test care da bine
        //int[] usb = {8,12};
        int[] tast = {60}; //test care da -1 pt ca nu are bani sa cumpere usb si tastatura
        int[] usb = {8,12};
        int budget = 60;
        System.out.println(teuerste_combo(tast,usb,budget));
    }

    /**
     *
     * @param tast array cu preturi (int)
     * @return min dintr-un array primit ca parametru
     */

    public static int billigste(int[] tast){
        int min = Integer.MAX_VALUE;
        for(int i=0; i<tast.length; i++){
            if(tast[i] < min) min=tast[i];
        }
        return min;
    }

    /**
     *
     * @param tast array cu preturi (int)
     * @param usb array cu preturi (int)
     * @return max dintre doua array-uri primit ca parametru
     */

    public static int teuerste(int[] tast, int[] usb){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<tast.length; i++){
            if(tast[i] > max) max=tast[i];
        }
        for(int i=0; i<usb.length; i++){
            if(usb[i] > max) max=usb[i];
        }
        return max;
    }

    /**
     *
     * @param usb array cu preturi (int)
     * @param budget o valoare integer care reprezinta un buget maxim
     * @return max dintr-un array primit ca parametru, max sa fie mai mic decat un buget
     */

    public static int teuerste_budget(int[] usb, int budget){
        int max = Integer.MIN_VALUE;
        int change = 0;
        for(int i=0; i<usb.length; i++){
            if(usb[i] > max && usb[i] <= budget) {
                max=usb[i];
                change = 1;
            }
        }
        if (change == 0) return -1;
        return max;
    }

    /**
     *
     * @param tast array de preturi
     * @param usb array de preturi
     * @param budget o valoare integer care reprezinta un buget maxim
     * @return      * suma maxima dintre doua elemente din doua array-uri, suma sa fie mai mica sau egal cu un buget
     */

    public static int teuerste_combo(int[] tast, int[] usb, int budget){
        int sum_max = 0;
        int s = 0;
        for(int i=0; i<tast.length && sum_max != budget; i++) {
            for(int j=0; j<usb.length && sum_max != budget; j++) {
                s = tast[i] + usb[j];
                if(abs(budget-s) < abs(budget-sum_max) && s <= budget){
                    sum_max = s;
                }
            }
        }
        if(sum_max == 0) return -1;
        return sum_max;
    }

}
