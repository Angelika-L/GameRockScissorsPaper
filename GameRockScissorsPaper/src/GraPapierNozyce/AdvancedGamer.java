package GraPapierNozyce;

public abstract class AdvancedGamer {


    String gamerName;
    String name;
    int number;
    int dodaj;

    public abstract String name(); //zwraca nazwe gracza
    public abstract int fake(); //zwraca fauszywe zagranie
    public abstract int play(int fake); //
    public abstract void result(int enumyMove);

    @Override
    public String toString() {
        super.toString();
        return this.gamerName;
    }

}
