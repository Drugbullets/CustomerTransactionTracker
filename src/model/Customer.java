package model;

public class Customer {
    public int customerID;
    public String firstName;
    public String lastName;
    public String email;

    public Customer(int id, String f, String l, String e) {
        this.customerID = id;
        this.firstName = f;
        this.lastName = l;
        this.email = e;
    }

    public Customer(String f, String l, String e) {
        this.firstName = f;
        this.lastName = l;
        this.email = e;
    }
}
