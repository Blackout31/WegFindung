/*package JA;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class ReadJSONExample 
{
    @SuppressWarnings("unchecked")
    public static void main(String[] args) 
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("passwort.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);
            
//            for(int i = 0; i < (employeeList).indexOf(obj); i++) {
//            	System.out.println(employeeList);
//            	i = i + 1;
//            };
             
            //Iterate over employee array
           employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
 
    private static void parseEmployeeObject(JSONObject employee) 
    {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("employee");
         
        //Get employee first name
        String firstName = (String) employeeObject.get("AdminPasswort");    
        System.out.println(firstName);
         
        //Get employee last name
        String lastName = (String) employeeObject.get("MitarbeiterPasswort");  
        System.out.println(lastName);
         
        //Get employee website name
        String website = (String) employeeObject.get("passwort");    
        System.out.println(website);
    }
}*/
/*package JA;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class ReadJSONExample 
{
    @SuppressWarnings("unchecked")
    public static void main(String[] args) 
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("Passwort.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
//            JSONArray employeeList = (JSONArray) obj;
//            System.out.println(employeeList);
             
            //Iterate over employee array
            employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
 
    private static void parseEmployeeObject(JSONObject employee) 
    {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("x");
         
        //Get employee first name
//        String firstName = (String) employeeObject.get("firstName");    
//        System.out.println(firstName);
         
        //Get employee last name
//        String lastName = (String) employeeObject.get("lastName");  
//        System.out.println(lastName);
         
        //Get employee website name
//        String website = (String) employeeObject.get("website");    
//        System.out.println(website);
    }
}*/
package JA;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSONExample{
	public static void main(String[] args) {
		/*JSONParser parser = new JSONParser();
		
		try {
			Object obj = parser.parse(new FileReader("Passwort.json"));
			JSONObject jsonObject= (JSONObject) obj;
			
			JSONArray xWert = (JSONArray) jsonObject.get("x");
			Iterator<String> xWand = xWert.iterator();
			
			JSONArray yWert = (JSONArray) jsonObject.get("y");
			Iterator<String> yWand = yWert.iterator();
			
			while(xWand.hasNext()) {
				System.out.println(xWand.next());
				System.out.println(yWand.next());
			}
			
		}
		catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
}*/

JSONParser parser = new JSONParser();

try {
	Object obj = parser.parse(new FileReader("Passwort.json"));
	JSONObject jsonObject= (JSONObject) obj;
	
	JSONArray xWert = (JSONArray) jsonObject.get("x");
	Iterator<String> xWand = xWert.iterator();
	
	JSONArray yWert = (JSONArray) jsonObject.get("y");
	Iterator<String> yWand = yWert.iterator();
	
	while(xWand.hasNext()) {
		System.out.println(xWand.next());
		System.out.println(yWand.next());

//		xiWand = Integer.valueOf(xWand.next());
//		yiWand = Integer.valueOf(yWand.next());
		
	}
	
}
catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
} catch (ParseException e) {
    e.printStackTrace();
}
}
}
