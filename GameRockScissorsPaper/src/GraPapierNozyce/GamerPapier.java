package GraPapierNozyce;

public class GamerPapier extends GamerRandom implements IGamer {

    String name = "Papier";
    int number = 2;

    @Override
    public int play() {
        return number;
    }

    @Override
    public String name() {
        return name;
    }
}
