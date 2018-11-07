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
public class FindItemControllerException extends Exception {

    public FindItemControllerException() {
    }

    public FindItemControllerException(String string) {
        super(string);
    }

    public FindItemControllerException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public FindItemControllerException(Throwable thrwbl) {
        super(thrwbl);
    }

    public FindItemControllerException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
