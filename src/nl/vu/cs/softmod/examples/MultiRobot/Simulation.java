package nl.vu.cs.softmod.examples.MultiRobot;

import java.util.ArrayList;
import simbad.gui.Simbad;
import simbad.sim.Agent;
import simbad.sim.EnvironmentDescription;

/**
 * This is our Main program
 * 
 * @author gkarlos
 *
 */
public class Simulation {
    
    public void start() {
        Environment env = new Environment();
        
        ArrayList<Agent> swarm = new ArrayList<Agent>();
        
        swarm.add(new HorizontalRobot(env.coords(-1,0), "Horizontal Robot Left", Direction.WEST));
        swarm.add(new HorizontalRobot(env.coords(1,0), "Horizontal Robot Right", Direction.EAST));
        swarm.add(new VerticalRobot(env.coords(0, -1), "Vertical Robot Down", Direction.SOUTH));
        swarm.add(new VerticalRobot(env.coords(0, 1), "Vertical Robot Up", Direction.NORTH));
        swarm.add(new DiagonalRobot(env.coords(-2, 2), "Diagonal Robot NW", Direction.NORTH_WEST));
        swarm.add(new DiagonalRobot(env.coords(-2, -2), "Diagonal Robot SW", Direction.SOUTH_WEST));
        swarm.add(new DiagonalRobot(env.coords(2, -2), "Diagonal Robot SE", Direction.SOUTH_EAST));
        swarm.add(new DiagonalRobot(env.coords(2, 2), "Diagonal Robot NE", Direction.NORTH_EAST));
        
        
        /** Add the swarm to the world */
        for(Agent robot: swarm)
            env.add(robot);
        
        /** The Simbad constructor also starts the simulation 
         * 
         * NOTE: Don't directly reference the Simbad instance 
         *       and/or play with it's methods, unless you have 
         *       knowledge of Java Swing.
         * */
        new Simbad(env, false);
    }
    
    
    public static void main(String[] args) {
        new Simulation().start();
    }
}
