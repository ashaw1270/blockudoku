public class ThreeDiagonal extends Shape {
    public ThreeDiagonal(int direction) {
        switch (direction) {
            //forward
            case 1, 2 -> {
                filled[1][3] = true;
                filled[3][1] = true;
            }
            //backward
            case 3, 4 -> {
                filled[1][1] = true;
                filled[3][3] = true;
            }
        }
    }
}
