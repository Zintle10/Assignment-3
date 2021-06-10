/**
 * Zintle Magwaxaza 218109911
 * ReadStakeholder.java
 * Reading Ser file
 * 9 June 2021
 */
package za.ac.cput.assignment3;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;



public class ReadStakeholder implements Serializable {
    private ObjectInputStream input;
     int counterCustomer=0;
     int counterSupplier=0;
     //Customer cust;
     Stakeholder stake;
    ArrayList<Customer> cust = new ArrayList<>();
    ArrayList<Supplier> supp=new ArrayList<>();
    
  
    public void openFile () {
       
        try{
            input=new ObjectInputStream(new FileInputStream("stakeholder.ser"));
            System.out.println("Ser file opened");
            
             
            
        } catch (IOException ioe){            
        System.out.println("error opening file for reading:" + ioe.getMessage());
        }  
        
    }
    public void readFile(){
        try {
           while(true){
               cust.add((Customer)input.readObject());
               System.out.println(cust);
               counterCustomer++;
               supp.add((Supplier)input.readObject());
               counterSupplier++;
               System.out.println(supp);
            }
        }
        catch(EOFException e){
                System.out.println("EOF Reached");
              } 
    
        catch (ClassNotFoundException cnf){
            System.out.println("error reading file" + cnf);
        }
        catch (IOException ioe){
            System.out.println("error reading file "+ ioe);
        }
    }
  
    public void sortCust (){
       
        for (int i=0; i<counterCustomer; i++){
            for (int z=i+1; z<counterCustomer; z++){
                if (cust.get(i).getStHolderId().compareTo(cust.get(z).getStHolderId())>0){
                    Customer temp =cust.get(i);
                    cust.set(i,cust.get(z));
                    cust.set(z, temp);
                }
            }
        }
    }
   public void closeFile(){
        try{
            input.close();
        }
        catch (IOException e){
            System.out.println("File closing error has occured");    
        }
    }
    public static void main(String[]args)
    {
        ReadStakeholder s = new ReadStakeholder();
        s.openFile();
        s.readFile();
        s.closeFile();
    }
        
        
        
       /* 
        
        for(;;){
                customer.add((Customer)input.readObject());
                //System.out.println(customer.toString()) ;
               // counterCustomer++;
               for(int k=0; k<supplier.size();k++){
                supplier.add((Supplier) input.readObject());
                //System.out.println(supplier.toString()) ;
                //counterSupplier++;
            }
        }
        }
        catch (ClassNotFoundException cnfe){
          System.out.println(cnfe.getMessage());
        }
       
       }
       
       }
    
   
   
    
    */
   
   
        //s.displayCust();
        //s.sortCust();
        
    
}


