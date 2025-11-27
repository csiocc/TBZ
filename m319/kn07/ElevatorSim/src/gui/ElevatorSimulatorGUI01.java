package gui;


/*
 *  @author Chat GPT
 * Simple Elevator Simulator GUI with Swing
 *  @version 1.0
 * 
 */
import sim.*;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.List;

public class ElevatorSimulatorGUI01 extends JFrame {
    private ElevatorController controller;
    private BuildingPanel buildingPanel;
    private Timer simulationTimer;
    private boolean running = false;
    private int stepCounter = 0; // zählt Ticks für langsame Bewegung

    public ElevatorSimulatorGUI01(ElevatorController controller) {
        this.controller = controller;
        setTitle("Elevator Simulation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Building Panel
        buildingPanel = new BuildingPanel(controller);
        add(buildingPanel, BorderLayout.CENTER);

        // Control Panel
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton addPersonBtn = new JButton("Add Person");
        JButton startBtn = new JButton("Start Simulation");
        JButton stopBtn = new JButton("Stop Simulation");


        controlPanel.add(addPersonBtn);
        controlPanel.add(startBtn);
        controlPanel.add(stopBtn);
        add(controlPanel, BorderLayout.SOUTH);

        // Button Actions
        Random rand = new Random();

        // button to add a random person
        addPersonBtn.addActionListener(e -> {
            int start = rand.nextInt(controller.getFloors().size());        // random start floor
            int dest;                                                       // destination floor                                      
            do {
                dest = rand.nextInt(controller.getFloors().size());
            } while (dest == start);                                    

            Person p = new Person(start, dest);                             // create new person and ensure destination is different from start
            controller.getFloors().get(start).getWaitingPeople().add(p);    // add person to start floor
            controller.getElevator().addRequest(start);                     // add start floor to requests

            // only for visualization update
            buildingPanel.repaint();
        });

        // button to start the simulation if not already running
        startBtn.addActionListener(e -> {
            if (!running) {
                running = true;
                stepCounter = 0; // zurücksetzen
                simulationTimer.start();
            }
        });
        // button to stop the simulation
        stopBtn.addActionListener(e -> {
            running = false;
            simulationTimer.stop();
            buildingPanel.clearExitedPeople();  // clear exited people visualization
        });

        // @deprecated stepBtn.addActionListener(e -> doStep(true));

        // simulation timer -> tick every 100ms
        simulationTimer = new Timer(100, e -> doStep(false));

        setSize(600, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }

    /**
     * Simulationstep
     * @param forceMove if true -> move elevator directly without delay for step button
     */
    private void doStep(boolean forceMove) {
        stepCounter++;
        if (forceMove || stepCounter >= 10) { // 10 ticks = 1 Second do move if forceMove is true or 1 second passed
            // exited passengers handle
            List<Person> exited = controller.getElevator().unloadPassengers();
            for (Person p : exited) {  // inform GUI about exited passengers adds all exited persons into personExited list for visualization
                buildingPanel.personExited(p);
            }

            controller.move();          // move elevator logic
            buildingPanel.repaint();    // update building panel
            stepCounter = 0;            // reset counter
        } else {
            buildingPanel.repaint();    // update building panel
        }
    }

    // Panel for the building visualization
    static class BuildingPanel extends JPanel {
        private ElevatorController controller;
        private int floorHeight = 80;
        private int elevatorWidth = 60;
        private int elevatorHeight = 60;
        private double elevatorY; // animated y position

        private java.util.List<Person> exitedPeople = new java.util.ArrayList<>();

        public BuildingPanel(ElevatorController controller) {
            this.controller = controller;
            setBackground(new Color(240, 240, 255));
            int startFloor = controller.getElevator().getCurrentFloor();
            elevatorY = getHeight() - (startFloor + 1) * floorHeight + 10;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int floorsCount = controller.getFloors().size();
            int panelHeight = getHeight();

            // draw floors
            for (int i = 0; i < floorsCount; i++) {
                int floorY = panelHeight - (i + 1) * floorHeight;
                int midY = floorY + floorHeight / 2; // middle of the floor

                g2d.setColor(Color.GRAY);
                g2d.drawLine(50, floorY, getWidth() - 50, floorY);
                g2d.setColor(Color.BLACK);
                g2d.drawString("Floor " + i, 10, floorY - 5);

                // waiting people (left, blue) 
                int offsetL = 0;
                for (Person p : controller.getFloors().get(i).getWaitingPeople()) {
                    drawStickFigure(g2d, 80 + offsetL, midY, p.getDestinationFloor(), Color.BLUE);
                    offsetL += 40;
                }

                // exited people (right, green)
                int offsetR = 0;
                for (Person p : exitedPeople) {
                    if (p.getDestinationFloor() == i) {
                        drawStickFigure(g2d, getWidth() - 120 - offsetR, midY, p.getDestinationFloor(), Color.GREEN);
                        offsetR += 40;
                    }
                }
            }

            // determine target elevator position
            int targetFloor = controller.getElevator().getCurrentFloor();
            int targetY = panelHeight - (targetFloor + 1) * floorHeight + 10;

            // smooth elevator movement
            if (Math.abs(elevatorY - targetY) > 1) {
                elevatorY += (targetY - elevatorY) * 0.1;
            } else {
                elevatorY = targetY;
            }

            // draw elevator
            g2d.setColor(new Color(180, 60, 60));
            g2d.fillRoundRect(getWidth() / 2 - elevatorWidth / 2,
                              (int) elevatorY,
                              elevatorWidth, elevatorHeight, 10, 10);

            g2d.setColor(Color.WHITE);
            g2d.drawString("P: " + controller.getElevator().getPassengers().size(),
                           getWidth() / 2 - 15, (int) elevatorY + elevatorHeight / 2);
        }

        private void drawStickFigure(Graphics2D g2d, int x, int y, int destination, Color color) {
            g2d.setColor(color);

            // head
            g2d.drawOval(x, y - 20, 15, 15);
            // body
            g2d.drawLine(x + 7, y - 5, x + 7, y + 15);
            // arms
            g2d.drawLine(x - 5, y + 5, x + 20, y + 5);
            // legs
            g2d.drawLine(x + 7, y + 15, x, y + 30);
            g2d.drawLine(x + 7, y + 15, x + 14, y + 30);

            // destination over head
            g2d.setFont(new Font("Arial", Font.PLAIN, 10));
            g2d.drawString("→ " + destination, x, y - 25);
        }

        public void personExited(Person p) {
            exitedPeople.add(p);
            repaint();
        }

        public void clearExitedPeople() {
            exitedPeople.clear();
            repaint();
        }
    }

    // Einstiegspunkt
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ElevatorController controller = new ElevatorController(6); // z.B. 6 Stockwerke
            new ElevatorSimulatorGUI01(controller);
        });
    }
}
