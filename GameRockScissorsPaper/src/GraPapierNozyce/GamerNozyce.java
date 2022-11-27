package GraPapierNozyce;

public class GamerNozyce extends GamerRandom implements IGamer {

    String name = "Nożyce";
    int number = 3;

    @Override
    public int play() {
        return number;
    }

    @Override
    public String name() {
        return name;
    }
}
