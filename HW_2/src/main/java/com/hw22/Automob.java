package com.hw22;

public class Automob {
    private Movement movement;
//    public String nameAuto;
//        public String wheelDrive;
//    public String transm;

    public Automob(Movement movement) {
        this.movement = movement;
    }

    public void movingOnRoad() {
        System.out.println("Moving" + movement.getTarget());
    }
}
