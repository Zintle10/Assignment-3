/**
 * Zintle Magwaxaza 218109911
 * WriteCustomer.java
 * Writing to txt file
 * 9 June 2021
 */
package za.ac.cput.assignment3;

import java.io.*;
import java.util.ArrayList;


public class WriteCustomer extends Customer {
    private BufferedWriter bw;
    private FileWriter fw;
    ArrayList<Customer> cust = new ArrayList<>();
    
     public void openFile()
    {
        try{
        fw = new FileWriter("CustomerOutFile.txt");  
        bw = new BufferedWriter(fw);  
        System.out.println("File created successfully ");    
        }
        catch (IOException e){
            System.out.println("File creation error ");    
        }
    }
    public void writeFile(){
       try{
            bw.write(String.format("%-15s\n", "============================CUSTOMERS============================="));  
            bw.write(String.format("%-15s%-15s%-15s%-15s%-15s\n", "ID", "Name", "Surname", "Date of birth", "Age")); 
            bw.write(String.format("%-15s\n", "==================================================================="));
            bw.write(String.format(cust.toString()));
            
        }
        catch (IOException e){
            System.out.println("Error writing to file");    
        }
    }
 
    public void closeFile(){
        try{
            bw.close();
        }
        catch (IOException e){
            System.out.println("File closing error");    
        }
        
    }
    public static void main(String[] args) {
    WriteCustomer wc = new WriteCustomer();
     wc.openFile();
      wc.writeFile();
      wc.closeFile();
    }
}
