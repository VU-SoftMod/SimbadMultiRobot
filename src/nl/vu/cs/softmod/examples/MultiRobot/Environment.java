package nl.vu.cs.softmod.examples.MultiRobot;

import java.awt.Color;

/**
 * 
 * An example environment
 * 
 * @author gkarlos
 */

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

import simbad.sim.Box;
import simbad.sim.EnvironmentDescription;
import simbad.sim.Wall;

public class Environment extends EnvironmentDescription {
    
    public static final int WORLD_SIZE =  20;
    
    public Environment() {
        light1IsOn = true;
        light2IsOn = false;
        this.setUsePhysics(true);
        this.setWorldSize(WORLD_SIZE);
        this.initializeComponents();
    }
    
    
    /** 
     * Translate coords 
     */
    public Vector3d coords(int x, int y) {
        return new Vector3d(-y, 0, -x);
    }
    
    
    /**
     * Add environment objects here
     */
    
    private void initializeComponents() {
        
        /** Add 4 walls */
        Wall topWall = new Wall(new Vector3d(-10, 0, 0), WORLD_SIZE, 1, this);
        topWall.setColor(new Color3f(Color.BLACK));
        topWall.rotate90(1);
        add(topWall);
        
        Wall bottomWall = new Wall(new Vector3d(10, 0, 0), WORLD_SIZE, 1, this);
        bottomWall.setColor(new Color3f(Color.YELLOW));
        bottomWall.rotate90(1);
        add(bottomWall);
        
        Wall leftWall = new Wall(new Vector3d(0, 0, 10), WORLD_SIZE, 1, this);
        leftWall.setColor(new Color3f(Color.GRAY));
        add(leftWall);
        
        Wall rightWall = new Wall(new Vector3d(0, 0, -10), WORLD_SIZE, 1, this);
        rightWall.setColor(new Color3f(Color.MAGENTA));
        add(rightWall);
        
        
        /** Add 4 boxes around the center point */
        Box box1 = new Box(coords(1, 1), new Vector3f(1, 1, 1), this);
        box1.setColor(new Color3f(Color.BLACK));
        add(box1);
        
        Box box2 = new Box(coords(1, -1), new Vector3f(1, 1, 1), this);
        box2.setColor(new Color3f(Color.ORANGE));
        add(box2);
        
        Box box3 = new Box(coords(-1, -1), new Vector3f(1, 1, 1), this);
        box3.setColor(new Color3f(Color.BLACK));
        add(box3);
        
        Box box4 = new Box(coords(-1, 1), new Vector3f(1, 1, 1), this);
        box4.setColor(new Color3f(Color.ORANGE));
        add(box4);
    }
}
