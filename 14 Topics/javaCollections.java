//Java Collections - 

//Java provides a set of standard collection classes that implement Collection interfaces. Some of the classes provide full implementations that can be used as-is and others are abstract class, providing skeletal implementations that are used as starting points for creating concrete collections.

//TreeSet & Iterator Combo Iterator

//TreeSet provides an implementation of the Set interface that uses a tree for storage. Objects are stored in a sorted and ascending order. (IMPORTANT FOR THIS EXAMPLE)
//Access and retrieval times are quite fast, which makes TreeSet an excellent choice when storing large amounts of sorted information that must be found quickly.

//Methods used within this TreeSet is isEmpty, we use an iterator which is expedient to cycling through Collections, first, last, and the clear method.

import java.util.Iterator;
import java.util.TreeSet;
 
public class TreeExample {
 
   public static void main(String[] args) {
	
	// We create a tree set.    
	TreeSet<Integer> treeSet = new TreeSet<Integer>();
	// Assign values within the collection.
	treeSet.add(1);
	treeSet.add(5);
	treeSet.add(10);
	treeSet.add(15);
 
	// Sort the treeset using an iterator. Remember - it goes from Ascending Order!
	Iterator<Integer> i = treeSet.iterator();
 
	// We can display the information from the iterator using the hasNext method
	while (i.hasNext()) {
		System.out.print(i.next() + " ");
	}
 
	// If Else statement which uses the isEmpty method and the size methodjust as a simple check
	if (treeSet.isEmpty()) {
		System.out.print("EMPTY!! (This shouldn't ever been seen!).");
	} else {
		System.out.println("Total TreeSet size: " + treeSet.size());
	}
 
	//Also, another great demonstration to print out the first piece of data from tree set and the last, using the first and last methods!
	System.out.println("First piece: " + treeSet.first());
 	System.out.println("Last piece: " + treeSet.last());
 	
 	//Let's remove the last value from the TreeSet, or 15
 	treeSet.remove(tree.last());

	// sorts the Tree set in ascending order, as before mentioned
	i = treeSet.iterator();
 
	// Displaying the iteration using the next method
	while (i.hasNext()) {
		System.out.print(i.next() + " ");
	}
	//Print out the size of the iteration of the treeSet using the println and the size methods
	System.out.println();
	System.out.println("TreeSet Size:" + treeSet.size());
 
	// Clear everything out of the treeSet using the clear method, then using an if else statement to display the end result. This helps to handle the error if there is one.
	treeSet.clear();
	if (treeSet.isEmpty()) {
		System.out.print("It worked, & it's nice and clear!.");
	} else {
		System.out.println("You'll never see this! But if you do, the size is " + treeSet.size());
	}
   }
}

//TreeMap

//The TreeMap class implements the Map interface by using a tree. A TreeMap provides an efficient means of storing key/value pairs in sorted order, and allows rapid retrieval.

//You should note that,(PAY ATTENTION!) unlike a hash map, a tree map guarantees that its elements will be sorted in an ascending key order.
//Methods used within the TreeMap are - put, EntrySet and the Map constructor

import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

public class InvestigatorsTreeMap {

   public static void main(String args[]) {

      //Creating a TreeMap HashMap
      TreeMap<Integer, String> investigatorMap = new TreeMap<Integer, String>();

      //Adding investigator elements to the TreeMap
      investigatorMap.put(19, "Charlie Gannory");
      investigatorMap.put(71, "Alice Hoon");
      investigatorMap.put(11, "Jillian Smith");
      investigatorMap.put(62, "Dick Altan");
      investigatorMap.put(18, "Billy Charlie");

      // Grab the set of entries of Investigators
      Set set = investigatorMap.entrySet();

      //We can use an iterator to cycle through the entries of investigators
      Iterator inv = set.iterator();

      //Use a while loop to display the list of Investigators & Ages!
      while(inv.hasNext()) {
         Map.Entry splay = (Map.Entry)inv.next();
         //Print Values
         System.out.print("key is: "+ splay.getKey() + " & Value is: ");
         System.out.println(splay.getValue());
      }

   }
}

// HashSet Example - 

//HashSet extends AbstractSet and implements the Set interface. It creates a collection that uses a hash table for storage.
//A hash table stores information by using a mechanism called hashing. In hashing, the informational content of a key is used to determine a unique value, called its hash code.
//The hash code is then used as the index at which the data associated with the key is stored. The transformation of the key into its hash code is performed automatically.


