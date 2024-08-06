import java.util.*;

public class Shape {
    protected final boolean[][] filled = new boolean[5][5];

    public Shape() {
        for (boolean[] bools : filled) {
            Arrays.fill(bools, false);
        }
        filled[2][2] = true;
    }

    public static Shape randomShape() {
        int randomShape = (int) (Math.random() * 11);
        int randomDirection = (int) (Math.random() * 4 + 1);
        HashMap<Integer, Shape> shapes = new HashMap<>();
        shapes.put(0, new BigL(randomDirection));
        shapes.put(1, new BigT(randomDirection));
        shapes.put(2, new Cross());
        shapes.put(3, new FiveLine(randomDirection));
        shapes.put(4, new FourLine(randomDirection));
        shapes.put(5, new SmallL(randomDirection));
        shapes.put(6, new SmallT(randomDirection));
        shapes.put(7, new ThreeDiagonal(randomDirection));
        shapes.put(8, new ThreeLine(randomDirection));
        shapes.put(9, new TwoDiagonal(randomDirection));
        shapes.put(10, new U(randomDirection));
        return shapes.get(randomShape);
    }
}
