package model;

public class Transaction {
    public int transactionID;
    public int customerID;
    public String type;
    public double amount;

    public Transaction(int customerID, String type, double amount) {
        this.customerID = customerID;
        this.type = type;
        this.amount = amount;
    }
}
