/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationcontroller4;

import java.util.HashMap;

/**
 *
 * @author Brayden Hord
 */
public class GunControl {
    public static HashMap<Integer, GunsHandle> gun = new HashMap <Integer, GunsHandle>();
    public static void put(int guns){
    
     gun.put(1, new Glocks());
     gun.put(2, new ARs());
     gun.put(3, new Shotguns());
        
   
     GunsHandle ghand = gun.get(guns);
     ghand.execute(guns);
    }
 }