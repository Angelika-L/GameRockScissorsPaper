package GraPapierNozyce;

public class GamerRandom implements IGamer {

    int number = 0;
    String name = "Random";


    @Override
    public int play() {
        return number;
    }

    @Override
    public String name() {
        return name;
    }
}
