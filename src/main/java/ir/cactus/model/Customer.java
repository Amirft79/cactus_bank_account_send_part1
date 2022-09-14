package ir.cactus.model;

public class Customer {

    private int Record_Number;
    private int Customer_Id;
    private String Customer_Name;
    private String Customer_Surname;
    private String Customer_Address;
    private int Customer_Zip_Code;
    private  String  Customer_National_ID;
    private String  Customer_Birth_Date;


    public Customer(int record_Number, int customer_Id, String customer_Name, String customer_Surname, String customer_Address, int customer_Zip_Code, String customer_National_ID, String customer_Birth_Date) {
        Record_Number = record_Number;
        Customer_Id = customer_Id;
        Customer_Name = customer_Name;
        Customer_Surname = customer_Surname;
        Customer_Address = customer_Address;
        Customer_Zip_Code = customer_Zip_Code;
        Customer_National_ID = customer_National_ID;
        Customer_Birth_Date = customer_Birth_Date;
    }

    public void setRecord_Number(int record_Number) {
        Record_Number = record_Number;
    }

    public void setCustomer_Id(int customer_Id) {
        Customer_Id = customer_Id;
    }

    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    public void setCustomer_Surname(String customer_Surname) {
        Customer_Surname = customer_Surname;
    }

    public void setCustomer_Address(String customer_Address) {
        Customer_Address = customer_Address;
    }

    public void setCustomer_Zip_Code(int customer_Zip_Code) {
        Customer_Zip_Code = customer_Zip_Code;
    }

    public void setCustomer_National_ID(String customer_National_ID) {
        Customer_National_ID = customer_National_ID;
    }

    public void setCustomer_Birth_Date(String customer_Birth_Date) {
        Customer_Birth_Date = customer_Birth_Date;
    }

    public int getRecord_Number() {
        return Record_Number;
    }

    public int getCustomer_Id() {
        return Customer_Id;
    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public String getCustomer_Surname() {
        return Customer_Surname;
    }

    public String getCustomer_Address() {
        return Customer_Address;
    }

    public int getCustomer_Zip_Code() {
        return Customer_Zip_Code;
    }

    public String getCustomer_National_ID() {
        return Customer_National_ID;
    }

    public String getCustomer_Birth_Date() {
        return Customer_Birth_Date;
    }

    @Override
    public String toString() {
        return Customer_Id+"   "+getCustomer_Birth_Date();
    }
}
