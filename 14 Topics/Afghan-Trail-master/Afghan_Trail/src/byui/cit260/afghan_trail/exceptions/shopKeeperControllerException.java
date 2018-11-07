/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.exceptions;

/**
 *
 * @author rizky
 */
public class shopKeeperControllerException extends Exception {

    public shopKeeperControllerException() {
    }

    public shopKeeperControllerException(String string) {
        super(string);
    }

    public shopKeeperControllerException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public shopKeeperControllerException(Throwable thrwbl) {
        super(thrwbl);
    }

    public shopKeeperControllerException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
