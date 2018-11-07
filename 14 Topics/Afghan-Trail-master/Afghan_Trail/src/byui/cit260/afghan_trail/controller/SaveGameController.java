/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;

import afghan_trail.Afghan_Trail;
import byui.cit260.afghan_trail.model.Game;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;

/**
 *
 * @author jonsi
 */
public class SaveGameController {
    public static void saveInSlot(String filename, Game game){
        Afghan_Trail.getOutFile().println("\nSaving to \"" + filename + "\"\n");
        
        try (ObjectOutputStream out = 
                new ObjectOutputStream(new FileOutputStream("saved_games\\" + filename)
                )
            )
        {
            out.writeObject(game);
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        }
        
        Afghan_Trail.getOutFile().println("Save Successful!\n");
    }
}
