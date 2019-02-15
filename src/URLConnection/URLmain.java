package URLConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

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

            // open the connection (and cast it in order to use methods unique to HttpURLConnection)
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // set the request method to GET
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Safari");
            connection.setInstanceFollowRedirects(false);

            // display the response code
            int respCode = connection.getResponseCode();
            System.out.println("\nInformation about URL " + connection.getURL()
                    + "\nResponse code: " + respCode
                    + "\nResponse message: " + connection.getResponseMessage());

            if (respCode != 200) {
                System.out.println("Response code is " + respCode + " --> your content cannot be retrieved");
            }

            // close the connection
            connection.disconnect();

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

    }

    public static void URLhttpNotFound() {

        try {
            // set the target URL
            URL url = new URL("http://example.org/subpage.html");

            // open the connection (and cast it in order to use methods unique to HttpURLConnection)
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // set the request method to GET
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Safari/12.0");
            connection.setInstanceFollowRedirects(false);

            // display the response code
            int respCode = connection.getResponseCode();

            if (connection.HTTP_NO_CONTENT == 204) {
                System.out.println("\nThe specific content " + connection.getURL() + " you're looking for cannot be retrieved"
                        + "\nResponse code: " + respCode
                        + "\nResponse message: " + connection.getResponseMessage());
            } else {
                System.out.println("\nInformation about URL " + connection.getURL()
                        + "\nResponse code: " + respCode
                        + "\nResponse message: " + connection.getResponseMessage());
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
