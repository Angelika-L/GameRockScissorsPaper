package GraPapierNozyce;

public class MojaKlasaAlgorytm implements IGamer {

//        1 – Kamień 2 – Papier 3 – Nożyce

    static int tajnyAlgorytm(int random, int przeciwnik){
       if((random==1&&przeciwnik==2) || (random==3&&przeciwnik==1) || (random==2&&przeciwnik==3))
           return 1;
       else if((random==2&&przeciwnik==1) || (random==1&&przeciwnik==3) || (random==3&&przeciwnik==2))
           return 2;
       else
           return 0;
    }


    @Override
    public int play() {
        return 0;
    }

    @Override
    public String name() {
        return null;
    }
}
