package TheDoohickeyv5.Preprocessing;

import TheDoohickeyv5.Objects.Note;

import java.io.FileNotFoundException;

public class MapProcesser extends Processer<Note> {

    public MapProcesser(String file) throws FileNotFoundException {
        super(file);
    }

    @Override
    void readFile() {
        data = input.nextLine().split(",",2)[1];
    }

    @Override
    Note parse(String note) {
        String[] noteParts = note.split("\\|");
        float x = Float.parseFloat(noteParts[0]);
        float y = Float.parseFloat(noteParts[1]);
        int timestamp = Integer.parseInt(noteParts[2]);
        return new Note(x, y, timestamp);
    }
}
