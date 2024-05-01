package TheDoohickeyv5.Objects;

import java.util.*;

public class SSMap {
    private final TreeMap<Integer, List<Note>> mapdata;
    private final List<TimingPoint> timingPoints;

    public SSMap(){
        mapdata = new TreeMap<>();
        timingPoints = new ArrayList<>();
    }

    // it is what it fucking is
    public void add(Object obj){
        if (obj.getClass() == Note.class)
            addNote((Note) obj);
        else if (obj.getClass() == TimingPoint.class)
            addTimingPoint((TimingPoint) obj);
    }

    public void addNote(Note note) {
        List<Note> notes;
        if (mapdata.containsKey(note.timestamp))
            notes = mapdata.get(note.timestamp);
        else
            notes = new ArrayList<>();
        notes.add(note);
        mapdata.put(note.timestamp, notes);
    }

    public void addTimingPoint(TimingPoint tp) {
        timingPoints.add(tp);
    }

    public List<Note> getNoteAt(int timestamp) {
        return mapdata.get(timestamp);
    }

    public TreeMap<Integer, List<Note>> getMapdata() {
        return mapdata;
    }

    public List<TimingPoint> getTimingPoints() {
        return timingPoints;
    }
}
