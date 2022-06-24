package model;

public class Manager {
  private String hr_id;
  private String hr_name;
  private String hr_pwd;
  private String hr_email;

  public Manager(){

  }

    public Manager(String hr_id) {
        this.hr_id = hr_id;
    }

    public Manager(String hr_id, String hr_pwd) {
        this.hr_id = hr_id;
        this.hr_pwd = hr_pwd;
    }

    public String getHr_id() {
        return hr_id;
    }

    public void setHr_id(String hr_id) {
        this.hr_id = hr_id;
    }

    public String getHr_name() {
        return hr_name;
    }

    public void setHr_name(String hr_name) {
        this.hr_name = hr_name;
    }

    public String getHr_pwd() {
        return hr_pwd;
    }

    public void setHr_pwd(String hr_pwd) {
        this.hr_pwd = hr_pwd;
    }

    public String getHr_email() {
        return hr_email;
    }

    public void setHr_email(String hr_email) {
        this.hr_email = hr_email;
    }

    @Override
    public String toString() {
        return "model.Manager{" +
                "hr_id='" + hr_id + '\'' +
                ", hr_name='" + hr_name + '\'' +
                ", hr_pwd='" + hr_pwd + '\'' +
                ", hr_email='" + hr_email + '\'' +
                '}';
    }
}
