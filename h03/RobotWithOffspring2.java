package h03;

import fopbot.Direction;
import fopbot.Robot;


/**
 * The RobotWithOffspring2 class extends the RobotWithOffspring class.
 * RobotWithOffspring2 overwrites values of RobotWithOffspring.
 */


public class RobotWithOffspring2 extends RobotWithOffspring {

    private int directionAccu;

    /**
     * The method RobotWithOffSpring2 inserts the values of the parameters into the constructor of Robot.
     *
     * @param numberOfColumnsOfWorld specifies the number of columns in the world.
     * @param numberOfRowsOfWorld specifies the number of rows of the world.
     * @param direction specifies the direction in which the robot looks.
     * @param numberOfCoins specifies the number of coins of the robot.
     */

    public RobotWithOffspring2 (int numberOfColumnsOfWorld, int numberOfRowsOfWorld, Direction direction, int numberOfCoins){
        super (numberOfColumnsOfWorld, numberOfRowsOfWorld, direction, numberOfCoins);
    }

    /**
     * The initOffspring method is used to transfer the values of initOffspring of RobotWithOffspring with their current parameters to RobotWithOffspring2.
     * This is followed by the initialization of directionAccu according to the current value of the direction parameter.
     * @param direction determines the robot's viewing direction.
     * @param numberOfCoins determines the number of coins of the robot.
     */

    public void initOffspring (Direction direction, int numberOfCoins) {
        super.initOffspring(direction, numberOfCoins);
        directionAccu = direction.ordinal();
    }


    private Direction getDirectionFromAccu() {

        int Dir;
        if(directionAccu >= 0) {
            Dir = directionAccu % 4;
        } else {
            Dir = (4-((-directionAccu)%4)) %4;
        }

        return Direction.values()[Dir];
    }

    /**
     * The getDirectionOfOffspring method is used to overwrite the values on RobotWithOffspring2 with the invocation of getDirectionFromAccu.
     * @return gets back the invocation itself.
     */

    public Direction getDirectionOfOffspring() {
        return getDirectionFromAccu();
    }

    /**
     * This method is used to override the addToDirectionOfOffspring method of RobotWithOffspring.
     * First it is checked if offspring was initialized at least once.
     * The updated parameter value is added to directionAccu if this case occurs.
     * To ensure that the direction of offspring and directionAccu remains consistent, a new direction is calculated with getDirectionFromAccu and offspring is set to exactly this new direction.
     *
     * @param addDir is the parameter that is added to directionAccu with its updated value.
     */

    public void addToDirectionOfOffspring(int addDir) {

        if(offspringIsInitialized()){
            directionAccu += addDir;
            Direction updated = getDirectionFromAccu();
            while (updated != offspring.getDirection()) {
                offspring.turnLeft();
            }
        }
    }
}
