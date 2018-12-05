import java.util.*;
import org.json.*;

//below imports not needed, the above astrix imports are
//for importing everything under the rainbow within those interfaces
//but I included for ease of understanding
import org.json.simple.JSONObject;
import java.util.LinkedHashMap; 
import java.util.Map; 



	public class jsonExample {

  	 public static void main(String[] args){

      JSONObject objPersonal = new JSONObject();
      	objPersonal.put("name", "Brayden");
      	objPersonal.put("city", "Pasco");
      	objPersonal.put("state", "Washington" );
      	objPersonal.put("major", "CIT");
      	objPersonal.put("Section", 360);
      	objPersonal.put("practicing", "JSON");
      	objPersonal.put("married", new Boolean(true));
      	objPersonal.put("kids", 2);

      JSONObject objPersonal2 = new JSONObject();
     	objPersonal2.put("favorite-stuff", "guns");


     // String personalStuff = new JSONObject();

      Map gunStuff = new LinkedHashMap(3); 
      	gunStuff.put("Glock 17", "9mm"); 
      	gunStuff.put("Glock 19", "9mm"); 
      	gunStuff.put("AR-10", "7.62mm"); 

      //Putting my gunstuff map which is a LinkedHashMap, into a the objPersonal2 JSONobject
      objPersonal.put("favorite-stuff", gunStuff);

      //We'll take the two objects we've created, and add them to an arraylist which should be able to print
      ArrayList<JSONObject> outputs = new ArrayList<JSONObject>();
      	outputs.add(objPersonal);
      	outputs.add(objPersonal2);


      //This should be a simple statement that says "Name Brayden likes practicing JSON and likes his Glock 19 9mm"
      for (JSONObject myStuff:outputs){
    	String name = (String) myStuff.get("name");  
		String practicing = (String) myStuff.get("practicing");  
		String glock = (String) myStuff.get("Glock 19");
		System.out.println("\n" + name + " likes " + practicing + " and likes his " + glock);
      }

       }
	}
