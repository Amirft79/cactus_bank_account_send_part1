package ir.cactus.model;

import ir.cactus.utils.AccountType;

public class Account {

    private int Record_Number;
    private String Account_Number;
    private AccountType accountType;
    private int Account_Customer_id;
    private int Account_Limit;
    private String Account_Open_Date;
    private int Account_Balance;


    public Account(int record_Number, String account_Number, AccountType accountType, int account_Customer_id, int account_Limit, String account_Open_Date, int account_Balance) {
        Record_Number = record_Number;
        Account_Number = account_Number;
        this.accountType = accountType;
        Account_Customer_id = account_Customer_id;
        Account_Limit = account_Limit;
        Account_Open_Date = account_Open_Date;
        Account_Balance = account_Balance;
    }


    public void setRecord_Number(int record_Number) {
        Record_Number = record_Number;
    }

    public void setAccount_Number(String account_Number) {
        Account_Number = account_Number;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setAccount_Customer_id(int account_Customer_id) {
        Account_Customer_id = account_Customer_id;
    }

    public void setAccount_Limit(int account_Limit) {
        Account_Limit = account_Limit;
    }

    public void setAccount_Open_Date(String account_Open_Date) {
        Account_Open_Date = account_Open_Date;
    }

    public void setAccount_Balance(int account_Balance) {
        Account_Balance = account_Balance;
    }

    public int getRecord_Number() {
        return Record_Number;
    }

    public String getAccount_Number() {
        return Account_Number;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public int getAccount_Customer_id() {
        return Account_Customer_id;
    }

    public int getAccount_Limit() {
        return Account_Limit;
    }

    public String getAccount_Open_Date() {
        return Account_Open_Date;
    }

    public int getAccount_Balance() {
        return Account_Balance;
    }




    @Override
    public String toString() {
        return Account_Number+"    "+Account_Customer_id;
    }
}
