package h03;

import fopbot.Robot;
import fopbot.Direction;

/**
 * The TwinRobots class contains constructors and methods
 */

public class TwinRobots {

   private RobotWithOffspring[] robots;

    /**
     * The constructor TwinRobots contains two parameters and assigns an array of size 2 to the attribute robots.
     * In this case RobotsWithOffspring is in index 1 and RobotsWithOffspring is in index 2.
     */

   public TwinRobots(int numberOfColumnsOfWorld, int numberOfRowsOfWorld) {
       robots = new RobotWithOffspring[2];
       robots[0] = new RobotWithOffspring(numberOfColumnsOfWorld, numberOfRowsOfWorld, Direction.RIGHT, 0);
       robots[1] = new RobotWithOffspring2(numberOfColumnsOfWorld, numberOfRowsOfWorld, Direction.UP, 0);
       robots[0].initOffspring(Direction.LEFT, 0);
       robots[1].initOffspring(Direction.LEFT, 0);
   }

    /**
     * This method uses its updated parameter i to return the robot.
     * This robot is stored at the corresponding robots array.
     * @param i is the updated parameter of the method.
     * @return is used to return the robot.
     */

   public RobotWithOffspring getRobotByIndex(int i) {
       return robots[i];
   }

    /**
     * This method invokes the addToDirectionOfOffspring method on both RobotWithOffspring objects in the robots array with their current parameter value.
     * @param j is the current parameter value of the method.
     */

   public void addToDirectionOfBothOffsprings(int j) {
       robots[0].addToDirectionOfOffspring(j);
       robots[1].addToDirectionOfOffspring(j);
   }

}
