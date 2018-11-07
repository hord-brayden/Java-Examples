package byui.cit260.afghan_trail.controller;
import byui.cit260.afghan_trail.model.Player;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brayden
 */
public class DiseaseContractionTest {
    
    public DiseaseContractionTest(){
        
     /**
     * Test of DiseaseContraction method
     */
    }
    @Test
    public void testDiseaseContraction() {
        //input variables
        Player john = new Player("John", 11, "Carpenter");
        john.setStamina(20);
        int medicine = 10;
        //int ranNum = (int) Math.ceil(Math.random() * 100);
        boolean setIsSick = true;
        boolean expResults = false;
        
        System.out.println("\tTest case 1");
        boolean result = DiseaseContraction.diseaseContraction (john.getStamina(), medicine, setIsSick);
        assertEquals(expResults, result);
        
        System.out.println("\tTest case 2");
        john.setStamina(4);
        medicine = 5;
        expResults = false;
        result = DiseaseContraction.diseaseContraction (john.getStamina(), medicine, setIsSick);
        assertEquals(expResults, result);
        
        System.out.println("\tTest case 3");
        john.setStamina(87);
        medicine = 21;
        expResults = false;
        result = DiseaseContraction.diseaseContraction (john.getStamina(), medicine, setIsSick);
        assertEquals(expResults, result);
        
       System.out.println("\tTest case 4");
        john.setStamina(14);
        medicine = 52;
        expResults = false;
        result = DiseaseContraction.diseaseContraction (john.getStamina(), medicine, setIsSick);
        assertEquals(expResults, result);
        
        System.out.println("\tTest case 5");
        john.setStamina(99);
        medicine = 85;
        expResults = false;
        result = DiseaseContraction.diseaseContraction (john.getStamina(), medicine, setIsSick);
        assertEquals(expResults, result);
        
        System.out.println("\tTest case 6");
        john.setStamina(41);
        medicine = 95;
        expResults = false;
        result = DiseaseContraction.diseaseContraction (john.getStamina(), medicine, setIsSick);
        assertEquals(expResults, result);
        
    }
}
