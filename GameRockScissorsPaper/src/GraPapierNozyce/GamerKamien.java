package GraPapierNozyce;

public class GamerKamien extends GamerRandom implements IGamer {

    String name = "Kamień";
    int number = 1;

    @Override
    public int play() {
        return number;
    }

    @Override
    public String name() {
        return name;
    }
}
