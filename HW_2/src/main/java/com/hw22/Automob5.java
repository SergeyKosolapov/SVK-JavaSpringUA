package com.hw22;

public class Automob5 {
    private Movement movement;
    private String nameAuto;
    private String wheelDrive;
//    public String transm;

    public Automob5(Movement movement, String nameAuto) {

        this.movement = movement;
        this.nameAuto = nameAuto;
    }

    public void initWD() {
        this.wheelDrive = "AWD";
    }

    public void movingOnRoad() {
        System.out.println(this.nameAuto + " Motion" + movement.getTarget() + ' ' + this.wheelDrive);
    }
}
