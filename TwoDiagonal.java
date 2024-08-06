public class TwoDiagonal extends Shape {
    public TwoDiagonal(int direction) {
        switch (direction) {
            //up and right
            case 1 -> {
                filled[1][3] = true;
            }
            //up and left
            case 2 -> {
                filled[1][1] = true;
            }
            //down and right
            case 3 -> {
                filled[3][3] = true;
            }
            //down and left
            case 4 -> {
                filled[3][1] = true;
            }
        }
    }
}
