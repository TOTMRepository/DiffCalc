package TheDoohickeyv5.Preprocessing;

import TheDoohickeyv5.Objects.TimingPoint;

import java.io.FileNotFoundException;

public class MetadataProcesser extends Processer<TimingPoint> {

    public MetadataProcesser(String file) throws FileNotFoundException {
        super(file);
    }

    @Override
    void readFile() {
        data = input.nextLine();
    }

    @Override
    TimingPoint parse(String tp) {
        String[] pointParts = tp.split("\\|");
        float bpm = Float.parseFloat(pointParts[0]);
        int timestamp = Integer.parseInt(pointParts[1]);
        return new TimingPoint(bpm, timestamp);
    }
}
