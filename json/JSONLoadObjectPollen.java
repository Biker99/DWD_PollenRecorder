
package pollen.json;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JSONLoadObjectPollen{ 
  
    private String arrayAsString;
    private Scanner stream;
    private InputStream IOStream;


    ///////////////////////////////
    // constructors
    ///////////////////////////////

    public JSONLoadObjectPollen(URL URLPath) throws IOException{
	try {
	    if (true) { //Settings.getChckbxOnlineUpdatePollen()== "true") {
		try {
		    IOStream = URLPath.openStream();
	     	}catch (Exception e) {
	     	    System.out.println("loadFromURL - IOE Lost Internet connection!"); 
	     	    IOStream = URLPath.openStream(); 
		    System.out.println("loadFromURL - IOE passt wieder!");
	        }
		stream = new Scanner(IOStream);
		arrayAsString = stream.nextLine();
		stream.close();
	    };
     	}catch (Exception e) {
     	    System.out.println("loadFromURL - Lost Internet connection!"); 
     	    arrayAsString = loadMasterstring(); 
        }
    }
    

    public JSONLoadObjectPollen() throws IOException{
     	    arrayAsString = loadMasterstring(); 
    }
    
    
    ///////////////////////////////
    // methods
    ///////////////////////////////
    
    private String loadMasterstring() { 
	System.out.println("loadMasterstring - Kein Zugriff auf gespeicherte Daten");
	
	String ms = "{"
		+ "\"name\":\"Pollenflug-Gefahrenindex für Deutschland ausgegeben vom Deutschen Wetterdienst\","
		+ "\"last_update\":\"JJJJ-MM-DD 11:00 Uhr\","
		+ "\"next_update\":\"JJJJ-MM-DD 11:00 Uhr\","
		+ "\"sender\":\"Deutscher Wetterdienst - Medizin-Meteorologie\","
		+ "\"content\":[{"
		+ 	"\"region_id\":120,"
		+ 	"\"region_name\":\"Bayern\","		
		+ 	"\"partregion_id\":121,"		
		+ 	"\"partregion_name\":\"Allgäu/Oberbayern/Bay. Wald\","
		+ 	"\"Pollen\":{"
		+ 		"\"Birke\":{\"tomorrow\":\"2\",\"dayafter_to\":\"-1\",\"today\":\"2\"},"
		+		"\"Graeser\":{\"dayafter_to\":\"-1\",\"tomorrow\":\"0\",\"today\":\"0\"},"
		+ 		"\"Ambrosia\":{\"today\":\"0\",\"dayafter_to\":\"-1\",\"tomorrow\":\"0\"},"
		+ 		"\"Esche\":{\"today\":\"1-2\",\"tomorrow\":\"1-2\",\"dayafter_to\":\"-1\"},"
		+ 		"\"Hasel\":{\"today\":\"0\",\"dayafter_to\":\"-1\",\"tomorrow\":\"0\"},"
		+ 		"\"Roggen\":{\"tomorrow\":\"0\",\"dayafter_to\":\"-1\",\"today\":\"0\"},"
		+ 		"\"Beifuss\":{\"today\":\"0\",\"tomorrow\":\"0\",\"dayafter_to\":\"-1\"},"
		+ 		"\"Erle\":{\"today\":\"0\",\"dayafter_to\":\"-1\",\"tomorrow\":\"0\"}}}],"
		+ "\"legend\":{"
		+ 	"\"id1\":\"0\","		
		+ 	"\"id1_desc\":\"keine Belastung\","
		+ 	"\"id2\":\"0-1\","
		+ 	"\"id2_desc\":\"keine bis geringe Belastung\","
		+ 	"\"id3\":\"1\","
		+ 	"\"id3_desc\":\"geringe Belastung\","
		+ 	"\"id4\":\"1-2\","
		+ 	"\"id4_desc\":\"geringe bis mittlere Belastung\","
		+ 	"\"id5\":\"2\","
		+ 	"\"id5_desc\":\"mittlere Belastung\","
		+ 	"\"id6\":\"2-3\","
		+ 	"\"id6_desc\":\"mittlere bis hohe Belastung\","
		+ 	"\"id7\":\"3\","
		+ 	"\"id7_desc\":\"hohe Belastung\"}}";
		
		return ms;
    }
    
    ///////////////////////////////
    // getter
    ///////////////////////////////
    

    public JSONObject getJSObj() {
	JSONObject jo;
	JSONParser parser = new JSONParser();
	try {
	    jo = (JSONObject) parser.parse(arrayAsString);  
	}catch(Exception p){
	    System.out.println("getJSObj - parserfehler"); 
	    return jo=null;
	}
	return jo;
    } 
   
    
    
    public String getString() {
	return arrayAsString;
    }  
}
