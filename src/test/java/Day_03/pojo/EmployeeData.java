package Day_03.pojo;

public class EmployeeData {
    private  int id;
    private String  employee_name;
    private String  employee_salary;
    private String  employee_age;

    EmployeeData(){}

    @Override
    public String toString() {
        return "EmployeeData{" +
                "id=" + id +
                ", employee_name='" + employee_name + '\'' +
                ", employee_salary='" + employee_salary + '\'' +
                ", employee_age='" + employee_age + '\'' +
                ", profile_image='" + profile_image + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(String employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(String employee_age) {
        this.employee_age = employee_age;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public EmployeeData(int id, String employee_name, String employee_salary, String employee_age, String profile_image) {
        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
    }

    private String  profile_image;

}
