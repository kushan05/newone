package com.bithunters.details;

/**
 * Created by kushan on 1/28/2018.
 */

public class Resposedetail {

    private String success;
    private String firstname;
    private String middlename;
    private String lastname;
    private String dob;
    private String email;
    private String workinghours;
    private String startdate;
    private String category;
    private String department;
    private String description;


    public Resposedetail (String success,String firstname, String middlename, String lastname,
                          String dob,String email,String workinghours, String startdate,String category,
                          String department, String description){

        this.success = success;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.dob = dob;
        this.email = email;
        this.workinghours = workinghours;
        this.startdate = startdate;
        this.category  = category;
        this.department = department;
        this.description = description;
    }

    public String getSuccess(){
        return success;
    }

    public String getFirstname(){
        return  firstname;
    }

    public String getMiddlename(){
        return middlename;
    }

    public String getLastname(){
        return lastname;
    }

    public String getDob(){
        return dob;
    }

    public  String getEmail(){
        return email;
    }

    public String getWorkinghours(){
        return workinghours;
    }

    public  String getStartdate(){
        return startdate;
    }

    public String getCategory(){
        return category;
    }

    public String getDepartment(){
        return department;
    }

    public String getDescription(){
        return description;
    }
}
