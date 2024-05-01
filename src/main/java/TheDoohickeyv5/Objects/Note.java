package TheDoohickeyv5.Objects;

public class Note {
    double xCoordinate;
    double yCoordinate;
    int timestamp;

    public Note(double x, double y, int timestamp) {
        xCoordinate = x;
        yCoordinate = y;
        this.timestamp = timestamp;
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public String toString(){
        return "(" + xCoordinate + "," + yCoordinate + ")";
    }
}
