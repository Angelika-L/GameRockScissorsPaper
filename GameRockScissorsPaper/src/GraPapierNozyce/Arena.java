package GraPapierNozyce;

import javax.management.relation.RelationSupport;
import java.util.Random;
import java.util.Scanner;

public class Arena {

    //pojedynki pomiedzy graczmi

    IGamer iGamer1;
    IGamer iGamer2;

    //zasada //1 – Kamień 2 – Papier 3 – Nożyce

    public Arena(int x) {
        if(x==1)this.iGamer1 = new GamerKamien();
        else if(x==2)this.iGamer1 = new GamerPapier();
        else this.iGamer1 = new GamerNozyce();
        this.iGamer2 = new GamerRandom();
    }

   public  void fight(int liczbaRund){
        //symulowanie gry pomiedzy graczmi

       int liczba = 1;
       int wynik1 = 0;
       int wynik2 = 0;

       //implementacja markowania:
       AdvancedGamer fakeIGamer1 = new AdvancedGamer() {
           @Override
           public String name() {
               this.gamerName = "komp";
               return this.name;
           }

           @Override
           public int fake() {
               int mark;
               if(this.dodaj==0)  {
                   if(this.number==3) mark = 1;
                   else if (this.number==2) mark = 3;
                   else mark = 2;
               }
               else if (this.dodaj ==2) {
                   this.number = iGamer1.play();
                   mark = this.number;
               }
               else mark = this.number;

               if (mark==1) this.name = "Kamień";
               else if (mark==2) this.name =  "Papier";
               else if (mark==3) this.name =  "Nożyce";

               return mark;
           }

           @Override
           public int play(int fake) {
               int zagranieMoje;
               int a = 0;
               if(this.name()==null){
                   zagranieMoje = iGamer1.play();
                   this.dodaj = 2;
                   this.fake();
                   if(zagranieMoje == fake) {
                       this.dodaj = 0;
                       a = this.fake();
                   }
                   else if (zagranieMoje<fake) {
                       this.dodaj = 1;
                       a = this.fake();
                   }
                   else if (zagranieMoje==1 && fake==3){
                       a = 1;
                   }
                   else a = zagranieMoje;

               } else {
                   Random rand = new Random();
                   int x = rand.nextInt(3)+1;
                   zagranieMoje = x;
                   if(zagranieMoje == fake) {
                       this.dodaj = 0;
                       a = this.fake();
                   }
                   else if (zagranieMoje<fake) {
                       this.dodaj = 1;
                       a = this.fake();
                   }
                   else if (zagranieMoje==1 && fake==3){
                       a = 1;
                   }
                   else a = zagranieMoje;
               }


               return a;
           }

           @Override
           public void result(int enumyMove) {
               int numberF;
               if(this.number>=1) numberF = this.number;
               else numberF = iGamer1.play();
               if(numberF != enumyMove) System.out.println("-:gracz " +this.toString()+" w zagraniu markuje z: " +numberF+" na: "+ enumyMove +"." );

           }
       };
       AdvancedGamer fakeRandom2 = new AdvancedGamer() {
           @Override
           public String name() {
               this.gamerName = "s21401";
               return this.name;
           }

           @Override
           public int fake() {
               System.out.println("?markujesz ~~?");
               Scanner scan2 = new Scanner(System.in);
               Integer wyborm = scan2.nextInt();
               if(wyborm==1) {
                   this.number = 1;
                   this.name = "Kamień";
               }
               else if(wyborm==2){
                   this.number =2;
                   this.name = "Papier";
               }
               else if(wyborm==3) {
                   this.number = 3;
                   this.name = "Nożyce";
               }
               return this.number;
           }

           @Override
           public int play(int fake) {
               return 0;
           }

           @Override
           public void result(int enumyMove) {
               if(enumyMove!=this.number) System.out.println("-:gracz "+ this.toString()+" w zagraniu markuje z: "+ enumyMove +" na: "+ this.number +"." );
               else System.out.println("-:gracz "+ this.toString()+" nie markuje zagrania.");

           }
       };

       fakeRandom2.name();
       fakeIGamer1.name();

       while (liczba<=liczbaRund)
       {
           System.out.println("--=:RUNDA: " + liczba);
           System.out.println("--=:podaj wyborór:  (1=Kamień, 2=Papier, 3=Nożyce)");
           Scanner scan = new Scanner(System.in);
           int wybor = scan.nextInt();
           Random rand = new Random();
           int x = rand.nextInt(3)+1;
           fakeIGamer1.play(x);
           int wygrana;


            //rozegranie markowania:
           int wybor1 = fakeRandom2.fake();

           int  wyborIGamer = fakeIGamer1.play(wybor);

           wygrana = MojaKlasaAlgorytm.tajnyAlgorytm(wybor1, wyborIGamer);

            if(wygrana==1) {
                System.out.println("--=:WYGRAŁ GRACZ: " + fakeIGamer1.toString());
                if(liczba==1){
                    if(wyborIGamer==1) System.out.println("--=:ZAGRANO: Kamień bije "+fakeRandom2.name() +"." );
                    else if (wyborIGamer==2) System.out.println("--=:ZAGRANO: Papier bije "+fakeRandom2.name() +"." );
                    else System.out.println("--=:ZAGRANO: Nożyce bije "+fakeRandom2.name() +"." );;
                }
                else System.out.println("--=:ZAGRANO: " +fakeIGamer1.name() +" bije "+fakeRandom2.name() +"." );
                fakeIGamer1.result(wyborIGamer);
                fakeRandom2.result(wybor);
                wynik1++;
            }
            else if (wygrana == 0) {
                System.out.println("--=:Wynik: REMIS ");
                fakeIGamer1.result(wyborIGamer);
                fakeRandom2.result(wybor);
            }
            else {
                System.out.println("--=:WYGRAŁ GRACZ: " + fakeRandom2.toString());
                System.out.println("--=:ZAGRANO: " + fakeRandom2.name()+ " bije " + fakeIGamer1.name() + ".");
                fakeIGamer1.result(wyborIGamer);
                fakeRandom2.result(wybor);
                wynik2++;
            }
           System.out.println();
           liczba++;


       }
       System.out.println();
       System.out.println("*******************************************************************************************");
       System.out.println("--:Wynik po rozegraniu : "+ liczbaRund+" rund.");
       System.out.println("--:Gracz "+ fakeIGamer1.toString() +"  ma wynik: "+ wynik1);
       System.out.println("--:Gracz "+ fakeRandom2.toString()+"   ma wynik: "+ wynik2);
       if(wynik1>wynik2)System.out.println("--=:Wygrywa: " + fakeIGamer1.toString());
       else if(wynik1==wynik2)System.out.println("--=:REMIS");
       else System.out.println("--:Wygrywa: "+ fakeRandom2.toString());
       System.out.println();
       System.out.println("Koniec gry");

   }

}
