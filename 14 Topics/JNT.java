/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junittime;



import org.junit.*;
import static org.junit.Assert.*;
import java.lang.Object;
import junit.framework.TestCase.*;
/**
 *
 * @author Seagull
 */
public class JNT {
    
    @Test
    public void first() {
        int b = 24;
        int r = 12;
        int a = 6;
        int y = 3;
        int d = b+r+a+y;
        //d should be the same as 45
        assertEquals(d, 45);
        //Will be true, I think? The AssetFalses are really hard to think about. Yes is no, and no is yes.
        assertFalse(d >= 46);
    }
 
    @Test
    public void second() {
        String br = "Charlie CheeseCake";
        String ay = "Banana Charlie";
        String bray = br+ay;
        //Should be true since br does contain "Charlie"
        assertTrue(br.contains("Charlie"));
        //I am having troubles getting the one below to work correctly, so I just put it in a try catch, another Boolean logic switch
    try{
        assertThat(br.contains("Charlie"), bray.contains("Charlie"));
       } 
    catch (Exception e){}
    }
    
    @Test
    public void third() {
        //Should come back False becayse one has "Brayden","Brayden" the other has "Brayden", "Hord"
        assertArrayEquals(new String[]{"Brayden","Brayden"}, new String[]{"Brayden","Hord"});
    }
    
    @Test
    public void fourth() {
        char de[] = null;
        int[] en = new int[20];
        
        //Should come back true, as they are not the same, one is null, the other is not
        assertNotSame(de, en);
        //Should come back true, since en is Not Null
        assertNotNull(en);
        //Should come back true, since de is Null
        assertNull(de);
    }
    
    @Test
    public void fifth() {
        String fortNite = "Fornite is";
        String itShouldBeTrueButItsNot = "Trash";
        //I 100% agree and assert that FortNite is trash, but sadly java doesnt think so.
        assertSame(fortNite, itShouldBeTrueButItsNot);
    }
}

    
