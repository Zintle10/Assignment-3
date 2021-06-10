/**
 * Zintle Magwaxaza 218109911
 * WriteSupplier.java
 * Writing to txt file
 * 9 June 2021
 */
package za.ac.cput.assignment3;

import java.io.*;



    public class WriteSupplier extends ReadStakeholder{
    private BufferedWriter bw;
    private FileWriter fw;
    //ArrayList<Supplier> supp = new ArrayList<>();
    
     public void OpenFile()
    {
        try{
        fw = new FileWriter("SupplierOutFile.txt");  
        bw = new BufferedWriter(fw);  
        System.out.println("File created successfully ");    
        }
        catch (IOException e){
            System.out.println("File creation error ");    
        }
    }
    public void WriteFile(){
       try{
            bw.write(String.format("%-15s\n", "============================SUPPLIERS=============================="));  
            bw.write(String.format("%-15s%-15s%-15s%-15s%-15s\n", "ID", "Name", "Surname", "Prod Type","Description"));
            bw.write(String.format("%-15s\n", "==================================================================="));
            bw.write(String.format(supp.toString()));
            
        }
        catch (IOException e){
            System.out.println("Error writing to file");    
        }
    }
 
    public void CloseFile(){
        try{
            bw.close();
        }
        catch (IOException e){
            System.out.println("File closing error");    
        }
        
    }
    public static void main(String[] args) {
    WriteSupplier s = new WriteSupplier();
     s.OpenFile();
     s.WriteFile();
     s.CloseFile();
    }
}


