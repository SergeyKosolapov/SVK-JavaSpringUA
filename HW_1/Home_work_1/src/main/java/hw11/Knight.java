package hw11;

public class Knight {
    private int id;
    private String name;
    private int numOfSoldiers;

    public Knight(int id, String name, int numOfSoldiers) {
        this.id = id;
        this.name = name;
        this.numOfSoldiers = numOfSoldiers;
    }

    public String TestKnight(String name) {
        return this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfSoldiers() {return numOfSoldiers;}
    public void setNumOfSoldiers(int numOfSoldiers) { this.numOfSoldiers = numOfSoldiers;}

    @Override
    public String toString() {
        return "Knight(" +
                "id="+id+
                " , name="+name+
                " , numOfSoldiers="+numOfSoldiers+
                ")";
    }
}
