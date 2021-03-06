package puntos;

import javax.persistence.Embeddable;

@Embeddable
public class Point {
    private Double x;
    private Double y;

    public Point(int x, int y) {
        this.x = (double) x;
        this.y = (double) y;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public double distance(Point otroPunto) {
        double distanciaX = otroPunto.getX() - this.getX();
        double distanciaY = otroPunto.getY() - this.getY();
        return Math.sqrt(Math.pow(distanciaX, 2) + Math.pow(distanciaY, 2));
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
