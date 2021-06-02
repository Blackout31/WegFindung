package Test;
/*
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
JSONParser parser = new JSONParser();

try {
	Object obj = parser.parse(new FileReader("Passwort.json"));
	JSONObject jsonObject= (JSONObject) obj;
	
//	JSONArray xWert = (JSONArray) jsonObject.get("x");
//	Iterator<String> xWand = xWert.iterator();
//	
//	JSONArray yWert = (JSONArray) jsonObject.get("y");
//	Iterator<String> yWand = yWert.iterator();
	
    JSONArray employeeList = (JSONArray) obj;
	
//	while(xWand.hasNext()) {
//
//		Integer xiWand = Integer.valueOf(xWand.next());
//		Integer yiWand = Integer.valueOf(yWand.next());
//
// 		System.out.println(xiWand);
//		System.out.println(yiWand);
//		
//	}
	
//	Node newBorder = new Node(xBorder, yBorder);
//	pathfinding.addBorder(newBorder);
    employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
}
catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
} catch (ParseException e) {
    e.printStackTrace();
}
}*/

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
         
        try (FileReader reader = new FileReader("employees2.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);
             
            //Iterate over employee array
            employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        try (FileReader reader = new FileReader("employees2.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);
             
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
	        long xWand = (long) employeeObject.get("x");    
	        System.out.println(xWand);
	         
	        //Get employee last name
	        long yWand = (long) employeeObject.get("y");  
	        System.out.println(yWand);
	         
	    }
	}