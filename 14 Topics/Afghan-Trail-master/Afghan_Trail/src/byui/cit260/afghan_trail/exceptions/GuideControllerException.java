/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.exceptions;

/**
 *
 * @author jonsi
 */
public class GuideControllerException extends Exception {

    public GuideControllerException() {
    }

    public GuideControllerException(String string) {
        super(string);
    }

    public GuideControllerException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public GuideControllerException(Throwable thrwbl) {
        super(thrwbl);
    }

    public GuideControllerException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
