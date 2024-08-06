public class SmallT extends Shape {
    public SmallT(int direction) {
        switch (direction) {
            //forward
            case 1 -> {
                filled[1][2] = true;
                filled[3][2] = true;
                filled[2][3] = true;
            }
            //backward
            case 2 -> {
                filled[1][2] = true;
                filled[3][2] = true;
                filled[2][1] = true;
            }
            //up
            case 3 -> {
                filled[1][2] = true;
                filled[2][1] = true;
                filled[2][3] = true;
            }
            //down
            case 4 -> {
                filled[2][1] = true;
                filled[2][3] = true;
                filled[3][2] = true;
            }
        }
    }
}
