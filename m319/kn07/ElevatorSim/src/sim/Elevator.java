package sim;

/*
 *  @author Christian Siegrist
 *  Simple Elevator Simulator
 *  Elevator class
 *  @version 1.0
 */
import java.util.*;  // for random access and lists

/** 
 * elevator class stores current floor, direction, capacity, passengers and requests
 *
 * @param currentFloor current floor
 * @param direction direcion in wich the elevator moves 1 up -1 down
 * @param capacity how much People the elevator can move together
 * @param passengers list of persons in the elevator
 * @param requests queue of floor requests
 */
public class Elevator {
  private int currentFloor = 0; // current Floor
  private int direction = 1; // 1 up -1 down
  private int capacity = 5; // how much People the Elevator can move together
  private List<Person> passengers = new ArrayList<>();
  private Queue<Integer> requests = new LinkedList<>();

  // to acccess current floor from outside
  public int getCurrentFloor() {
    return currentFloor;
  }

  // to access passengers from outside
  public List<Person> getPassengers() {
    return passengers;
  }
  
  // to add a request from outside called from Elevator.move() to add destination 
  // and from GUI addPersonBtn.addActionListener to add start floor
  public void addRequest(int floor) {
    if (!requests.contains(floor)) {
      requests.add(floor);
    }
  }

  /*
   * removes passengers whose destination floor is the current floor
   * and returns them as a list of exited passengers
   * called from GUI doStep
   */
  public List<Person> unloadPassengers() { 
    List<Person> exited = new ArrayList<>();
    passengers.removeIf(p -> {                            // removes passengers if condition true
      if (p.getDestinationFloor() == currentFloor) {      // if destination floor is current floor -> true
        exited.add(p);                                    // adds passenger to exited list
        return true;
      }
      return false;                                                       
    });
    return exited;                                        // @return list of exited passengers
  }
  

  /*
   * method to move the elevator called from ElevatorController move().
   *
   * @param floor list.
   * @return returns if elevator is empty and has no targets.
   */
  public void move(List<Floor> floors) {
    passengers.removeIf(p -> p.getDestinationFloor() == currentFloor);

    // load passengers if there is space in the elevator
    Floor floor = floors.get(currentFloor);
    while(!floor.getWaitingPeople().isEmpty() && passengers.size() < capacity) {
        Person next = floor.getWaitingPeople().poll(); // poll instead of remove to get 0 returned if 0  waiting instead of error
        passengers.add(next);
        addRequest(next.getDestinationFloor()); //adds persons destination floor to requests queue
    }

    /*handling requests
     * if requests is not empty and next request is current floor delete next request
     * if requests are empty and passengers empty return 
     */
    
    if (!requests.isEmpty() && requests.peek() == currentFloor) {
        requests.poll();
    }
    if (requests.isEmpty() && passengers.isEmpty()) {
      return;
    }

    /* move
    moves upwards until last floor then changes direction downwards
    moves downwards until floor 0 then changes direction upwards
    */
    currentFloor += direction;
    if (currentFloor >= floors.size()) {
      currentFloor = floors.size() - 1;
      direction = -1;
    }
    if (currentFloor < 0) {
      currentFloor = 0;
      direction = 1;
    }
  }
}

