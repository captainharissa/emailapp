package emailapp;

import java.util.HashMap;

public class DataBase {

    HashMap<String,String> logininfo = new HashMap<String,String>();

    public DataBase(String ID, String mdp){
        logininfo.put(ID,mdp);
    }

    public HashMap getLoginInfo(){
        return logininfo;
    }

}
