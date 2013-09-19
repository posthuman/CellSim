package cellsim;

public class Output {

    public void printGrid(Grid grid) {
        for (int i : grid.getCell()) {
            if (i == 0) {
                System.out.print(" ");
            } else {
                System.out.print("o");
            }
        }
        System.out.println("");
    }
}
