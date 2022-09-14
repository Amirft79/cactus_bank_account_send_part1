package ir.cactus;

import ir.cactus.database.BankAccountDataBase;
import ir.cactus.model.Account;
import ir.cactus.model.Customer;
import ir.cactus.utils.BankAccountFileReader;
import ir.cactus.utils.BankDataValidator;
import ir.cactus.utils.JsonErrorFileMaker;

import javax.xml.validation.Validator;
import java.util.*;

public class BankAccountDataServerInput {


    public static void main(String[] args) {
        ArrayList<Account>accounts= BankAccountFileReader.getAccount();
        ArrayList<Customer>customers=BankAccountFileReader.getCustomer();
        System.out.println("wellcome to the bank initializer app please select your plan"+"\n"+
                "validate account and customer data press :  1"+"\n"+
                "put validated data in database press :  2 "+"\n"+
                "for make file for error of data press :  3");
        Scanner plan_input=new Scanner(System.in);
        char input=plan_input.next().charAt(0);
        if (input=='1'){
            System.out.println("we are now validate bank data");
            BankDataValidator validator=new BankDataValidator(accounts,customers);
            validator.isDataValidate();
            try {
                Thread.currentThread().sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("validation complete ::::::"+"\n");
            System.out.println(validator.getError_accounts().size());
            System.out.println(validator.getError_customers().size());
        }
        else if (input=='2'){
            BankDataValidator validator=new BankDataValidator(accounts,customers);
            validator.isDataValidate();
            try {
                Thread.currentThread().sleep(7000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("sending to database:::::::::::::::::::");
            BankAccountDataBase dataBase=new BankAccountDataBase(validator.getAccounts(), validator.getCustomers());
            System.out.println("adding customer to the database ");
            dataBase.insertCustomerData();
            System.out.println("adding account to the database ");
            dataBase.insertAccountData();
            System.out.println("done");
            System.out.println("validation complete ::::::"+"\n");
        }
        else if (input=='3'){
            BankDataValidator validator=new BankDataValidator(accounts,customers);
            validator.isDataValidate();
            JsonErrorFileMaker jsonErrorFileMaker=new JsonErrorFileMaker(validator.getError_accounts(),validator.getError_customers());
            System.out.println("make customer error file");
            jsonErrorFileMaker.MakeJsonFileOfCustomer();
            System.out.println("make account error file");
            jsonErrorFileMaker.MakeJsonOfAccount();
            try {
                Thread.currentThread().sleep(2000);
            }catch (InterruptedException e){e.printStackTrace();}
            System.out.println("make account error file");
            jsonErrorFileMaker.MakeAllErrorJsonFile();
            try {
                Thread.currentThread().sleep(2000);
            }catch (InterruptedException e){e.printStackTrace();}
            System.out.println("genetreated");

        }else {

            System.out.println("input not valid");
        }
    }
}
