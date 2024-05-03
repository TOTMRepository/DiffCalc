package TheDoohickeyv5.Objects;
public class Distance {
    Note first;
    Note second;

    public Distance(Note n1, Note n2){
        first = n1;
        second = n2;
    }

    public double getXoffset() {
        return Math.abs(first.getxCoordinate() - second.getxCoordinate());
    }

    public double getYoffset() {
        return Math.abs(first.getyCoordinate() - second.getyCoordinate());
    }

    public int getMs() {
        return second.getTimestamp() - first.getTimestamp();
    }

    public Double getEuclidDist(){
        return Math.sqrt(Math.pow(getXoffset(), 2) + Math.pow(getYoffset(), 2));
    }

    public Double getManhattanDist() {
        return Math.abs(getXoffset()) + Math.abs(getYoffset());
    }

    public boolean isLongJump(){
        return getEuclidDist() >= 2;
    }

    public Double getAngle() {
        double xOffset = getXoffset(), yOffset = getYoffset();
        if (xOffset + yOffset == 0)
            return 0.0;
        else
            return Math.toDegrees(Math.atan(yOffset/xOffset));
    }

    @Override
    public String toString() {
        return "\nDistance: " + getEuclidDist() + "\t" + "Spacing: " + getMs() + "\t" + "Angle: " + getAngle();
    }
}
