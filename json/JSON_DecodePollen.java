package DWD_PollenRecorder.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSON_DecodePollen {

    private String JSONString = null;
    private String[] pollen_message = new String[8];
    private String[] complete_message = new String[20];
    private String[] pollen_legend = new String[8];
    private String[] complete_legend = new String[20];
    private String[] level1_legend = new String[6];
    private String[] level1_str = new String[6];
    private String[] level2_legend = new String[5];
    private String[] level2_str = new String[5];
    
    private String[][] level1 = new String[2][6];
    private String[][] level2 = new String[2][5];
    private String[][] complete = new String[2][20];
    private String[][] pollen = new String[2][8];


    

    private JSONObject jsonObjLevel1;
    private JSONObject jsonObjLevel2;
    private JSONObject jsonObjLevel3;
    private JSONObject jsonObjLevel4;

    private JSONArray level1_str4_jar = new JSONArray();
    private Object[] level1_str4_ar;
    

   
    
    private static String selected_region_id;
//    @SuppressWarnings("unused")
//    private static String selected_partregion_id;
    private static String time = "today";
    
    private static boolean  region_id_selected = false;
    
    
    
	///////////////////////////////
	// constructors
	///////////////////////////////
	    
////    	Konstruktor mit JSONObject in der Übergabe. 
//	public JSON_DecodePollen(JSONObject js, String reg_id, String partReg_id){
//	    JSONString = String.valueOf(js);
//	    selected_region_id = reg_id;
////	    selected_partregion_id = partReg_id;
//	     
//	}
//	public JSON_DecodePollen(JSONObject js, int reg_id, int partReg_id){
//	    JSONString = String.valueOf(js);//.toString();
//	    selected_region_id = String.valueOf(reg_id);
////	    selected_partregion_id = String.valueOf(partReg_id);
//	}
	
//    	Konstruktor mit String in der Übergabe. 	
	public JSON_DecodePollen(String js, String reg_id, String partReg_id){
	    JSONString = js;
	    selected_region_id = reg_id;
//	    selected_partregion_id = partReg_id;
	}
	public JSON_DecodePollen(String js, int reg_id, int partReg_id){
	    JSONString = js;
	    selected_region_id = String.valueOf(reg_id);
//	    selected_partregion_id = String.valueOf(partReg_id);
	}
	
	public JSON_DecodePollen(String js, int reg_id, int partReg_id, String strtime){
	    JSONString = js;
	    selected_region_id = ""+reg_id;
//	    selected_partregion_id = ""+partReg_id;
	    time = strtime; 
	}

	
	///////////////////////////////
	// methods
	///////////////////////////////
	
	
	public void decode() throws ParseException{
	    getCompleteLegend();
	    getPollenLegend();	    
	    getCompleteLegend2();
	    getPollenLegend2();
	    

	    JSONParser parser = new JSONParser();
	    
//	    Object level 1:
//	    	sender: (String),
//	    	legend: {}
//	   	last_update: (String) , 
//	    	name: (String), 
//	    	content: []
//	    	next_update: (String)
	    
	    jsonObjLevel1 = (JSONObject)parser.parse(JSONString);
	    
	    for (int i=0; i<6; i++) {
		level1_str[i] = jsonObjLevel1.get(complete_legend[i]).toString();
		level1[1][i] = jsonObjLevel1.get(complete_legend[i]).toString();
	    }

	    level1_str4_jar = (JSONArray)parser.parse(level1_str[4]);		// JSONArray aus decoded string
	    level1_str4_ar = level1_str4_jar.toArray();
	    
	    
//	    Object level 2:
//	    	region_id: (String), 
//	    	partregion_id: (String), 
//	    	region_name: (String), 
//	    	partregion_name: (String),
//	    	Pollen {}
	   
	    
//	    Object level 2 nach der gewählten Region durchsuchen
	    region_id_selected = false;
	    for (int i=0; region_id_selected == false; i++) {
		jsonObjLevel2 = (JSONObject)parser.parse(level1_str4_ar[i].toString());		
		Object region_id = jsonObjLevel2.get("region_id");
		if (region_id.toString().contentEquals(selected_region_id) ) {
		    region_id_selected = true;	    
		}  
	    }
	    for (int i=0; i<5; i++) {
		level2_str[i] = jsonObjLevel2.get(complete_legend[i+6]).toString();
		level2[1][i] = jsonObjLevel2.get(complete_legend[i+6]).toString();
	    }
	    
//	    Object level 3: Pollenarten
//	    	Esche
//	    	Ambrosia
//	    	Hasel
//	    	Birke
//	    	Erle
//	    	Graeser
//	    	Beifuss
//	    	Roggen
	    
//	    Object level 4: Zeitraum
//	    	today: (String),
//	    	tomorrow: (String),
//	    	dayafter_to: (String)
	    
	    jsonObjLevel3 = (JSONObject)parser.parse(level2_str[4]); //level2_str[4] enthält die Information zu den Pollen
	    for (int i=0; i<pollen_message.length; i++) {
		jsonObjLevel4 = (JSONObject)parser.parse(jsonObjLevel3.get(pollen_legend[i]).toString());
		pollen_message[i] = jsonObjLevel4.get(time).toString();
		pollen[1][i] = jsonObjLevel4.get(time).toString();
		
	    }
//	    System.out.println("x================================================");
	  
	
//Ausgabe
//	    
//	    System.out.println("================================================");
//	    System.out.println("decode() - übergebene Werte:");
//	    System.out.println("JSONString: "+JSONString);
//	    System.out.println("selected_region_id: "+selected_region_id);
//	    System.out.println("selected_partregion_id: "+selected_partregion_id);
//	    System.out.println("Vorhersage: "+time);
//	    System.out.println("------------------------------------------------");
//	    
//	    System.out.println("last_update: "+level1_str[2]); //last_update
//	    System.out.println("next_update: "+level1_str[5]); //next_update
//	    System.out.println("------------------------------------------------");
//	    
//	    System.out.println("region_id: "+level2_str[0]);
//	    System.out.println("partregion_id: "+level2_str[1]);
//	    System.out.println("region_name: "+level2_str[2]);
//	    System.out.println("partregion_name: "+level2_str[3]);
//	    System.out.println("------------------------------------------------");
//	    
//	    for (int i=0; i<8;i++) {
//		System.out.println("----");
//		System.out.print(pollen_legend[i]+": ");
//		System.out.println(pollen_message[i]);
//	    }
//	    System.out.println("================================================"); 
	}
	
	
	    ///////////////////////////////
	    // getter
	    ///////////////////////////////
	
	public String[] getCompleteMessage() {
	  //level 1 message
	    complete_message[0] = level1_str[0];
	    complete_message[1] = level1_str[1];
	    complete_message[2] = level1_str[2];
	    complete_message[3] = level1_str[3];
	    complete_message[4] = level1_str[4];
	    complete_message[5] = level1_str[5];
	  //level 2 message
	    complete_message[6] = level2_str[0];
	    complete_message[7] = level2_str[1];
	    complete_message[8] = level2_str[2];
	    complete_message[9] = level2_str[3];
	    complete_message[10] = level2_str[4];
	  //level 3 message
	    complete_message[11] = pollen_message[0];
	    complete_message[12] = pollen_message[1];
	    complete_message[13] = pollen_message[2];
	    complete_message[14] = pollen_message[3];
	    complete_message[15] = pollen_message[4];
	    complete_message[16] = pollen_message[5];
	    complete_message[17] = pollen_message[6];
	    complete_message[18] = pollen_message[7];
	  //level 4 message
	    complete_message[19] = time;

	    return complete_message;
	}
	public String[] getCompleteLegend() {
	  //level 1 message
	    complete_legend[0] = "sender";
	    complete_legend[1] = "legend";
	    complete_legend[2] = "last_update";
	    complete_legend[3] = "name";
	    complete_legend[4] = "content";
	    complete_legend[5] = "next_update";
	  //level 2 message
	    complete_legend[6] = "region_id";
	    complete_legend[7] = "partregion_id";
	    complete_legend[8] = "region_name";
	    complete_legend[9] = "partregion_name";
	    complete_legend[10] = "Pollen"; 
	  //level 3 message
	    complete_legend[11] = "Esche";
	    complete_legend[12] = "Ambrosia";
	    complete_legend[13] = "Hasel";
	    complete_legend[14] = "Birke";
	    complete_legend[15] = "Erle";
	    complete_legend[16] = "Graeser";
	    complete_legend[17] = "Beifuss";
	    complete_legend[18] = "Roggen";
	  //level 4 message
	    complete_legend[19] = "Meldezeitraum";
	    return complete_legend;
	}
	
	public String[][] getCompleteMessage2() {
	  //level 1 message
	    complete[1][0] = level1_str[0];
	    complete[1][1] = level1_str[1];
	    complete[1][2] = level1_str[2];
	    complete[1][3] = level1_str[3];
	    complete[1][4] = level1_str[4];
	    complete[1][5] = level1_str[5];
	  //level 2 message
	    complete[1][6] = level2_str[0];
	    complete[1][7] = level2_str[1];
	    complete[1][8] = level2_str[2];
	    complete[1][9] = level2_str[3];
	    complete[1][10] = level2_str[4];
	  //level 3 message
	    complete[1][11] = pollen_message[0];
	    complete[1][12] = pollen_message[1];
	    complete[1][13] = pollen_message[2];
	    complete[1][14] = pollen_message[3];
	    complete[1][15] = pollen_message[4];
	    complete[1][16] = pollen_message[5];
	    complete[1][17] = pollen_message[6];
	    complete[1][18] = pollen_message[7];
	  //level 4 message
	    complete[1][19] = time;

	    return complete;
	}
	public String[][] getCompleteLegend2() {
	    //level 1 message
	    complete[0][0] = "sender";
	    complete[0][1] = "legend";
	    complete[0][2] = "last_update";
	    complete[0][3] = "name";
	    complete[0][4] = "content";
	    complete[0][5] = "next_update";
	    //level 2 message
	    complete[0][6] = "region_id";
	    complete[0][7] = "partregion_id";
	    complete[0][8] = "region_name";
	    complete[0][9] = "partregion_name";
	    complete[0][10] = "Pollen"; 
	    //level 3 message
	    complete[0][11] = "Esche";
	    complete[0][12] = "Ambrosia";
	    complete[0][13] = "Hasel";
	    complete[0][14] = "Birke";
	    complete[0][15] = "Erle";
	    complete[0][16] = "Graeser";
	    complete[0][17] = "Beifuss";
	    complete[0][18] = "Roggen";
	  //level 4 message
	    complete[0][19] = "Meldezeitraum";
	    return complete;
	}
	
	public String[] getPollenMessage() {
//	    Object level 3: Pollenarten
//	    	Esche
//	    	Ambrosia
//	    	Hasel
//	    	Birke
//	    	Erle
//	    	Graeser
//	    	Beifuss
//	    	Roggen
//	    String[] pollen_message_modified = new String[8];
	    for (int i=0; i<pollen_message.length; i++){
//		pollen_message_modified[i] = pollen_message[i];
		if (pollen_message[i].contentEquals("0-1")) {
		    pollen_message[i]="0,5";
		    pollen[1][i]="0,5";}
		else if (pollen_message[i].contentEquals("1-2")) {
		    pollen_message[i]="1,5";
		    pollen[1][i]="1,5";}
		else if (pollen_message[i].contentEquals("2-3")) {
		    pollen_message[i]="2,5";
		    pollen[1][i]="2,5";}
		else if (pollen_message[i].contentEquals("3-4")) {
		    pollen_message[i]="3,5";
		    pollen[1][i]="3,5";}
		else if (pollen_message[i].contentEquals("4-5")) {
		    pollen_message[i]="4,5";
		    pollen[1][i]="4,5";}
		else if (pollen_message[i].contentEquals("5-6")) {
		    pollen_message[i]="5,5";pollen[1][i]="5,5";}
		else {
		    pollen_message[i] = pollen_message[i];
//		    pollen[1][i] = pollen_message[i];
		    }
	    }   
	    return pollen_message;
	}

	
	public String[] getPollenLegend() {
	    pollen_legend[0] = "Esche";
	    pollen_legend[1] = "Ambrosia";
	    pollen_legend[2] = "Hasel";
	    pollen_legend[3] = "Birke";
	    pollen_legend[4] = "Erle";
	    pollen_legend[5] = "Graeser";
	    pollen_legend[6] = "Beifuss";
	    pollen_legend[7] = "Roggen";
	    return pollen_legend;
	}
	

	
	public String[][] getPollenLegend2() {
	    pollen[0][0] = "Esche";
	    pollen[0][1] = "Ambrosia";
	    pollen[0][2] = "Hasel";
	    pollen[0][3] = "Birke";
	    pollen[0][4] = "Erle";
	    pollen[0][5] = "Graeser";
	    pollen[0][6] = "Beifuss";
	    pollen[0][7] = "Roggen";
	    return pollen;
	}
	
	public String[] getLevel1_Message() {
//	    Object level 1:
//	    	sender: (String),
//	    	legend: {}
//	   	last_update: (String) , 
//	    	name: (String), 
//	    	content: []
//	    	next_update: (String)
	    return level1_str;
	}
	
	public String[] getLevel1_Legend() {
	    level1_legend[0] =  complete_legend[0];
	    level1_legend[1] =  complete_legend[1];
	    level1_legend[2] =  complete_legend[2];
	    level1_legend[3] =  complete_legend[3];
	    level1_legend[4] =  complete_legend[4];
	    level1_legend[5] =  complete_legend[5];
	    return level1_legend;
	}
	
	
	
	
	
	public String[] getLevel2_Message() {
//	    Object level 2:
//	    	region_id: (String), 
//	    	partregion_id: (String), 
//	    	region_name: (String), 
//	    	partregion_name: (String),
//	    	Pollen {}
	    return level2_str;
	}
	
	public String[] getLevel2_Legend() {
	    level2_legend[0] =  complete_legend[6];
	    level2_legend[1] =  complete_legend[7];
	    level2_legend[2] =  complete_legend[8];
	    level2_legend[3] =  complete_legend[9];
	    level2_legend[4] =  complete_legend[10];
	    return level2_legend;
	}
	

	

}
