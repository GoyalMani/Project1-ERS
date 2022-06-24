package util;

import Dao.Managermethod;
import Dao.impl.Managermethodimpl;

public class Managerstore {
   public static Managermethod m1;
   private Managerstore()
   {

   }
    public static Managermethod getmanagermethod()
    {
        if(m1==null)
            m1=new Managermethodimpl();
        return m1;
    }


}
