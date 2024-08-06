public class FourLine extends Shape {
    public FourLine(int direction) {
        switch (direction) {
            //vertical
            case 1, 2 -> {
                filled[1][2] = true;
                filled[3][2] = true;
                filled[4][2] = true;
            }
            //horizontal
            case 3, 4 -> {
                filled[2][1] = true;
                filled[2][3] = true;
                filled[2][4] = true;
            }
        }
    }
}
