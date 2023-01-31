package ir.cactus.utils;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ir.cactus.model.Account;
import ir.cactus.model.Customer;

import java.io.FileWriter;
import java.util.ArrayList;

public class JsonCorrectFileMaker {

    private ArrayList<Customer>customers;
    private ArrayList<Account>accounts;

    public JsonCorrectFileMaker(ArrayList<Customer> customers, ArrayList<Account> accounts) {
        this.customers = customers;
        this.accounts = accounts;
    }



    public void MakeCustomerCorrectJsonFile(){
        Gson Customer_Correct_Json=new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter writer=new FileWriter("Correct_Customer.json")){
            writer.write("[");
            int i=0;
            for (Customer customer:customers){
                if (i!=0){
                    writer.write(",");
                }
                Customer_Correct_Json.toJson(customer,writer);
                i++;
            }
            writer.write("]");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void Make_Correct_Account_Json_File(){
        Gson Correct_Account_Gson=new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter writer=new FileWriter("Correct_Account.json")){
            writer.write("[");
            int i=0;
            for(Account account:accounts){
                if (i!=0){
                    writer.write(",");
                }
                Correct_Account_Gson.toJson(account,writer);
                i++;
            }
            writer.write("]");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }



    }
}
