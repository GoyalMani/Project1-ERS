package util;


import Dao.Reimbmethod;

import Dao.impl.Reimbmethodimpl;

public class Reimbstore {
    public static Reimbmethod r1;

    private Reimbstore() {

    }

    public static Reimbmethod getreimbmethod()
    {
        if (r1 == null)
            r1 =new Reimbmethodimpl();
        return r1;

    }
}