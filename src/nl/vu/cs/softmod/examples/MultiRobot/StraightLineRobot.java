package nl.vu.cs.softmod.examples.MultiRobot;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;

import simbad.sim.Agent;

/**
 *  This robot drives in a straight line back and forth,
 *  given an initial direction.
 *  
 *  Initially all robots face south. 
 *  Give an initial direction for the robot to face
 *  
 *  
 *  
 *  @author gkarlos
 *  
 */

public class StraightLineRobot extends Agent{
    
    public static final int SPEED = 1;
    
    private final Vector3d initialPosition;
    private final int initialDirection;
    
    public int direction;
    public int velocity;

    public StraightLineRobot(Vector3d initialPosition, String name, int initialDirection) {
        super(initialPosition, name);
        this.initialPosition = initialPosition;
        this.initialDirection = initialDirection;
        this.direction = initialDirection;
        this.velocity = SPEED;
    }
    
    /** You can alter the robot's state only after
     *  the simulation has started.
     *  
     *  To make sure each robot is initialized properly,
     *  we disable the initBehavior for subclasses
     *  
     *  Alternative: make the method non-final and call
     *               super.initBehavior() first inside the
     *               initBehavior() of all subclasses
     ***/
    public final void initBehavior() {
        switch(initialDirection) {
            case Direction.WEST: rotateY(-(Math.PI / 2)); break;
            case Direction.EAST: rotateY(Math.PI / 2); break;
            case Direction.NORTH: rotateY(-Math.PI); break;
            case Direction.SOUTH: break;
            case Direction.NORTH_WEST: rotateY(- (Math.PI / 4) * 3); break;
            case Direction.NORTH_EAST: rotateY( Math.PI / 4 * 3); break;
            case Direction.SOUTH_WEST: rotateY(- (Math.PI / 4) ); break;
            case Direction.SOUTH_EAST: rotateY( Math.PI/4  ); break;
            default: break;
        }   
    }
    
    /** Returns the initial direction */
    public int initialDirection() {
        return this.initialDirection;
    }
    
    /** Return the initialPosition */
    public Vector3d initialPosition() {
        return this.initialPosition;
    }
    
    /** Returns the robots current direction */
    public int direction() {
        return this.direction;
    }
    
    /** Change the robots direction to the opposite of its current direction */
    public void reverse() {
        this.direction = -direction;
        this.velocity = -velocity;
    }
    
    /** Move the robot straight towards its current direction */
    public void drive() {
        this.setTranslationalVelocity(velocity);
    }
    
    /** Return the current location of the robot */
    public Point3d location(){
        Point3d loc = new Point3d();
        this.getCoords(loc);
        return loc;
    }
    
    /** Print out where the robot driving */
    public void printInfo() {
        System.out.println(this.getName() + (direction() == initialDirection()? " going straight" :" going back"));
    }
}
