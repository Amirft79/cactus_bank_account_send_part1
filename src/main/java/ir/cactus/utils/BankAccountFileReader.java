package ir.cactus.utils;

import ir.cactus.model.Account;
import ir.cactus.model.Customer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.log4j.Logger;

import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class BankAccountFileReader {

    private static Logger logger=Logger.getLogger(BankAccountFileReader.class);

    public BankAccountFileReader(){

    }

    public static ArrayList<Account> getAccount(){
        ArrayList<Account> accounts=new ArrayList<>();

     try( CSVParser Account_Csv_Parser=new CSVParser(new FileReader("Accounts.csv"), CSVFormat.EXCEL
             .withFirstRecordAsHeader())){
            int account_index=0;
            for (CSVRecord record:Account_Csv_Parser){
                accounts.add(new Account(Integer.parseInt(record.get("Record_Number")),record.get("Account_Number"),AccountType.valueOf(record.get("Account_Type")),
                        Integer.parseInt(record.get("Account_Customer_Id")),Integer.parseInt(record.get("Account_Limit")),record.get("Account_Open_Date"),
                        Integer.parseInt(record.get("Account_Balance"))));
            }

     }catch (Exception e){
         logger.error(e);
     }


        return accounts;
    }

    public static ArrayList<Customer> getCustomer(){
        ArrayList<Customer>customers=new ArrayList<>();

        try(CSVParser Customer_Csv_Parser=new CSVParser(new FileReader("Customer.csv"),CSVFormat.EXCEL.withFirstRecordAsHeader())){
            for (CSVRecord record:Customer_Csv_Parser){
                customers.add(new Customer(Integer.parseInt(record.get("Record_Number")),Integer.parseInt(record.get("Customer_Id")),record.get("Customer_Name"),record.get("Customer_SurName"),
                        record.get("Customer_Address"),Integer.parseInt(record.get("Customer_Zip_Code")),record.get("Customer_National_Id"),record.get("Customer_Birth_Date")));
            }
        }catch (Exception e){
            logger.error(e);
        }
        return customers;
    }

}
