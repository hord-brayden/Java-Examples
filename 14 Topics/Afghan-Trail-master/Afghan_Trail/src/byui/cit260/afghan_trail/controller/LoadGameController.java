/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;

import afghan_trail.Afghan_Trail;
import byui.cit260.afghan_trail.model.Game;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


/**
 *
 * @author jonsi
 */
public class LoadGameController {
    public static void loadGame(String filename) throws NullPointerException {
        Afghan_Trail.getOutFile().println("\nLoading \"" + filename + "\"\n");
        
        try (ObjectInputStream out = 
                new ObjectInputStream(new FileInputStream("saved_games\\" + filename)
                )
            )
        {
            Game game = (Game) out.readObject();
            Afghan_Trail.setCurrentGame(game);
            
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        } catch (ClassNotFoundException cnf){
            System.out.println("Class Not Found: " + cnf.getMessage());
        }
        
        Afghan_Trail.getOutFile().println("Load Successful!\n");
    }
}
