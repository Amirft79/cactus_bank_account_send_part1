package ir.cactus.utils;

import ir.cactus.model.Account;
import ir.cactus.model.Customer;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BankDataValidator {

    private ArrayList<Account> accounts;
    private ArrayList<Customer>customers;

    private ArrayList<Account>Error_accounts;
    private ArrayList<Customer>Error_customers;

    private ArrayList<Account> Clone_accounts;
    private ArrayList<Customer>Clone_ERROR_customers;
    private ArrayList<Account> Clone_ERROR_accounts;
    private ArrayList<Customer>Clone_customers;

    private Logger logger=Logger.getLogger(BankDataValidator.class);


    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }



    public BankDataValidator(ArrayList<Account> accounts, ArrayList<Customer> customers) {
        this.accounts = accounts;
        this.customers = customers;
        this.Error_customers=new ArrayList<>();
        this.Error_accounts=new ArrayList<>();
        this.Clone_customers=new ArrayList<>();
        this.Clone_accounts=new ArrayList<>();
        this.Clone_ERROR_accounts=new ArrayList<>();
        this.Clone_ERROR_customers=new ArrayList<>();
    }



    public void  isDataValidate(){
        //check account number add digit numbers
        this.Error_accounts=filterBalanceAccount(this.accounts,isAccountNotBalance());
        this.accounts=filterBalanceAccount(this.accounts,isAccountBalance());
        Customer_Birth_isCheck();
        //check account number add digit numbers
        for (Account account:this.accounts){
                CheckedAccountNumberPattern(account);
        }
        this.accounts=this.Clone_accounts;
        this.Clone_ERROR_accounts=this.Clone_accounts;
        //check customer national id
        for (Customer customer:this.customers) {
            CheckedAccountNumberPattern(customer);
        }
        this.customers=Clone_customers;
        this.Clone_ERROR_customers=Clone_customers;
        //find account that have customer
        this.Clone_customers=new ArrayList<>();
        this.Clone_accounts=new ArrayList<>();
      for (Account account:accounts){
          for (Customer customer:customers){
              if (account.getAccount_Customer_id()==customer.getCustomer_Id()){
                  Clone_accounts.add(account);
              }
          }
      }
      this.accounts=Clone_accounts;
      //find customer that have account
      for (Customer customer:customers){
          for (Account account:accounts){
              if (customer.getCustomer_Id()==account.getAccount_Customer_id()){
                  Clone_customers.add(customer);
                  break;

              }
          }
      }
      customers=Clone_customers;

    //validation for error account that do not have customer compare have customer with all valid account thaht not jave customer
      int i=0;
      for (Account account :Clone_ERROR_accounts){
          if (account==this.accounts.get(i)){
              i++;
              continue;
          }
          Error_accounts.add(account);
      }

      //same as up but valid the acount
        int j=0;
        for (Customer customer :Clone_ERROR_customers){
            if (customer==this.customers.get(j)){
                j++;
                continue;
            }
            Error_customers.add(customer);
        }
    }

    public  Predicate<Account> isAccountBalance(){
        return a->a.getAccount_Balance()<=a.getAccount_Limit();
    }
    public  Predicate<Account> isAccountNotBalance(){
        return a->a.getAccount_Balance()>a.getAccount_Limit();
    }

    public ArrayList<Account>filterBalanceAccount(ArrayList<Account>accounts,Predicate<Account>Balance_Account_Predicate){
        return    accounts.stream()
                .filter(Balance_Account_Predicate)
                .collect(Collectors.toCollection(ArrayList<Account>::new));

    }



    public ArrayList<Account> getError_accounts() {
        return Error_accounts;
    }

    public ArrayList<Customer> getError_customers() {
        return Error_customers;
    }

    /**
     * this method is finding the customer that have birthday more than 1995
     */
    public void Customer_Birth_isCheck(){
            ArrayList<Customer>customerList=new ArrayList<>();
        try {
            Date d = new Date();
            SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            for (Customer customer:this.customers) {
                d = SDF.parse(customer.getCustomer_Birth_Date());
                calendar.setTime(d);
                if (calendar.get(Calendar.YEAR)>1995){
                  customerList.add(customer);
                }
                else{
                    Error_customers.add(customer);
                }
            }
        }catch (Exception e){
            logger.error(e);
        }
        this.customers=customerList;

    }
    public void CheckedAccountNumberPattern(Customer customer){
        String NationalPattern="(\\d{10})";
        Pattern p=Pattern.compile(NationalPattern);
        Matcher matcher=p.matcher(customer.getCustomer_National_ID());
        if (!matcher.matches()) {
            this.Error_customers.add(customer);
        }
        else{
            this.Clone_customers.add(customer);
        }

    }


    public void CheckedAccountNumberPattern(Account account){
        String AccountNumberPattern="(\\d{16})";
        Pattern p=Pattern.compile(AccountNumberPattern);
        Matcher matcher=p.matcher(account.getAccount_Number());
        if (matcher.matches()) {
            this.Clone_accounts.add(account);
        }
        else{
            this.Error_accounts.add(account);
        }

    }



}
