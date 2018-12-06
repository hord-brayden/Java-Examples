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
public class ARs implements GunsHandle {
    @Override
    public void execute(int gun){

        String rif = "AR-10 from Grey Ghost Gear ";
        String rifl = "AR-300aac from Grey Ghost Gear ";
        String rifle = "AR-15 homemade ";
        System.out.println(rif + "\n" + rifl + "\n" + rifle + "\n");
        System.out.println("I also have a Pellet Gun!");
    }
}

