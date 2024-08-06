public class BigL extends Shape {
    public BigL(int direction) {
        switch (direction) {
            //up and left
            case 1 -> {
                filled[0][2] = true;
                filled[1][2] = true;
                filled[2][0] = true;
                filled[2][1] = true;
            }
            //up and right
            case 2 -> {
                filled[0][2] = true;
                filled[1][2] = true;
                filled[2][3] = true;
                filled[2][4] = true;
            }
            //down and left
            case 3 -> {
                filled[2][0] = true;
                filled[2][1] = true;
                filled[3][2] = true;
                filled[4][2] = true;
            }
            //down and right
            case 4 -> {
                filled[2][3] = true;
                filled[2][4] = true;
                filled[3][2] = true;
                filled[4][2] = true;
            }
        }
    }
}
