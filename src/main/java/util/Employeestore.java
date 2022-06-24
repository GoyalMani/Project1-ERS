package util;

import Dao.Employeemethod;
import Dao.impl.Employeemethodimpl;

public class Employeestore {
    public static Employeemethod e1;
    private Employeestore(){

    }
   public static   Employeemethod getemployeemethod()
   {
       if(e1==null)
      e1=new Employeemethodimpl();
       return e1;

   }




}
