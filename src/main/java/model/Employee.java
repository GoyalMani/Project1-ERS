package model;

public class Employee {
    private String emp_id;
    private String emp_name;
    private String emp_pwd;
    private String emp_email;
    private String emp_add;

    public Employee(){

    }

    public Employee(String emp_id) {
        this.emp_id = emp_id;
    }

    public Employee(String emp_id, String emp_pwd) {
        this.emp_id = emp_id;
        this.emp_pwd = emp_pwd;
    }

    public Employee(String emp_id, String emp_name, String emp_pwd) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_pwd = emp_pwd;
    }

    public Employee(String emp_id, String emp_name, String emp_pwd, String emp_email) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_pwd = emp_pwd;
        this.emp_email = emp_email;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public Object setEmp_id(String emp_id) {
        this.emp_id = emp_id;
        return null;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_pwd() {
        return emp_pwd;
    }

    public void setEmp_pwd(String emp_pwd) {
        this.emp_pwd = emp_pwd;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public String getAdd() {
        return  emp_add;
    }

    public void setAdd(String add) {
        this.emp_add= add;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id='" + emp_id + '\'' +
                ", emp_name='" + emp_name + '\'' +
                ", emp_pwd='" + emp_pwd + '\'' +
                ", emp_email='" + emp_email + '\'' +
                ", emp_add='" + emp_add + '\'' +
                '}';
    }
}

