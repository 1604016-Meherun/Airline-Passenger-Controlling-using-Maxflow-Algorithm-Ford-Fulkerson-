/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Airline1;

/**
 *
 * @author MeherunNesaShraboni
 */
public class User_1 {
     private int id;
     String firstname,lastname,username,password,email_id,web_url;
    public User_1(int id,String firstname,String lastname,String username,String password,String email_id,String web_url)
    {
        this.id=id;
        this.firstname=firstname;
        this.lastname=lastname;
        this.username=username;
        this.password=password;
        this.email_id=email_id;
        this.web_url=web_url;
    }
   
    public int getid()
    {
            return id;
    }
    public String getfirstname()
    {
            return firstname;
    }
    public String getlastname()
    {
            return lastname;
    }
    public String getusername()
    {
            return username;
    }
    public String getpassword()
    {
            return password;
    }
    public String getemail_id()
    {
            return email_id;
    }
    public String getweb_url()
    {
            return web_url;
    }
   
}
