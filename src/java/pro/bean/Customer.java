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
public class Customer {
    String custname;
    int age;
    String custaddr;
    String city;
    String state;
    int ssnid;

    public Customer() {
    }

    public Customer(String custname, int age, String custaddr, String city, String state, int ssnid) {
        this.custname = custname;
        this.age = age;
        this.custaddr = custaddr;
        this.city = city;
        this.state = state;
        this.ssnid = ssnid;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCustaddr() {
        return custaddr;
    }

    public void setCustaddr(String custaddr) {
        this.custaddr = custaddr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getSsnid() {
        return ssnid;
    }

    public void setSsnid(int ssnid) {
        this.ssnid = ssnid;
    }
    
    
}
