public class ThreeLine extends Shape {
    public ThreeLine(int direction) {
        switch (direction) {
            //vertical
            case 1, 2 -> {
                filled[1][2] = true;
                filled[3][2] = true;
            }
            //horizontal
            case 3, 4 -> {
                filled[2][1] = true;
                filled[2][3] = true;
            }
        }
    }
}
