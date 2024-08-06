import java.awt.*;
import javax.swing.*;

public class ThreeByThree extends JPanel {
    private final JPanel[][] panels = new JPanel[3][3];
    private final boolean[][] filled = new boolean[3][3];

    public ThreeByThree() {
        setBackground(Color.lightGray);
        setLayout(new GridLayout(3, 3, 2, 2));
        setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        for (int i = 0; i < panels.length; i++) {
            for (int j = 0; j < panels[i].length; j++) {
                panels[i][j] = new JPanel(new GridLayout(3, 3));
                filled[i][j] = false;
                add(panels[i][j]);
            }
        }
    }

    public void fill(int row, int col) {
        panels[row][col].setBackground(Color.blue);
        filled[row][col] = true;
    }

    public void markFits(int row, int col) {
        panels[row][col].setBackground(Color.yellow);
    }

    public void unmarkFits(int row, int col) {
        panels[row][col].setBackground(Color.white);
    }

    public boolean isFilled(int row, int col) {
        return filled[row][col];
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isFilled(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                panels[i][j].setBackground(Color.white);
                filled[i][j] = false;
            }
        }
    }

    public JPanel panel(int row, int col) {
        return panels[row][col];
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(500, 500);
        ThreeByThree tbt = new ThreeByThree();
        frame.add(tbt);
    }
}
