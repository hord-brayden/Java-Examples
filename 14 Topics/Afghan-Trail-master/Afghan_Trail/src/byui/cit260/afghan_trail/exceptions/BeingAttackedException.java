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
public class BeingAttackedException extends Exception{

    public BeingAttackedException() {
    }

    public BeingAttackedException(String string) {
        super(string);
    }

    public BeingAttackedException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public BeingAttackedException(Throwable thrwbl) {
        super(thrwbl);
    }

    public BeingAttackedException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
