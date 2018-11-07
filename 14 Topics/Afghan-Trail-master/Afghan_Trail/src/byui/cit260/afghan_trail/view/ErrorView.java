/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;

import afghan_trail.Afghan_Trail;
import java.io.PrintWriter;

/**
 *
 * @author jonsi
 */
public class ErrorView {
    private static PrintWriter console = Afghan_Trail.getOutFile();
    private static PrintWriter log = Afghan_Trail.getLogFile();
    
    public static void display(String className, String errorMessage){
        console.println(
                "\n---ERROR------------------------------------------"
              + "\n" + errorMessage
              + "\n--------------------------------------------------");
        log.printf("%n%n%s", className + " - " + errorMessage);
    }
}
