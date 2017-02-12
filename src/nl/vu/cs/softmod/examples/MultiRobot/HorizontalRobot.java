package nl.vu.cs.softmod.examples.MultiRobot;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;

/**
 * 
 * This is a robot that moves towards a wall and then back,
 * on the horizontal axis
 * 
 * 
 * @author gkarlos
 *
 */
public class HorizontalRobot extends StraightLineRobot {
    
    /** Give small offset to not hit the wall */
    private int maxDistance = Environment.WORLD_SIZE / 2 - 1;
    
    public HorizontalRobot(Vector3d position, String name, int initialDirection) {
        super(position, name, initialDirection);
        
        if(initialDirection != Direction.EAST && initialDirection != Direction.WEST)
            throw new IllegalArgumentException("Horizontal Robot can only move East or West");
    }
    
    private boolean shouldGoBack() {
        Point3d loc = location();
        if (initialDirection() == Direction.EAST)
            return (direction() == Direction.EAST && loc.getZ() <= -maxDistance) 
                    || (direction() == Direction.WEST && loc.getZ() >= initialPosition().getZ());
        // initial direction east
        return (direction() == Direction.WEST && loc.getZ() >= maxDistance)
                    || (direction() == Direction.EAST && loc.getZ() <= initialPosition().getZ());
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
