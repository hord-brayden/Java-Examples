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
public class HuntControllerException extends Exception {

    public HuntControllerException() {
    }

    public HuntControllerException(String string) {
        super(string);
    }

    public HuntControllerException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public HuntControllerException(Throwable thrwbl) {
        super(thrwbl);
    }

    public HuntControllerException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
