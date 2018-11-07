/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.exceptions;

/**
 *
 * @author rizkyabraham
 */
public class GameControllerException extends Exception{

    public GameControllerException() {
    }

    public GameControllerException(String string) {
        super(string);
    }

    public GameControllerException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public GameControllerException(Throwable thrwbl) {
        super(thrwbl);
    }

    public GameControllerException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
