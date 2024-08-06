public class BigT extends Shape {
    public BigT(int direction) {
        switch (direction) {
            //up
            case 1 -> {
                filled[0][2] = true;
                filled[1][2] = true;
                filled[2][1] = true;
                filled[2][3] = true;
            }
            //down
            case 2 -> {
                filled[2][1] = true;
                filled[2][3] = true;
                filled[3][2] = true;
                filled[4][2] = true;
            }
            //left
            case 3 -> {
                filled[1][2] = true;
                filled[3][2] = true;
                filled[2][0] = true;
                filled[2][1] = true;
            }
            //right
            case 4 -> {
                filled[1][2] = true;
                filled[3][2] = true;
                filled[2][3] = true;
                filled[2][4] = true;
            }
        }
    }
}
