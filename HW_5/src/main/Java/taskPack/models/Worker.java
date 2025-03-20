package taskPack.models;

//import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Worker {
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 1, max = 30, message = "Name should be between 1 and 30 characters")
    private String name;

    //@NotEmpty(message = "Age should not be empty")
    @Min(value =  18, message = "Age should be greater 18")
    private int age;

    @NotEmpty(message = "Education should not be empty")
    @Size(min = 4, max = 30, message = "Education should be between 4 and 30 characters")
    private String education;

    @NotEmpty(message = "Position should not be empty")
    @Size(min = 4, max = 30, message = "Position should be between 4 and 30 characters")
    private String position;


    public Worker() {

    }
    public Worker(int id, String name, int age, String education, String position) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.education = education;
        this.position = position;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() { return position; }

    public void setPosition(String position) { this.position = position; }

    public String getEducation() { return education; }

    public void setEducation(String education) { this.education = education; }

    public int getAge() { return age;}

    public void setAge(int age) { this.age = age;}

}


