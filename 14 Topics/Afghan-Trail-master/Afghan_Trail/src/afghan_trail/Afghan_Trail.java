/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afghan_trail;
import byui.cit260.afghan_trail.model.Game;
import byui.cit260.afghan_trail.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Rizky, Brayden, Jonathan
 */
public class Afghan_Trail {

    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    private static PrintWriter logFile = null;
    private static Game currentGame = null;
    
    private static String exitMsg = "Thank you for playing\n";
    private static String title = "" +
 "                    __      _                   _______        _ _         \n" +
"             /\\    / _|    | |                 |__   __|      (_) |        \n" +
"            /  \\  | |_ __ _| |__   __ _ _ __      | |_ __ __ _ _| |        \n" +
"           / /\\ \\ |  _/ _` | '_ \\ / _` | '_ \\     | | '__/ _` | | |     \n" +
"  _   _   / ____ \\| || (_| | | | | (_| | | | |    | | | | (_| | | |  _   _ \n" +
" (_) (_) /_/    \\_\\_| \\__, |_| |_|\\__,_|_| |_|    |_|_|  \\__,_|_|_| (_) (_)\n" +
"                       __/ |                                                \n" +
"                      |___/                                                 \n";
    
   
    public static void main(String[] args) {
        
        //prepare I/O
        try {
            Afghan_Trail.inFile =  new BufferedReader(new InputStreamReader(System.in));
            Afghan_Trail.outFile = new PrintWriter(System.out, true);
            Afghan_Trail.logFile = new PrintWriter("logfile.txt");
            Afghan_Trail.logFile.print("Test Log Writing");
            
            
            //C:/users/rizky/Desktop/logfile.txt
            // start game
            outFile.print(title);
            StartProgramView startProgramView = new StartProgramView();
            startProgramView.display(null);
        } catch (Throwable e) {
            System.out.println("Exception: " + e.toString() + 
                    "\nCause: " + e.getCause() + 
                    "\nMessage: " + e.getMessage());
            e.printStackTrace();
        } 
        
        //possibly don't need this finally since we aren't opening the files
        finally {
            try {
                
                // end game
                if (Afghan_Trail.inFile != null)
                    Afghan_Trail.inFile.close();
                if (Afghan_Trail.outFile != null)
                    Afghan_Trail.outFile.close();
                if (Afghan_Trail.logFile != null)
                    Afghan_Trail.logFile.close();
                outFile.print(exitMsg);
            } catch (IOException ex) {
                System.out.print("Error closing files");
                return;
            }
        }
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        Afghan_Trail.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        Afghan_Trail.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        Afghan_Trail.logFile = logFile;
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        Afghan_Trail.currentGame = currentGame;
    }
    
    
    
    
    
    
}
