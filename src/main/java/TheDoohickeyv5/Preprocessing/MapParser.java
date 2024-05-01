package TheDoohickeyv5.Preprocessing;

import TheDoohickeyv5.Objects.*;

import java.io.FileNotFoundException;
import java.util.*;

public class MapParser {
    SSMap map;

    public MapParser(String source) throws FileNotFoundException {
        this.map = new SSMap();
        // will be moved
        Processer<Note> p = new MapProcesser(source + ".txt");
        p.processData(map);
    }

    public List<Distance> getNoteDistances() {
        List<Distance> output = new ArrayList<>();
        if (!map.getMapdata().isEmpty()) {
            output.addAll(sectionDistances(map.getMapdata().values()));
        }
        return output;
    }


    private List<Distance> sectionDistances(Collection<List<Note>> notes) {
        List<Distance> output = new ArrayList<>();
        List<Note> homogenNoteList = new ArrayList<>();
        for (List<Note> note : notes) {
            if (note != null) {
                if (note.size() > 1)
                    note = meganoteToNote(note);
                homogenNoteList.add(note.get(0));
            }
        }
        for (int i = 0; i < homogenNoteList.size() - 1; i++) {
            output.add(getDistance(homogenNoteList.get(i), homogenNoteList.get(i + 1)));
        }
        return output;
    }

    private Distance getDistance(Note n1, Note n2) {
        double xDist = Math.abs(n1.getxCoordinate() - n2.getxCoordinate());
        double yDist = Math.abs(n1.getyCoordinate() - n2.getyCoordinate());
        int time = (n2.getTimestamp() - n1.getTimestamp());
        return new Distance(xDist, yDist, time);
    }

    private List<Note> meganoteToNote(List<Note> note) {
        if (note.size() == 1)
            return List.of(note.get(0));

        double x = 0.0;
        double y = 0.0;
        for (Note n : note) {
            x += n.getxCoordinate();
            y += n.getyCoordinate();
        }
        return List.of(new Note(x / note.size(), y / note.size(), note.get(0).getTimestamp()));
    }
}
