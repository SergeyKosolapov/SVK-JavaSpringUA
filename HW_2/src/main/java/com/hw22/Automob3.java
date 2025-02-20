package com.hw22;

public class Automob3 {
    private Movement movement;
    private String nameAuto;
//        public String wheelDrive;
//    public String transm;

    public Automob3(Movement movement, String nameAuto) {

        this.movement = movement;
        this.nameAuto = nameAuto;
    }

    public void movingOnRoad() {
        System.out.println(this.nameAuto + " Motion" + movement.getTarget());
    }
}
