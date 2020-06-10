//https://www.codingame.com/ide/puzzle/don't-panic-episode-1

import java.util.*;

class Player {

    public static void main(String args[]) {
        GameData gd = new GameData();
        Scanner in = new Scanner(System.in);

        /*
        Game inputs changed:
        Original inputs where
        int exitFloor = in.nextInt();
        int exitPos = in.nextInt();
        I saved exit floor and exitPos to general floors register
         */
        gd.setNbFloors(in.nextInt() - 1); // number of floors
        gd.setWidth(in.nextInt());  // width of the area
        gd.setNbRounds(in.nextInt()); // maximum number of rounds
        gd.setElevatorLocations(in.nextInt(), in.nextInt());
        gd.setNbTotalClones(in.nextInt()); // number of generated clones
        gd.setNbAdditionalElevators(in.nextInt()); // ignore (always zero)
        gd.setNbElevators(in.nextInt()); // number of elevators


        /*
        first console input - floor on which this elevator is found
        second console input - position of the elevator on its floor
         */
        for (int i = 0; i < gd.getNbElevators(); i++) {
            gd.setElevatorLocations(in.nextInt(), in.nextInt());
        }


        while (true) { // game loop
            int cloneFloor = in.nextInt(); // floor of the leading clone
            int clonePos = in.nextInt(); // position of the leading clone on its floor
            String direction = in.next(); // direction of the leading clone: LEFT or RIGHT

            String output = !direction.equals("NONE") ? gd.exitAction(clonePos, cloneFloor, direction) : "WAIT";

            System.out.println(output); // action: WAIT or BLOCK
        }
    }

    private static class GameData {
        private int nbFloors; // number of floors
        private int width; // width of the area
        private int nbRounds; // maximum number of rounds
        private int exitFloor; // floor on which the exit is found
        private int exitPos; // position of the exit on its floor
        private int nbTotalClones; // number of generated clones
        private int nbAdditionalElevators; // ignore (always zero)
        private int nbElevators; // number of elevators

        private Map<Integer, Integer> elevatorLocations = new HashMap<>();

        /*
        elevatorDirection = current direction by default , this in situation clonePos == elevatorPos
        if clonePos != elevator pos, then next if else, will determine direction of elevator
        return if elevatorDirection == direction will formalize appropriate output
         */
        public String exitAction(Integer clonePos, Integer cloneFloor, String direction) {
            if (getElevatorLocation(cloneFloor).equals(clonePos)) {
                return "WAIT";
            }

            String elevatorDirection = getElevatorLocation(cloneFloor) > clonePos ? "RIGHT" : "LEFT";

            return elevatorDirection.equals(direction) ? "WAIT" : "BLOCK";
        }

        public Integer getElevatorLocation(Integer floor) {
            return elevatorLocations.get(floor);
        }

        public void setElevatorLocations(Integer floor, Integer elevatorPosition) {
            this.elevatorLocations.put(floor, elevatorPosition);
        }

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
    }
}