package main;

import dao.CustomerDAO;
import dao.TransactionDAO;
import model.Customer;
import model.Transaction;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerDAO customerDAO = new CustomerDAO();
        TransactionDAO transactionDAO = new TransactionDAO();

        try {
            while (true) {
                System.out.println("1. Add Customer");
                System.out.println("2. View Customers");
                System.out.println("3. Add Transaction");
                System.out.println("4. View Customer Balance");
                System.out.println("5. Exit");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter First Name, Last Name, Email:");
                        Customer c = new Customer(sc.next(), sc.next(), sc.next());
                        customerDAO.addCustomer(c);
                        System.out.println("Customer Added!");
                        break;

                    case 2:
                        for (Customer cust : customerDAO.getAllCustomers()) {
                            System.out.println(
                                    cust.customerID + ": " + cust.firstName + " " + cust.lastName + " - " + cust.email);
                        }
                        break;

                    case 3:
                        System.out.println("Enter Customer ID, Type(deposit/withdraw), Amount:");
                        Transaction t = new Transaction(sc.nextInt(), sc.next(), sc.nextDouble());
                        transactionDAO.addTransaction(t);
                        System.out.println("Transaction Added!");
                        break;

                    case 4:
                        System.out.println("Enter Customer ID:");
                        int id = sc.nextInt();
                        double dep = transactionDAO.getTotalByType(id, "deposit");
                        double wit = transactionDAO.getTotalByType(id, "withdraw");
                        System.out.println("Balance = " + (dep - wit));
                        break;

                    case 5:
                        return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
