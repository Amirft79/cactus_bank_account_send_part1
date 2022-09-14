package ir.cactus.database;

import ir.cactus.model.Account;
import ir.cactus.model.Customer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BankAccountDataBase {
    private ArrayList<Account>accounts;
    private  ArrayList<Customer>customers;

    private Connection connection=null;
    private PreparedStatement mainStatement=null;
    private ResultSet mainSet=null;



    private static final String INSERT_ACCOUNT="INSERT INTO bank_account(account_number,account_type," +
            "account_customer_id,account_limit,account_open_date,account_balance) values (?,?,?,?,?,?)";


    private static final String INSERT_CUSTOMER="INSERT INTO customers(customer_id,customer_name,customer_surname," +
            "customer_address,customer_zip_code,customer_national_id,customer_birth_date) values (?,?,?,?,?,?,?)";

    public BankAccountDataBase(ArrayList<Account>accounts,ArrayList<Customer>customers) {
        this.accounts=accounts;
        this.customers=customers;
        try {
            DataSource dataSource = BankAccountConnectionPool.getDataSource();
            connection = dataSource.getConnection();
            mainStatement=connection.prepareStatement("DELETE FROM bank_account");
            mainStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public void insertAccountData(){
        try {
            mainStatement = connection.prepareStatement(INSERT_ACCOUNT);
            for (Account account : accounts) {
                mainStatement.setString(1, account.getAccount_Number());
                mainStatement.setString(2, account.getAccountType().toString());
                mainStatement.setInt(3, account.getAccount_Customer_id());
                mainStatement.setInt(4, account.getAccount_Limit());
                mainStatement.setString(5, account.getAccount_Open_Date());
                mainStatement.setInt(6, account.getAccount_Balance());
                mainStatement.executeUpdate();
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }


    public void insertCustomerData(){
        try{
            mainStatement=connection.prepareStatement("DELETE FROM customers");
            mainStatement.executeUpdate();
            mainStatement=connection.prepareStatement(INSERT_CUSTOMER);
            for (Customer customer : customers) {
                mainStatement.setInt(1, customer.getCustomer_Id());
                mainStatement.setString(2, customer.getCustomer_Name());
                mainStatement.setString(3, customer.getCustomer_Surname());
                mainStatement.setString(4, customer.getCustomer_Address());
                mainStatement.setInt(5, customer.getCustomer_Zip_Code());
                mainStatement.setString(6, customer.getCustomer_National_ID());
                mainStatement.setString(7, customer.getCustomer_Birth_Date());
                mainStatement.executeUpdate();

            }




        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                mainStatement.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }












}
