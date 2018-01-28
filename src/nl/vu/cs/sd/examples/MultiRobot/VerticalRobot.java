package nl.vu.cs.sd.examples.MultiRobot;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;

/**
 *
 * This is a robot that moves towards a wall and then back,
 * on the vertical axis
 *
 * @author gkarlos
 *
 */
public class VerticalRobot extends StraightLineRobot {

    /** Give small offset to not hit the wall */
    private int maxDistance = Environment.WORLD_SIZE / 2 - 1;

    public VerticalRobot(Vector3d initialPosition, String name, int initialDirection) {
        super(initialPosition, name, initialDirection);

        if(initialDirection != Direction.NORTH && initialDirection != Direction.SOUTH)
            throw new IllegalArgumentException("Vertical Robot can only move North or South");
    }

    private boolean shouldGoBack() {
        Point3d loc = location();

        if(initialDirection() == Direction.SOUTH)
            return (direction() == Direction.SOUTH && loc.getX() >= maxDistance)
                    || (direction() == Direction.NORTH && loc.getX() <= initialPosition().getX());
        // initial direction north
        return (direction() == Direction.NORTH && loc.getX() <= -maxDistance)
                || (direction() == Direction.SOUTH && loc.getX() >= initialPosition().getX());
    }


    @Override
    public void performBehavior() {

        if(shouldGoBack()){
            reverse();
            printInfo();
        }

        drive();
    }
}
