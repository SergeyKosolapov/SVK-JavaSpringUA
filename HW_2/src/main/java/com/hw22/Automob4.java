package com.hw22;

public class Automob4 {
    private Movement movement;
    private String nameAuto;
//        public String wheelDrive;
//    public String transm;

    //public Automob4(Movement movement) {
//        this.movement = movement;
//    }
    public Automob4(String nameAuto) {

        this.nameAuto = nameAuto;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public Movement getMovement() {
        return movement;
    }
    public void setNameAuto(String nameAuto) {
        this.nameAuto = nameAuto;
    }

    public String getNameAuto() {
        return nameAuto;
    }

    public void movingOnRoad() {
        System.out.println(this.nameAuto + " Motion" + movement.getTarget());
    }
}
