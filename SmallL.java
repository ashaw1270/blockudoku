public class SmallL extends Shape {
    public SmallL(int direction) {
        switch (direction) {
            //up and left
            case 1 -> {
                filled[1][2] = true;
                filled[2][1] = true;
            }
            //up and right
            case 2 -> {
                filled[1][2] = true;
                filled[2][3] = true;
            }
            //down and left
            case 3 -> {
                filled[2][1] = true;
                filled[3][2] = true;
            }
            //down and right
            case 4 -> {
                filled[2][3] = true;
                filled[3][2] = true;
            }
        }
    }
}
