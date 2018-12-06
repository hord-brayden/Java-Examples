/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationcontroller4;

/**
 *
 * @author Brayden Hord
 */
public class Glocks implements GunsHandle {
    @Override
    public void execute(int gun){

        String glo = "Glock 19 ";
        String gloc = "Glock 17 ";
        String glock = "Glock 42 ";
        System.out.println(glo + "\n" + gloc + "\n" + glock + "\n");

        System.out.println("I also have a revolver!");
    }
}
