import java.util.*;
import java.awt.*;
import javax.swing.*;

public class ShapePreview extends JPanel {
    private JFrame frame;
    private final ArrayList<JPanel> panels = new ArrayList<>();
    private final Shape[] shapes = new Shape[3];
    private static final int shortSide = 200;
    private static final int longSide = 500;

    public ShapePreview() {
        setVisible(true);
        setBackground(Color.white);
        setLayout(new GridLayout(1, 3, 2, 2));
        setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        for (int i = 0; i < 3; i++) {
            panels.add(new FiveByFive());
            add(panels.get(i));
        }
        FiveByFive fbf1 = (FiveByFive) panels.get(0);
        FiveByFive fbf2 = (FiveByFive) panels.get(1);
        FiveByFive fbf3 = (FiveByFive) panels.get(2);
        for (int i = 0; i < 3; i++) {
            shapes[i] = Shape.randomShape();
        }
        fbf1.add(shapes[0]);
        fbf2.add(shapes[1]);
        fbf3.add(shapes[2]);
        frame = new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setSize(longSide, shortSide);
        frame.add(this);
        frame.setVisible(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Shape getShape(int number) {
        return shapes[number];
    }

    public void remove(int shape) {
        FiveByFive fbf = (FiveByFive) panels.get(shape);
        fbf.clear();
    }

    public static void main(String[] args) {
    }
}
