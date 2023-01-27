package h03;

import fopbot.Direction;
import fopbot.Robot;
import fopbot.World;


/**
 * The RobotWithOffspring class extends the Robot class.
 * RobotWithOffspring overwrites values of Robot.
 */


public class RobotWithOffspring extends Robot {


    private final int numberOfColumnsOfWorld;
    private final int numberOfRowsOfWorld;

    /**
     * The RobotWithOffSpring method inserts the values of the parameters into the constructor of Robot.
     *
     * @param numberOfColumnsOfWorld specifies the number of columns in the world.
     * @param numberOfRowsOfWorld specifies the number of rows of the world.
     * @param direction specifies the direction in which the robot looks.
     * @param numberOfCoins specifies the number of coins of the robot.
     *
     */

    public RobotWithOffspring(int numberOfColumnsOfWorld, int numberOfRowsOfWorld, Direction direction, int numberOfCoins) {

        super(numberOfColumnsOfWorld / 2, numberOfRowsOfWorld / 2, direction, numberOfCoins);

        this.numberOfRowsOfWorld = numberOfRowsOfWorld;

        this.numberOfColumnsOfWorld = numberOfColumnsOfWorld;

    }

    protected Robot offspring;

    /**
     * This method returns no value and sets up a robot with the same coordinates as RobotWithOffSpring.
     * @param direction determines the robot's viewing direction.
     * @param numberOfCoins determines the number of coins of the robot.
     */

    public void initOffspring(Direction direction, int numberOfCoins) {

        offspring = new Robot(super.getX(), super.getY(), direction, numberOfCoins);
    }

    /**
     * This method checks the value x, which has the type int, for the column coordinate from the offspring constructor.
     * @return gives this value
     */

    public int getXOfOffspring() {
        return offspring.getX();
    }

    /**
     * This method checks the value y, which has the type int, for the row coordinate from the offspring constructor.
     * @return gives this value
     */

    public int getYOfOffspring() {
        return offspring.getY();
    }

    /** This method getDirectionOfOffspring checks the enumeration direction, for the direction of the robot from the offspring constructor.
     * @return gives this value
     */

    public Direction getDirectionOfOffspring() {
        return offspring.getDirection();
    }

    /** This method checks the value numberOfCoins, which is of type int, for the number of coins from the offspring constructor.
     * @return gives this value
     */

    public int getNumberOfCoinsOfOffspring() {
        return offspring.getNumberOfCoins();
    }

    /** This method queries the truth value.
     * This means that the truth value is considered true exactly when a robot has been initialized. This then returns as a boolean value.
     * This query is done using an if loop that checks if offspring refers to an object.
     * If the case occurs and offspring does not refer to an object, the boolean value is set to false.
     * @return These boolean values are finally output by return.
     */

    public boolean offspringIsInitialized() {
        boolean initialized;

        initialized = offspring != null;

        return initialized;
    }

    /** This method defines a new int value n.
     * This value results from the current column position of the offspring and the int value of the parameter a, which is added to it.
     * If n is a valid column index within the world, offspring will be positioned with the help of setX in exactly this column or otherwise in the column closest to n.
     * @param a This declared value is an integer value of the columns, which is added to the current position.
     */

    public void addToXOfOffspring(int a) {

        if (offspringIsInitialized()) {
            int n = offspring.getX() + a;
            if (0 <= n && n < numberOfColumnsOfWorld) {
                offspring.setX(n);
            } else if (n < 0) {
                offspring.setX(0);
            } else {
                offspring.setX(numberOfColumnsOfWorld - 1);
            }

        }
    }

    /** This method defines a new int value n.
     * This value results from the current row position of the offspring and the int value of the parameter b, which is added to it.
     * If n is a valid column index within the world, offspring will be positioned with the help of setY in exactly this row or otherwise in the row closest to n.
     * @param b This declared value is an integer value of the rows, which is added to the current position.
     */
    public void addToYOfOffspring(int b) {

        if (offspringIsInitialized()) {
            int n = offspring.getY() + b;
            if (0 <= n && n < numberOfColumnsOfWorld) {
                offspring.setY(n);
            } else if (n < 0) {
                offspring.setY(0);
            } else {
                offspring.setY(numberOfColumnsOfWorld - 1);
            }

        }
    }

    /** This method changes the coin count when offspring is initialized by adding the current int value of the coin count, the current int value of the parameter c and by assigning the variable value n defined at the beginning.
     * But this process happens only if the number of the sum is greater than 0.
     * If not, n is set to 0.
     * @param c is an integer value of the coins to be added to the current coin count.
     */

    public void addToNumberOfCoinsOfOffspring(int c) {

        if (offspringIsInitialized()) {
            int n = offspring.getNumberOfCoins() + c;
            offspring.setNumberOfCoins(Math.max(n, 0));
        }
    }

    /**
     * The method addToDirectionOfOffspring is used to determine the direction of the robot and has a parameter Dir of type int.
     * First it is checked whether offspring was at least initialized once.
     * Then an int value n is determined, which consists of the integer, which offspring has at this moment as direction, and of the parameter Dir, which is added to it.
     * To apply modular arithmetic, an int value k is determined which is congruent to n, in order to capture both positive and negative values of n in the range of direction.
     * If the case occurs and n is a positive number, therefore larger than 0, k is defined as n % 4, in order to get a value within the interval of the direction.
     * If n is a negative number, therefore smaller than 0, k is defined as (4-((-n) % 4) % 4 to get a value within the interval of the direction.
     * To determine the direction, a direction is now defined, which converts a value of offspring back to a direction.
     * The while loop makes offspring rotate to the left until the newly defined direction value matches the current direction value of offspring after addition.
     *
     * @param Dir is the parameter that will have its updated value added to the integer of offspring as direction.
     */

    public void addToDirectionOfOffspring(int Dir) {
        if (offspringIsInitialized()) {

            int n = offspring.getDirection().ordinal() + Dir;
            int k;

            if (n >= 0) {
                k = n % 4;
            } else {
                k = (4 - ((-n) % 4)) % 4;
            }

            Direction direction = Direction.values()[k];

            while (offspring.getDirection() != direction) {
                offspring.turnLeft();
            }
        }
    }


}
