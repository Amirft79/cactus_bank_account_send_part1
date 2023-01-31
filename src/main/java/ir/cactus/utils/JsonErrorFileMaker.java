package ir.cactus.utils;


import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import ir.cactus.model.Account;
import ir.cactus.model.Customer;
import org.apache.log4j.Logger;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;

public class JsonErrorFileMaker {
    private ArrayList<Account> accounts;
    private ArrayList<Customer>customers;

    private Logger logger=Logger.getLogger(JsonErrorFileMaker.class);

    private ArrayList<JsonFileModel> jsonFileModels;

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public JsonErrorFileMaker(ArrayList<Account> accounts, ArrayList<Customer> customers) {
        this.accounts = accounts;
        this.customers = customers;
        this.jsonFileModels=new ArrayList<>();
    }



    public void MakeJsonFileOfCustomer(){
        Gson Customer_Gson=new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

        try (FileWriter writer=new FileWriter("Error_Customer.json")){
            writer.write("[");
            int i=0;
            for (Customer customer:this.customers){
                if (i!=0){
                    writer.write(",");
                }
                Customer_Gson.toJson(customer,writer);
                this.jsonFileModels.add(new JsonFileModel("customer",customer.getRecord_Number(),201,"wrong customer"," this not valid customer",new Date()));
                i++;
            }
            writer.write("]");
        }catch (Exception e){
            logger.error(e);
        }
    }

    public void MakeJsonOfAccount(){
        Gson Account_Gson=new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter writer=new FileWriter("Error_Account.json")){
            writer.write("[");
            int i=0;
            for (Account account:accounts){
                if (i!=0){
                    writer.write(",");
                }
                Account_Gson.toJson(account,writer);
                this.jsonFileModels.add(new JsonFileModel("Accounts",account.getRecord_Number(),202,"wrong account",
                        "this account is not valid",new Date()));
                i++;
            }
            writer.write("]");
        }catch (Exception e){
            logger.error(e);        }
    }
    public void MakeAllErrorJsonFile(){
        Gson ALLFile_Gson= new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter fileWriter=new FileWriter("Error_Json.json")){
            fileWriter.write("[");
            int i=0;
            for(JsonFileModel jsonFileModel:this.jsonFileModels){
                if (i!=0){
                    fileWriter.write(",");
                }
                ALLFile_Gson.toJson(jsonFileModel,fileWriter);
                i++;
            }
            fileWriter.write("]");
        }catch (Exception e){
            logger.error(e);
        }

    }

}
