package TheDoohickeyv5.Objects;

import java.util.*;

public class SSMap {
    private final TreeMap<Integer, List<Note>> mapdata;
    private final List<TimingPoint> timingPoints;

    public SSMap(){
        mapdata = new TreeMap<>();
        timingPoints = new ArrayList<>();
    }

    public void addNote(Note note){
        List<Note> notes;
        if (mapdata.containsKey(note.getTimestamp()))
            notes = mapdata.get(note.getTimestamp());
        else
            notes = new ArrayList<>();
        notes.add(note);
        mapdata.put(note.getTimestamp(), notes);
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
