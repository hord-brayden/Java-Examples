/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;

import byui.cit260.afghan_trail.controller.GameController;
import byui.cit260.afghan_trail.model.Game;
import byui.cit260.afghan_trail.model.Player;

/**
 *
 * @author jonsi
 */
public interface BasicViewInterface {
    public void display(Game game);
    public void doAction(String[] options, char action, Game game);
    public void displayHelp();
}
