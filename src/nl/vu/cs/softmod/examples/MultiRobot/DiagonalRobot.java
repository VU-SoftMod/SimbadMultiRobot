package nl.vu.cs.softmod.examples.MultiRobot;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;


/**
 * 
 * This is a robot that moves towards a wall and then back,
 * on a diagonal, based on its initial direction
 * 
 * 
 * @author gkarlos
 *
 */

public class DiagonalRobot extends StraightLineRobot{
    /** 
     *  Max distance is half the diagonal of the square
     *  We don't need it here but it may come handy for you
     **/
    private double maxDistance = Math.sqrt(Math.pow(Environment.WORLD_SIZE, 2) + Math.pow(Environment.WORLD_SIZE, 2)) / 2 - 1;
    
    private double maxX = Environment.WORLD_SIZE / 2 - 1;
    
    public DiagonalRobot(Vector3d initialPosition, String name, int initialDirection) {
        super(initialPosition, name, initialDirection);
        
        if(initialDirection != Direction.NORTH_EAST && initialDirection != Direction.NORTH_WEST
                && initialDirection != Direction.SOUTH_EAST && initialDirection != Direction.SOUTH_WEST)
            throw new IllegalArgumentException("Horizontal Robot can only move NE, NW, SE or SW");
    }
    
    private boolean shouldGoBack() {
        Point3d loc = location();
        boolean goingNorth = direction() == Direction.NORTH_EAST || direction() == Direction.NORTH_WEST;
        boolean goingSouth = direction() == Direction.SOUTH_EAST || direction() == Direction.SOUTH_WEST;
        if(initialDirection() == Direction.NORTH_EAST || initialDirection() == Direction.NORTH_WEST){
            /** Top Diagonals */

            return (goingNorth && loc.getX() <= -maxX) || (goingSouth && loc.getX() >= initialPosition().getX()); 
        }else{
            /** Bottom Diagonals */
            return (goingSouth && loc.getX() >= maxX) || (goingNorth && loc.getX() <= initialPosition().getX());
        }
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
