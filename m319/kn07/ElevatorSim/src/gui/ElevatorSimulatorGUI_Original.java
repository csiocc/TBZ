package gui;

import sim.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ElevatorSimulatorGUI_Original extends JFrame {
    private ElevatorController controller;
    private BuildingPanel buildingPanel;
    private Timer simulationTimer;
    private boolean running = false;

    public ElevatorSimulatorGUI_Original(ElevatorController controller) {
        this.controller = controller;
        setTitle("Elevator Simulation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Building Panel
        buildingPanel = new BuildingPanel(controller);
        add(buildingPanel, BorderLayout.CENTER);

        // Control Panel
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton addPersonBtn = new JButton("Add Person");
        JButton startBtn = new JButton("Start Simulation");
        JButton stopBtn = new JButton("Stop Simulation");
        JButton stepBtn = new JButton("Step");

        controlPanel.add(addPersonBtn);
        controlPanel.add(startBtn);
        controlPanel.add(stopBtn);
        controlPanel.add(stepBtn);

        add(controlPanel, BorderLayout.SOUTH);

        // Button Actions
        Random rand = new Random();

        addPersonBtn.addActionListener(e -> {
            int start = rand.nextInt(controller.getFloors().size());
            int dest;
            do {
                dest = rand.nextInt(controller.getFloors().size());
            } while (dest == start);
            Person p = new Person(start, dest);
            controller.getFloors().get(start).getWaitingPeople().add(p);
            controller.getElevator().addRequest(start);
            buildingPanel.repaint();
        });

        startBtn.addActionListener(e -> {
            if (!running) {
                running = true;
                simulationTimer.start();
            }
        });

        stopBtn.addActionListener(e -> {
            running = false;
            simulationTimer.stop();
        });

        stepBtn.addActionListener(e -> {
            controller.move();
            buildingPanel.repaint();
        });

        // Simulation Timer
        simulationTimer = new Timer(50, e -> {
            controller.move();
            buildingPanel.repaint();
        });

        setSize(500, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Drawing panel for building & elevator
    static class BuildingPanel extends JPanel {
        private ElevatorController controller;
        private int floorHeight = 80;
        private int elevatorWidth = 60;
        private int elevatorHeight = 60;

        public BuildingPanel(ElevatorController controller) {
            this.controller = controller;
            setBackground(new Color(240, 240, 255));
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
                int y = panelHeight - (i + 1) * floorHeight;
                g2d.setColor(Color.GRAY);
                g2d.drawLine(50, y, getWidth() - 50, y);
                g2d.setColor(Color.BLACK);
                g2d.drawString("Floor " + i, 10, y - 5);

                // draw waiting people
                int offset = 0;
                for (Person p : controller.getFloors().get(i).getWaitingPeople()) {
                    g2d.setColor(Color.BLUE);
                    g2d.fillOval(60 + offset, y - 15, 15, 15); // small circle as person
                    offset += 20;
                }
            }

            // draw elevator
            int currentFloor = controller.getElevator().getCurrentFloor();
            int elevatorY = panelHeight - (currentFloor + 1) * floorHeight + 10;

            g2d.setColor(new Color(180, 60, 60));
            g2d.fillRoundRect(getWidth() / 2 - elevatorWidth / 2, elevatorY, elevatorWidth, elevatorHeight, 10, 10);

            g2d.setColor(Color.WHITE);
            g2d.drawString("P: " + controller.getElevator().getPassengers().size(),
                    getWidth() / 2 - 15, elevatorY + elevatorHeight / 2);
        }
    }

    // Main to launch
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ElevatorController controller = new ElevatorController(6); // z.B. 6 Stockwerke
            new ElevatorSimulatorGUI_Original(controller);
        });
    }
}
