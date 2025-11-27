package sim;

/*
 *  @author Christian Siegrist
 *  Simple Elevator Simulator
 *  ElevatorController class
 *  @version 1.0
 */
import java.util.*;


/** 
 * elevator controller to controll the elevators behavior stores Floors and the Elevator
 *
 * @param floors list of floors in the building
 * @param elevator the elevator in the building
 */

public class ElevatorController {
    private List<Floor> floors = new ArrayList<>();
    private Elevator elevator = new Elevator();

    // creates new floors until i = floorCount
    public ElevatorController(int floorCount) {
        for (int i = 0; i < floorCount; i++) {
            floors.add(new Floor(i));
        }
    }
    // to access the elevator from outside
    public Elevator getElevator() {
        return elevator;
    }
    // to access the floors from outside
    public List<Floor> getFloors() {
        return floors;
    }
    // to move the elevator called from GUI dpStep
    public void move() {
        elevator.move(floors);
    }
    // to add a person to the elevator and add the requests(destinationfloor) to the elevator
    public void addPerson(Person p) {
        floors.get(p.getStartFloor()).addPerson(p);
        elevator.addRequest(p.getStartFloor());
        elevator.addRequest(p.getDestinationFloor());
    }
}
