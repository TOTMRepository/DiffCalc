package TheDoohickeyv5.Preprocessing;

import TheDoohickeyv5.Objects.SSMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Processer<T> {
    Scanner input;
    String data;

    public Processer(String file) throws FileNotFoundException {
        input = new Scanner(new File(file));
    }

    abstract void readFile();
    abstract T parse(String s);
    abstract void addElement(SSMap map, T element);

    public void processData(SSMap map) {
        readFile();
        for (String s : data.split(",")) {
            addElement(map, parse(s));
        }
    }
}
