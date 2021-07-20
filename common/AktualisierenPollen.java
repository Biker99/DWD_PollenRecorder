package DWD_PollenRecorder.common;

import DWD_PollenRecorder.gui.Settings;
import DWD_PollenRecorder.json.JSONLoadObjectPollen;
import DWD_PollenRecorder.json.JSON_DecodePollen;
import DWD_PollenRecorder.gui.PollenGUI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class AktualisierenPollen extends Thread {
    
    private static final int countdown = 60*60; // countdown in Seconds 
    private static int downcounter = countdown;
    private static int counter=0;
    
    private static URL urlPollen;
    private static String strPollen;
    private static JSON_DecodePollen completeJSONMessage = null;
    
    private static final String dateiname = "." + File.separator + "PollenSymptome_test3.dat";
    private static File datei = new File(dateiname);
    
    private static ArrayList<String> dateList = new ArrayList<String>();
    private static ArrayList<String> symptomList = new ArrayList<String>();
    private static ArrayList<String> pollenList = new ArrayList<String>();
    @SuppressWarnings("unused")
    private static String[] legendComplete;
    private static String[] legend;
    
    
    @SuppressWarnings("unused")
    public void run() {
	readfile();
	while (true) {		//endlosschleife
	    System.out.println("Pollen download counter: "+counter);
	    try {
		urlPollen = Settings.getURLPollen(); //https://opendata.dwd.de/climate_environment/health/alerts/s31fg.json
//		System.out.println("daten von URL laden");
		strPollen = new JSONLoadObjectPollen(urlPollen).getString();	//Laden der Daten vom https://opendata.dwd.de und als JSONObject ablegen
//		System.out.println("daten von URL geladen");
		
//		daten für heute dekodieren, completeJSONMessage anlegen
		completeJSONMessage = new JSON_DecodePollen(strPollen, 120, 121, "today");
		completeJSONMessage.decode();
		legendComplete = completeJSONMessage.getLevel1_Legend(); // Legende zur gesamten Information, die im String steckt
		legend = completeJSONMessage.getPollenLegend(); // Legende zum JSON String reduziert auf Pollenbelastung
		
		String[] messageCompleteToday = completeJSONMessage.getLevel1_Message(); // gesamte Information, die im String steckt
		String[] messageToday = completeJSONMessage.getPollenMessage();// JSON String reduziert auf Pollenbelastung heute

//		String für "Pollenbelastung heute" erstellen
		StringBuilder today = new StringBuilder();
		for (int i=0; i<messageToday.length; i++) {
		    today.append(legend[i]);
		    today.append(": ");
		    today.append(messageToday[i]);
		    today.append(";\n");
		};
		
//		String für "Pollenbelastung heute" zum speichern erstellen
		StringBuilder today4rec = new StringBuilder();
		for (int i=0; i<messageToday.length; i++) {
		    today4rec.append(messageToday[i]);
		    today4rec.append(";");
		};

//		daten für morgen dekodieren, completeJSONMessage anlegen		
		completeJSONMessage = new JSON_DecodePollen(strPollen, 120, 121, "tomorrow");
		completeJSONMessage.decode();
		String[] messageCompleteTomorrow = completeJSONMessage.getLevel1_Message(); // gesamte Information, die im String steckt
		String[] messageTomorrow = completeJSONMessage.getPollenMessage();

//		String für "Pollenbelastung morgen" erstellen		
		StringBuilder tomorrow = new StringBuilder();
		for (int i=0; i<messageTomorrow.length; i++) {
		    tomorrow.append(legend[i]);
		    tomorrow.append(": ");
		    tomorrow.append(messageTomorrow[i]);
		    tomorrow.append(";\n");
		};
		
//		Ausgabe der Daten für heute und Morgen im PollenGUI
//		datum des aktuellen Datensatzes beim DWD	
		PollenGUI.setLastUpdate(messageCompleteToday[2]); 
		
//		übergabe der Datenstrings zur Anzeige		
		PollenGUI.setPollenToday4rec(today4rec.toString());
		PollenGUI.setPollenToday(today.toString());
		PollenGUI.setPollenTomorrow(tomorrow.toString());

//		voraussichtliche Verfügbarkeit des nächsten Datensatzes beim DWD
		PollenGUI.setNextUpdate(messageCompleteToday[5]);
		counter++;
		
//		speichern, wenn aktuell übertragenes Datum neuer ist als letztes gespeichertes
		if (!messageCompleteToday[2].substring(0,10).contentEquals(PollenGUI.dateModel.lastElement())){
		    System.out.println(messageCompleteToday[2].substring(0,10));
		    System.out.println(PollenGUI.dateModel.lastElement());
		    System.out.println("ungleich");
		    PollenGUI.setCheckBox2AutoSave();
		    PollenGUI.setUebernehmen();
		    setSymptomeModelZerlegen();
		    setSave();
		} 	
	    } catch (Exception e1) {System.out.println("Sch...");} 
	    for (downcounter = countdown; downcounter >0; downcounter--) {  
		try {Thread.sleep(1000);} // Zählen in Sekunden Schritten
		catch (InterruptedException e) {}
	    }
	}
    }

//    manueller DWD Daten re-load
    public static void setPollenReload() {downcounter =0;}
    
    
 
//	datei öffnen und als symptomeModel zurückgeben
    private static void readfile() {		 
	String symptome;
	if (!datei.exists()) {
	    try {
		datei.createNewFile();
	    } catch (IOException ex) {
		ex.printStackTrace();
	    }
	} else {
	    try (BufferedReader in = new BufferedReader(new FileReader(datei))) {
		while ((symptome = in.readLine()) != null) {
//		    PollenGUI.symptomeModel.addElement(symptome);
		    PollenGUI.symptomeModel2.addElement(symptome);
		    PollenGUI.dateModel.addElement(symptome.substring(0,symptome.indexOf(";")));
		}
		in.close();
		setSymptomeModelZerlegen();
	    } catch (IOException ex) {
		ex.printStackTrace();
	    }
	}   
    }
    
    
//	gesamtes symptomeModel zerlegen und als getrennte ArrayLists zur Verarbeitung zurückgeben.
    public static void setSymptomeModelZerlegen() {		
	dateList.clear();
	symptomList.clear();
	pollenList.clear();
//	int modelSize = PollenGUI.symptomeModel.getSize();
	int modelSize = PollenGUI.symptomeModel2.getSize();
	for (int i=0; i<modelSize;i++) {
//	    String filterList = PollenGUI.symptomeModel.get(i);
	    String filterList = PollenGUI.symptomeModel2.get(i);
	    dateList.add(filterList.substring(0,filterList.indexOf(";")));
	    symptomList.add(filterList.substring(filterList.indexOf(";")+1,filterList.indexOf("/")));		    
	    pollenList.add(filterList.substring(filterList.indexOf("/") + 1,filterList.length()));
	}
    }
    
//	symptomeModel in datei speichern  
    public static void setSave() { 			
	try (BufferedWriter out = new BufferedWriter(new FileWriter(datei))) {
//	    for (int i = 0; i < PollenGUI.symptomeModel.getSize(); i++) {
	    for (int i = 0; i < PollenGUI.symptomeModel2.getSize(); i++) {
//		out.write(PollenGUI.symptomeModel.get(i).toString());
		out.write(PollenGUI.symptomeModel2.get(i).toString());
		out.newLine();
	    }
	    out.close();
	} catch (IOException ex) {
	    ex.printStackTrace();
	}
    }
 
  //	datum des selektierten Eintrags zurückgeben
    public static String getPollenSelectedDate(int listIndex) {			
	return dateList.get(listIndex);	
    }
 
//  //	Symptome des selektierten Eintrags zurückgeben
//    public static String getPollenSelectedSymptome(int listIndex) {		
//	return symptomList.get(listIndex);	
//    }
  
    
  //	Pollenbelastung des selektierten Eintrags zurückgeben
    public static String getPollenSelectedPollen(int listIndex) {		
	String zeile = pollenList.get(listIndex);;
	StringBuilder pollenSelected = new StringBuilder();
	for (int i=0; i<legend.length; i++) {
	    pollenSelected.append(legend[i]);
	    pollenSelected.append(": ");
	    pollenSelected.append(zeile.substring(0, zeile.indexOf(";")));
	    pollenSelected.append(";\n");
	    zeile = zeile.substring(zeile.indexOf(";") + 1,zeile.length());
	};
	return pollenSelected.toString();	
    }
}


