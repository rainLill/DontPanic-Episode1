import java.util.*;
import java.io.*;
import java.math.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        GameData gd = new GameData();
        int nbFloors = in.nextInt(); // number of floors
        int width = in.nextInt(); // width of the area
        int nbRounds = in.nextInt(); // maximum number of rounds
        int exitFloor = in.nextInt(); // floor on which the exit is found
        int exitPos = in.nextInt(); // position of the exit on its floor
        int nbTotalClones = in.nextInt(); // number of generated clones
        int nbAdditionalElevators = in.nextInt(); // ignore (always zero)
        int nbElevators = in.nextInt(); // number of elevators
        for (int i = 0; i < nbElevators; i++) {
            int elevatorFloor = in.nextInt(); // floor on which this elevator is found
            int elevatorPos = in.nextInt(); // position of the elevator on its floor
        }

        // game loop
        while (true) {
            int cloneFloor = in.nextInt(); // floor of the leading clone
            int clonePos = in.nextInt(); // position of the leading clone on its floor
            String direction = in.next(); // direction of the leading clone: LEFT or RIGHT

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println("WAIT"); // action: WAIT or BLOCK
        }
    }

    private static class GameData {
        private int nbFloors;
        private int width;
        private int nbRounds;
        private int exitFloor;
        private int exitPos;
        private int nbTotalClones;
        private int nbAdditionalElevators;
        private int nbElevators;
        private Map<Integer, Integer> floorElevatorPosition = new HashMap<>();

        public int getNbFloors() {
            return nbFloors;
        }

        public void setNbFloors(int nbFloors) {
            this.nbFloors = nbFloors;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getNbRounds() {
            return nbRounds;
        }

        public void setNbRounds(int nbRounds) {
            this.nbRounds = nbRounds;
        }

        public int getExitFloor() {
            return exitFloor;
        }

        public void setExitFloor(int exitFloor) {
            this.exitFloor = exitFloor;
        }

        public int getExitPos() {
            return exitPos;
        }

        public void setExitPos(int exitPos) {
            this.exitPos = exitPos;
        }

        public int getNbTotalClones() {
            return nbTotalClones;
        }

        public void setNbTotalClones(int nbTotalClones) {
            this.nbTotalClones = nbTotalClones;
        }

        public int getNbAdditionalElevators() {
            return nbAdditionalElevators;
        }

        public void setNbAdditionalElevators(int nbAdditionalElevators) {
            this.nbAdditionalElevators = nbAdditionalElevators;
        }

        public int getNbElevators() {
            return nbElevators;
        }

        public void setNbElevators(int nbElevators) {
            this.nbElevators = nbElevators;
        }

        public Map<Integer, Integer> getFloorElevatorPosition() {
            return floorElevatorPosition;
        }

        public void setFloorElevatorPosition(Map<Integer, Integer> floorElevatorPosition) {
            this.floorElevatorPosition = floorElevatorPosition;
        }
    }
}