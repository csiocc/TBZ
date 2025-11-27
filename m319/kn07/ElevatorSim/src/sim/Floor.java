package sim;

/*
 *  @author Christian Siegrist
 *  Simple Elevator Simulator
 *  Floor class
 *  @version 1.0
 */
import java.util.*;

/** 
 * class for the floor to store floorno and persons waiting on it
 *
 * @param floorNumber number of the floor
 * @param waitingPeople list of people waiting on this floor
 */
public class Floor {
    private int floorNumber;
    private Queue<Person> waitingPeople = new LinkedList<>();
    //store the floor number
    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
    }
    // return the floor number
    public int getFloorNumber() {
        return floorNumber;
    }
    // return the queue of people waiting on this floor
    public Queue<Person> getWaitingPeople() {
        return waitingPeople;
    }
    // add a person to the queue of people waiting on this floor
    public void addPerson(Person p) {
        waitingPeople.add(p);
    }
}
