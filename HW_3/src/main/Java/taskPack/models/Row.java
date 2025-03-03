package taskPack.models;

//import javax.validation.constraints.Email;
//import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Row {
    private int id;

    @NotEmpty(message = "data1 should not be empty")
    @Size(min = 1, max = 30, message = "Data1 should be between 1 and 30 characters")
    private String data1;

    public Row() {

    }
    public Row(int id, String data1) {
        this.id = id;
        this.data1 = data1;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

}