//Methods we'll be using within the HashSet are the add, clear, isEmpty, remove, contains, and size.

import java.util.*;

public class HashExamplesVillagePeople {
 
    public static void main(String args[]) {
        // Create a brand spanking new set
        Set setPrecursor = new HashSet();

        // Throw in a couple elements into the PreCursor HashSet
        setPrecursor.add("Y");
        setPrecursor.add("M");
        setPrecursor.add("C");
        setPrecursor.add("A");
        // Print
        System.out.println("Precursor:" + setPrecursor);

// Also, we'll be expanding the HashSet Example to include an addition Java Collection - The Array List!
//ArrayList - The ArrayList class extends AbstractList and implements the List interface. ArrayList supports dynamic arrays that can grow as needed.
//Standard Java arrays are of a fixed length. After arrays are created, they cannot grow or shrink, which means that you must know in advance how many elements an array will hold.
//Array lists are created with an initial size. When this size is exceeded, the collection is automatically enlarged. When objects are removed, the array may be shrunk.

//SIMILAR METHODS USED IN THE HASHSET ARE USED WITHIN THE ARRAYLIST

		// Create a list and add some elements
        List myList = new ArrayList();

        myList.add("I");
        myList.add("T");
        myList.add("S");
        myList.add("F");
        myList.add("U");
        myList.add("N");

        // Now create a HashSet WHICH is equal to the previous ArrayList. They are usable in this variation.
        Set setPostcursor = new HashSet(myList);
        // Print elements
        System.out.println("list myList:" + myList);
        System.out.println("Postcursor:" + setPostcursor);
        // Print out Comparison
        System.out.println("Precursor compared with Postcursor:" + setPrecursor.equals(setPostcursor));
 
        // Removing a LITERAL element from setPostcursor
        setPostcursor.remove("Y");
        //Print out results using the contains() submethod - equals the effect is a comparison
        System.out.println("Postcursor: " + setPostcursor);
        System.out.println("Precursor compared with Postcursor:" + setPrecursor.equals(setPostcursor));

        // Print out both Hashes
        System.out.println("Precursor contains elements:" + setPrecursor.containsAll(myList));
        System.out.println("Postcursor contains elements:" + setPostcursor.containsAll(myList));

        // Clear out setPrecursor using the clear method - void clear() = Removes all of the elements from this list.
        setPrecursor.clear();
        //Print literal text and use the isEmpty method - isEmpty(): Returns true if this set contains no elements.
        System.out.println("Precursor is Empty?" + setPrecursor.isEmpty());

        // Print the sizes or the amount of elements contained within each of the 2 HashSets we created
        System.out.println("Precursor has:" + setPrecursor.size() + " Elements within");
        System.out.println("Postcursor has:" + setPostcursor.size() + " Elements within");

    }
}

// Hashmap

//The HashMap class uses a hashtable to implement the Map interface. This allows the execution time of basic operations, such as get( ) and put( ), to remain constant even for large sets.

//Using hashMap Methods - Put, clear, size, keySet, containsKey, & containsValue

import java.util.HashMap;
import java.util.Map;

public class BooksOfMormonHashMap {
	
	public static void main(String[] args) {
		Map booksOfMormon = new HashMap();
		
		// Add some vehicles, and an integer
		booksOfMormon.put("Tagalog", 57);
		booksOfMormon.put("Portugese", 15);
		booksOfMormon.put("German", 24);
		booksOfMormon.put("English", 100);
		//Print our size of number of Books of Mormon
		System.out.println("Total Books Of Mormon: "+booksOfMormon.size());

		//We use the string in order to best present what we are finding
		String language = "Portugese";
		if(booksOfMormon.containsKey(language))
		//Printout if it's found
			System.out.println("Found "+booksOfMormon.get(language)+" "+language+" Books Of Mormon!\n");

		//Or we can search by the number of, in this case, the most amount of books available, and abandon the string
		String numOfBom;
		if(booksOfMormon.containsValue(10))
		//Printout the string
			System.out.println("Found "+booksOfMormon.get(numOfBom)+" "+numOfBom+"English Books Of Mormon!\n");

		// All missionaries gave out all their books, so let's clear out the number of books available.
		booksOfMormon.clear();
		// Print out current value of HashMap
		System.out.println("Current amount of Books of Mormon: " + booksOfMormon.size()); 
	}
}
