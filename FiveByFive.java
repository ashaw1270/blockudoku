import java.util.*;
import java.awt.*;
import javax.swing.*;

public class FiveByFive extends JPanel {
    private final JPanel[][] panels = new JPanel[5][5];
    private final boolean[][] filled = new boolean[5][5];
    private Shape shape;

    public FiveByFive() {
        setBackground(Color.white);
        setLayout(new GridLayout(5, 5, 2, 2));
        setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        for (int i = 0; i < panels.length; i++) {
            for (int j = 0; j < panels[i].length; j++) {
                panels[i][j] = new JPanel(new GridLayout(5, 5));
                panels[i][j].setBackground(Color.white);
                filled[i][j] = false;
                add(panels[i][j]);
            }
        }
    }

    public void fill(int row, int col) {
        panels[row][col].setBackground(Color.blue);
        filled[row][col] = true;
    }

    public void add(Shape s) {
        shape = s;
        for (int i = 0; i < s.filled.length; i++) {
            for (int j = 0; j < s.filled[i].length; j++) {
                if (s.filled[i][j]) {
                    fill(i , j);
                }
            }
        }
    }

    public void clear() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                panels[i][j].setBackground(Color.white);
                filled[i][j] = false;
            }
        }
    }

    public static void main(String[] args) {
    }
}
