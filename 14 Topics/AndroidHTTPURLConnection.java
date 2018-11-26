//AndroidHTTPURLConnection

//A URLConnection with support for HTTP-specific features. See the spec for details. Each HttpURLConnection instance is used to make a single request but the underlying network connection to the HTTP server may be transparently shared by other instances. 

//Calling the close() methods on the InputStream or OutputStream of an HttpURLConnection after a request may free network resources associated with this instance but has no effect on any shared persistent connection. Calling the disconnect() method may close the underlying socket if a persistent connection is otherwise idle at that time.


// Some but not all of the Methods we'll use are the getURLContents, URLconnection, close, and open connection amongst others.

import java.net.*;
import java.io.*;

public class EasyPeezyHttpURL {

        //Here we're just using the throws IOException because there are two rules found on stackoverflow! - If you call a method that can throw an exception, though, you're required to either Catch it, or Declare that you're going to rethrow it.
        public static void main(String[] args) throws IOException {

        // This is the url that the program will connect to using the getUrlContents Method.
        String spitOut = getUrlContents("https://www.byui.edu");
        //This is the actual output. It will print out the html file for the url provided above.
        System.out.println(spitOut);

        //Alternatively we can go this route

        // Pull in a new URL and make a new URL constructor associated with the URL
        URL googz = new URL("https://www.google.com");
        //Open up a connection with the constructor URL
        URLConnection chiggityCheck = googz.openConnection();
        
        //Pull in the URL into the buffered reader constructor, and put it into the inputstream method
        BufferedReader suck = new BufferedReader(new InputStreamReader(chiggityCheck.getInputStream()));
        String suckConlusion;
        
        //As long as the suck bufferedReader constructor is not null, it will continue to "Suck" in the contents!
        while ((suckConlusion = suck.readLine()) != null) 
        System.out.println(suckConlusion);

        //Close up the buffered reader constructor when finished!
        suck.close();
    }
}

