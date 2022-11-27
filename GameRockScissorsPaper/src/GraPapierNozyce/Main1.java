package GraPapierNozyce;

import java.util.Random;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {

        System.out.println("----------------=====GRA ROZPOCZETA=====-------------------");
        System.out.println("-----------------------------------------------------------");
        System.out.println("----------=====:Prosze o podanie liczby rund:=====---------");
        System.out.println();
        Scanner scan = new Scanner(System.in);
        int liczbaRund = scan.nextInt();

        Random rand = new Random();
        int x = rand.nextInt(3)+1;
        Arena gra1 = new Arena(x);
        gra1.fight(liczbaRund);



    }



}