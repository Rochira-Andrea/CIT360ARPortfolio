package JSON;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONmain {

    // create the object mapper and set it to ignore null fields globally
    private static ObjectMapper mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

    // initialize a null String to use for printing
    static String listOfContacts = null;

    public static void JavaToJSON(){

        // create Java object for later parsing
        Address addrContactOne = new Address("354 Frye Road","Gilbert","AZ",85226);
        Address addrContactTwo = new Address("354 Frye Road","Gilbert","AZ",85226);
        Address addrContactThree = new Address("354 Frye Road","Gilbert","AZ",85226);

        Contact contactOne = new Contact("Andrea",null,"Rochira","BYU student",'M',1982,"roc16012@byui.edu","(480) 220-0000",addrContactOne);
        Contact contactTwo = new Contact("Melissa",null,"Rodriguez","Professor",'F',1985,"mielrod@yahoo.com","(480) 220-0001",addrContactTwo);
        Contact contactThree = new Contact("Marco","Tullio","Rochira","Baby",'M',2018,null,null,addrContactThree);

        // create a list to serialize
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(contactOne);
        contacts.add(contactTwo);
        contacts.add(contactThree);

        // create the object mapper and set it to ignore null fields globally
        ObjectMapper mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

        // prepare the string to pretty print to console
        try {
            listOfContacts = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(contacts);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println("\nPretty printed list of contacts in JSON format\n"
                            + listOfContacts
                            + "\n------ End of serialization -----\n");
    }


    public static void JSONtoJava(){

        // JASON array
        String jasonArray = "[{\"firstName\":\"Ruben\",\"middleName\":\"Oscar\",\"lastName\":\"Saldana\",\"title\":\"Mr\",\"gender\":\"M\",\"birthYear\":1956,\"email\":null,\"phone\":\"(480) 220-0003\",\"address\":{\"street\":\"654 Del Rio street\",\"city\":\"Chandler\",\"state\":\"AZ\",\n" +
                "  \"zipCode\":85225}},{\"firstName\":\"Nora\",\"middleName\":null,\"lastName\":\"Saldana\",\"title\":\"Mrs\",\"gender\":\"F\",\"birthYear\":1958,\"email\":null,\"phone\":\"(480) 220-0004\",\"address\":{\"street\":\"654 Del Rio street\",\"city\":\"Chandler\",\"state\":\"AZ\",\n" +
                "  \"zipCode\":85225}}]";

        List<Contact> list = new ArrayList<>();

        // read JSON array of contacts from String
        try {
            list = mapper.readValue(jasonArray,new TypeReference<ArrayList<Contact>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nList of Java objects created\n");
        for(Contact c : list){
            System.out.println("Contact name: "+c.getFirstName()+" "+c.getLastName()+"\n"+
                               "Contact phone: "+c.getPhone()+"\n"+
                               "Contact address: "+c.getAddress().getStreet()+"\n"
                                                  +c.getAddress().getZipCode()+", "
                                                  +c.getAddress().getCity()+", "
                                                  +c.getAddress().getState()+"\n");
        }
        System.out.println("\n------ End of serialization -----\n");
    }

}
