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
public class User_2 {

    private int passengerno, FromAirport, ToAirport;
    String username, password, dateAndTime;

    public User_2(int passengerno, String username, String password, int FromAirport, int ToAirport, String dateAndTime) {
        this.passengerno = passengerno;
        this.username = username;
        this.password = password;
        this.FromAirport = FromAirport;
        this.ToAirport = ToAirport;
        this.dateAndTime = dateAndTime;
    }

    public int getpassengerno() {
        return passengerno;
    }

    public String getusername() {
        return username;
    }

    public String getpassword() {
        return password;
    }

    public int getFromAirport() {
        return FromAirport;
    }

    public int getToAirport() {
        return ToAirport;
    }
    public String getdateAndTime() {
        return dateAndTime;
    }
}
