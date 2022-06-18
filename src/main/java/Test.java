import adapters.SquarePegAdapter;
import round.RoundHole;
import round.RoundPeg;
import square.SquarePeg;


public class Test {
    public static void main(String[] args) {
        int radHole = 5;
        int radPeg = 5;

        // round fits round
        RoundHole hole = new RoundHole(radHole);
        RoundPeg rpeg = new RoundPeg(radPeg);
        if (hole.fits(rpeg)) {
            System.out.println("Round peg radius 5 fits round hole radius 5.");
        }


        int widthSmall = 2;
        int widthLarge = 20;

        SquarePeg smallSqPeg = new SquarePeg(widthSmall);
        SquarePeg largeSqPeg = new SquarePeg(widthLarge);
        // hole.fits(smallSqPeg); // Won't compile → square is not round

        // Adapter can solve the problem
        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
        if (hole.fits(smallSqPegAdapter)) {
            System.out.println("Square peg with width " + widthSmall + " fits round hole with radius " + radHole);
        }
        if (!hole.fits(largeSqPegAdapter)) {
            System.out.println("Square peg with width " + widthLarge+ " does not fit round hole with radius " + radHole);
        }
    }
}