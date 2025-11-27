package sim;
/*
 *  @author Christian Siegrist
 *  Simple Elevator Simulator
 *  Person class
 *  @version 1.0
 * 
 */

/**
 * person class to store current floor and destination floor
 *
 * @param startFloor start floor of the person
 * @param destinationFloor destination floor of the person
 */
public class Person {
    private int startFloor;
    private int destinationFloor;

    public Person(int start, int dest) {
        this.startFloor = start;
        this.destinationFloor = dest;
    }

    public int getStartFloor() {
        return startFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }
}
