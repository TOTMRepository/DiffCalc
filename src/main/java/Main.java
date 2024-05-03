import TheDoohickeyv5.Objects.Distance;
import TheDoohickeyv5.Preprocessing.*;

import java.io.IOException;

public class Main {
    // testing stuff
    public static void main(String[] args) throws IOException {
        MapParser calc = new MapParser("test");
        for (Distance d : calc.getNoteDistances()) {
            System.out.println(d.toString());
        }
    }
}
