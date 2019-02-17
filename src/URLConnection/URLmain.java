package URLConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Date;

public class URLmain {

    // input stream and string variables to read from later connections
    private static BufferedReader inputStream = null;
    private static String line = "";

    public static void simpleURL() {

        try {
            // set the target URL
            URL url = new URL("http://example.org");

            /* Open a connection to the URL above and
             * return an InputStream for reading from that connection */
            inputStream = new BufferedReader(new InputStreamReader(url.openStream()));

            // loop through the stream of information returned by the server
            while (line != null) {
                line = inputStream.readLine();
                System.out.println(line);
            }

            // close the stream
            inputStream.close();

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

    }

    public static void URLhttp() {

        try {
            // set the target URL
            URL url = new URL("http://example.org");

            // create a new connection object (and cast it in order to use methods unique to HttpURLConnection)
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // set the request method to GET
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Java Client; Mac OS");
            connection.setInstanceFollowRedirects(false);

            // display the response code
            int respCode = connection.getResponseCode();

            if (respCode != 200) {
                System.out.println("Response code: " +respCode
                                 + "Response message: "+connection.getResponseMessage());
            } else {
                System.out.println("\nInformation about URL " + connection.getURL()
                                 + "\nResponse code:\t\t" + respCode
                                 + "\nResponse message:\t" + connection.getResponseMessage()
                                 + "\nContent type:\t\t" + connection.getContentType()
                                 + "\nDate:\t\t\t\t" +new Date(connection.getDate())
                                 );
            }

            // close the connection
            connection.disconnect();

        } catch (IOException e) {
            System.out.println("IOException: Invalid Web Address -->" + e.getMessage());
        }

    }

    public static void URLhttpNotFound() {

        try {
            // set the target URL
            URL url = new URL("http://example.org/subpage.html");

            // create a new connection object (and cast it in order to use methods unique to HttpURLConnection)
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // set the connection properties
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Java Client; Mac OS");
            connection.setInstanceFollowRedirects(false);

            // start the connection
            connection.connect();

            // retrieve the response code
            int respCode = connection.getResponseCode();

            // check the response code and http status
            if (respCode == 404 ||  connection.HTTP_NOT_FOUND == 404) {
                System.out.println("\nThe specific content " + connection.getURL() + " you're looking for was not found"
                                 + "\nResponse code: " + respCode
                                 + "\nResponse message: " + connection.getResponseMessage());
            } else {
                System.out.println("\nInformation about URL " + connection.getURL()
                                + "\nResponse code:\t\t" + respCode
                                + "\nResponse message:\t" + connection.getResponseMessage()
                                + "\nContent type:\t\t" + connection.getContentType()
                                + "\nDate:\t\t\t\t" +new Date(connection.getDate())
                                );
            }

            // disconnect session
            connection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.getMessage();
        } 
    }
}
