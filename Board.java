import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Board extends JFrame {
    private JFrame frame;
    private final JPanel[][] panels = new JPanel[3][3];
    private static final int size = 600;
    private Shape currentShape;
    private ShapePreview currentShapePreview;

    public Board() {
        JPanel gameBoard = new JPanel();
        gameBoard.setVisible(true);
        gameBoard.setSize(500, 500);
        gameBoard.setBackground(Color.white);
        gameBoard.setLayout(new GridLayout(3, 3, 2, 2));
        gameBoard.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                panels[i][j] = new ThreeByThree();
                gameBoard.add(panels[i][j]);
            }
        }
        setVisible(true);
        getContentPane().setLayout(null);
        setSize(500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameBoard.setBounds(0, 0, 500, 500);
        getContentPane().add(gameBoard);
    }

    public JPanel panel(int row, int col) {
        ThreeByThree tbt = (ThreeByThree) panels[row / 3][col / 3];
        return tbt.panel(row % 3, col % 3);
    }

    public void fill(int row, int col) {
        ThreeByThree tbt = (ThreeByThree) panels[row / 3][col / 3];
        tbt.fill(row % 3, col % 3);
    }

    public void markFits(int row, int col) {
        ThreeByThree tbt = (ThreeByThree) panels[row / 3][col / 3];
        tbt.markFits(row % 3, col % 3);
    }

    public void unmarkFits(int row, int col) {
        ThreeByThree tbt = (ThreeByThree) panels[row / 3][col / 3];
        tbt.unmarkFits(row % 3, col % 3);
    }

    public boolean isFilled(int row, int col) {
        if (row < 0 || col < 0 || row > 8 || col > 8) {
            return true;
        }
        ThreeByThree tbt = (ThreeByThree) panels[row / 3][col / 3];
        return tbt.isFilled(row % 3, col % 3);
    }

    public boolean fits(Shape s, int row, int col) {
        for (int i = 0; i < s.filled.length; i++) {
            for (int j = 0; j < s.filled[i].length; j++) {
                if (s.filled[i][j] && isFilled(i - 2 + row, j - 2 + col)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void select(int shapeOnShapeSelection) throws DoesNotFitException {
        Shape s = currentShapePreview.getShape(shapeOnShapeSelection);
        currentShape = s;
        whereItFits(s);
        Scanner reader = new Scanner(System.in);
        System.out.print("Where? (x, y): ");
        String where = reader.nextLine();
        int x = Integer.parseInt(where.substring(0, 1));
        int y = Integer.parseInt(where.substring(3, 4));
        if (fits(s, y, x)) {
            add(shapeOnShapeSelection, y, x);
        } else {
            throw new DoesNotFitException("Does not fit");
        }
    }

    public void add(int shapeOnShapePreview, int row, int col) {
        undoWhereItFits(currentShape);
        Shape s = currentShapePreview.getShape(shapeOnShapePreview);
        for (int i = 0; i < s.filled.length; i++) {
            for (int j = 0; j < s.filled[i].length; j++) {
                if (s.filled[i][j]) {
                    fill(i - 2 + row, j - 2 + col);
                }
            }
        }
        currentShapePreview.remove(shapeOnShapePreview);
        clear();
    }

    public void whereItFits(Shape s) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (fits(s, i, j)) {
                    markFits(i, j);
                }
            }
        }
    }

    public void undoWhereItFits(Shape s) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (fits(s, i, j)) {
                    unmarkFits(i, j);
                }
            }
        }
    }

    public void clear() {
        ThreeByThree tbt;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tbt = (ThreeByThree) panels[i][j];
                if (tbt.isFull()) {
                    tbt.clear();
                }
            }
        }
    }

    public void run() throws DoesNotFitException {
        ShapePreview sp;
        Scanner reader = new Scanner(System.in);
        String yesno;
        int selection;
        do {
            sp = new ShapePreview();
            currentShapePreview = sp;
            Rectangle location = new Rectangle(0, 500, 500, 200);
            currentShapePreview.setBounds(location);
            getContentPane().add(currentShapePreview);
            for (int i = 0; i < 3; i++) {
                System.out.print("Select: ");
                selection = reader.nextInt();
                this.select(selection);
            }
            System.out.print("Play again? (y/n): ");
            reader.nextLine();
            yesno = reader.nextLine();
            getContentPane().remove(currentShapePreview);
        } while (yesno.equals("y"));
        System.out.println("done");
    }

    public static void main(String[] args) throws DoesNotFitException {
        Board board = new Board();
        board.run();
    }
}