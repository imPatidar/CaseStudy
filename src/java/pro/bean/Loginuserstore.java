/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.bean;

/**
 *
 * @author sneha
 */
public class Loginuserstore {
     String name;
    String pass;
    String timestamp;

    public Loginuserstore() {
    }

    public Loginuserstore(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public Loginuserstore(String name, String pass, String timestamp) {
        this.name = name;
        this.pass = pass;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

   
    
}
