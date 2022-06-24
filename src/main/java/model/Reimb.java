package model;

public class Reimb {
    private int rem_id;
    private String rem_status;
    private int rem_amt;
    private String rem_type;
    private String emp_id;
    private String rem_date;
    private String hr_id;
    private String remapp_date;

    public Reimb(){

    }

    public Reimb(int rem_id, String rem_status) {
        this.rem_id = rem_id;
        this.rem_status = rem_status;
    }

    public Reimb(int rem_id, String rem_status, String emp_id) {
        this.rem_id = rem_id;
        this.rem_status = rem_status;
        this.emp_id = emp_id;
    }

    public Reimb(int rem_id, int rem_amt, String rem_type, String emp_id, String rem_date) {
        this.rem_id = rem_id;
        this.rem_amt = rem_amt;
        this.rem_type = rem_type;
        this.emp_id = emp_id;
        this.rem_date = rem_date;
    }
public Reimb(int rem_id,String rem_status,String rem_type,String rem_date,int rem_amt,String remapp_date,String hr_id){
        this.rem_id=rem_id;
        this.rem_status=rem_status;
        this.rem_type=rem_type;
        this.rem_date=rem_date;
        this.rem_amt=rem_amt;
        this.remapp_date=remapp_date;
        this.hr_id=hr_id;
}

    public Reimb(String emp_id,int rem_id,String rem_status,int rem_amt,String rem_type,String rem_date,String remapp_date,String hr_id)
    {
        this.emp_id=emp_id;
        this.rem_id=rem_id;
        this.rem_status=rem_status;
        this.rem_amt=rem_amt;
        this.rem_type=rem_type;
        this.rem_date=rem_date;
        this.remapp_date=remapp_date;
        this.hr_id=hr_id;
    }

    public int getRem_id() {
        return rem_id;
    }

    public void setRem_id(int rem_id) {
        this.rem_id = rem_id;
    }

    public String getRem_status() {
        return rem_status;
    }

    public void setRem_status(String rem_status) {
        this.rem_status = rem_status;
    }

    public int getRem_amt() {
        return rem_amt;
    }

    public void setRem_amt(int rem_amt) {
        this.rem_amt = rem_amt;
    }

    public String getRem_type() {
        return rem_type;
    }

    public void setRem_type(String rem_type) {
        this.rem_type = rem_type;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getHr_id() {
        return hr_id;
    }

    public void setHr_id(String hr_id) {
        this.hr_id = hr_id;
    }

    public String getRemapp_date() {
        return remapp_date;
    }

    public void setRemapp_date(String remapp_date) {
        this.remapp_date = remapp_date;
    }

    public String getRem_date() {
        return rem_date;
    }

    public void setRem_date(String rem_date) {
        this.rem_date = rem_date;
    }

    @Override
    public String toString() {
        return "Reimb{" +
                "rem_id=" + rem_id +
                ", rem_status='" + rem_status + '\'' +
                ", rem_amt=" + rem_amt +
                ", rem_type='" + rem_type + '\'' +
                ", emp_id='" + emp_id + '\'' +
                ", rem_date='" + rem_date + '\'' +
                ", hr_id='" + hr_id + '\'' +
                ", remapp_date='" + remapp_date + '\'' +
                '}';
    }
}

