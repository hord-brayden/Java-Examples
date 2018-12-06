/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationcontroller4;
import java.util.*;
import java.io.*;
/**
 *
 * @author Brayden Hord
 */
public class ApplicationControllerPattern {
    /**
     * @paramargs the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        GunControl find = new GunControl();

        try {
            System.out.println("GUNS " + "GUNS " + "GUNS");
            System.out.println("GUNS " + "GUNS " + "GUNS");

            System.out.println("1 for Glocks that I own");
            System.out.println("2 for ARs that I own");
            System.out.println("3 for Shotguns that I own");

            System.out.println(("GUNS " + "GUNS " + "GUNS"));
            System.out.println(("GUNS " + "GUNS " + "GUNS"));
            int gun = Integer.parseInt(read.readLine());
            find.put(gun);
            
        }
        
        catch (Exception q){
            System.out.println("See what kinda of guns that I have! Select an option");
            int gun = Integer.parseInt(read.readLine());
            find.put(gun);
        }           
     }
}
