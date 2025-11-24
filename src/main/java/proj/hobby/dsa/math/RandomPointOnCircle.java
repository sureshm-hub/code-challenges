package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/generate-random-point-in-a-circle
 *
 */
public class RandomPointOnCircle {

    private final double radius;
    private final double x_cent;
    private final double y_cent;

    public RandomPointOnCircle(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_cent = x_center;
        this.y_cent = y_center;
    }

    public double[] randPoint() {
        final double length = Math.sqrt(Math.random()) * radius;
        final double degree = Math.random() * 2 * Math.PI;
        final double x = x_cent + length * Math.cos(degree);
        final double y = y_cent + length * Math.sin(degree);

        return new double[] {x, y};
    }
}
