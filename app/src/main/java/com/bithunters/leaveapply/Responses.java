package com.bithunters.leaveapply;

/**
 * Created by kushan on 1/27/2018.
 */

public class Responses {

    private String success;
    private int medical;
    private int annual;
    private int casual;


    public Responses (String success, int medical, int annual, int casual) {
        this.success = success;
        this.medical = medical;
        this.annual = annual;
        this.casual = casual;
    }

    public String getSuccess(){

        return success;
    }

    public int getMedical(){

        return   medical;
    }

    public int getAnnual() {

        return annual;
    }

    public int getCasual(){
        return  casual;
    }
}
