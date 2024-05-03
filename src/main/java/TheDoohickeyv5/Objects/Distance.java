package TheDoohickeyv5.Objects;
public class Distance {
    double xoffset;
    double yoffset;
    int ms;

    public Distance(double xoffset, double yoffset, int ms){
        this.xoffset = xoffset;
        this.yoffset = yoffset;
        this.ms = ms;
    }

    public Double getEuclidDist(){
        return Math.sqrt(Math.pow(xoffset, 2) + Math.pow(yoffset, 2));
    }

    public Double getManhattanDist() {
        return Math.abs(xoffset) + Math.abs(yoffset);
    }

    public Double getAngle() {
        if (xoffset + yoffset == 0)
            return 0.0;
        else
            return Math.toDegrees(Math.atan(yoffset/xoffset));
    }

    @Override
    public String toString() {
        return "\nDistance: " + getEuclidDist() + "\t" + "Spacing: " + ms + "\t" + "Angle: " + getAngle();
    }
}
