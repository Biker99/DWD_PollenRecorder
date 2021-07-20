package DWD_PollenRecorder.gui;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.ComponentOrientation;
import java.awt.Color;
import javax.swing.border.BevelBorder;


public class Settings extends JDialog {
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private static JTextField tfPathSettings;
    private static JTextField tfSettings;
    private static JButton btnClose;
    private static JButton btnSave;
    private static JCheckBox chckbxOnlineUpdatePollen;
    private static JCheckBox chckbxDefaultJsonPollen;

    private static String[] argumente = new String [23]; 
    
    private static JTextField tfPathPollen;
    private static JTextField tfUpdateRatePollen;

     


    public Settings() {
	setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	setModal(true);
	
    	setTitle("Bodensee Wettermelder - Settings");
//    	setIconImage(Toolkit.getDefaultToolkit().getImage(Settings.class.getResource("/pollen/ressources/favicon.png")));
	setBounds(100, 100, 846, 654);
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	
	JLabel lblSettings = new JLabel("Settings");
	lblSettings.setFont(new Font("Tahoma", Font.BOLD, 12));
	
	
	JLabel lblEinstellungenSpeichern = new JLabel("Einstellungen speichern");
	tfPathSettings = new JTextField();
	tfPathSettings.setEnabled(true);
	tfPathSettings.setEditable(false);
	tfPathSettings.setText("settings");
	tfPathSettings.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	tfPathSettings.setBackground(Color.WHITE);
	tfPathSettings.setColumns(10);
	tfSettings = new JTextField();
	tfSettings.setEditable(false);
	tfSettings.setText("settings.dat");
	tfSettings.setColumns(10);
	
	JLabel lblPathPollen = new JLabel("Internet Adresse des Pollen JSON file");
	
	tfPathPollen = new JTextField();
	tfPathPollen.setText("https://opendata.dwd.de/climate_environment/health/alerts/");
	tfPathPollen.setEditable(false);
	tfPathPollen.setColumns(10);
	
	chckbxOnlineUpdatePollen = new JCheckBox("soll das JSON File aktuell sein? (online update)");
	chckbxOnlineUpdatePollen.setSelected(true);
	
	chckbxDefaultJsonPollen = new JCheckBox("DefaultJSON");
	
	JLabel lblUpdateRatePollen = new JLabel("download rate - Pollen");
	
	tfUpdateRatePollen = new JTextField();
	tfUpdateRatePollen.setText("3600");
	tfUpdateRatePollen.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	tfUpdateRatePollen.setColumns(10);
	tfUpdateRatePollen.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	tfUpdateRatePollen.setBackground(Color.WHITE);
	
	JLabel lblSekundenupdateratePollen = new JLabel("Sekunden (UpdateRate Pollen: 1x /Tag)");
	
	btnSave = new JButton("Save");
	btnSave.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		saveArguments(getPathSettings(), getNameSettings());
	    }
	});
	
	btnClose = new JButton("Close");
	btnClose.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		saveArguments(getPathSettings(), getNameSettings());
		dispose();
	    }
	});
	

	

	

	
		
	GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
	gl_contentPanel.setHorizontalGroup(
		gl_contentPanel.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPanel.createSequentialGroup()
				.addContainerGap()
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblSettings, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(450, Short.MAX_VALUE))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
									.addComponent(tfPathSettings, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
									.addComponent(tfSettings, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
									.addComponent(lblEinstellungenSpeichern, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE))
								.addGap(17)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(tfPathPollen, GroupLayout.PREFERRED_SIZE, 501, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPathPollen, GroupLayout.PREFERRED_SIZE, 501, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(chckbxOnlineUpdatePollen, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
									.addGap(2)
									.addComponent(chckbxDefaultJsonPollen, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblUpdateRatePollen, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
									.addGap(95)
									.addComponent(tfUpdateRatePollen, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(lblSekundenupdateratePollen, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)))
							.addGap(100))
						.addComponent(btnClose, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
					.addComponent(btnSave, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)))
	);
	gl_contentPanel.setVerticalGroup(
		gl_contentPanel.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPanel.createSequentialGroup()
				.addContainerGap()
				.addComponent(lblSettings)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(lblPathPollen)
				.addGap(1)
				.addComponent(tfPathPollen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addComponent(chckbxOnlineUpdatePollen)
					.addComponent(chckbxDefaultJsonPollen))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(1)
						.addComponent(lblUpdateRatePollen))
					.addComponent(tfUpdateRatePollen, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(1)
						.addComponent(lblSekundenupdateratePollen)))
				.addGap(46)
				.addComponent(lblEinstellungenSpeichern)
				.addGap(4)
				.addComponent(tfPathSettings, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(tfSettings, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
				.addComponent(btnSave)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(btnClose)
				.addContainerGap())
	);
	contentPanel.setLayout(gl_contentPanel);	
	
	GroupLayout groupLayout = new GroupLayout(getContentPane());
	groupLayout.setHorizontalGroup(
		groupLayout.createParallelGroup(Alignment.TRAILING)
			.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
				.addGap(12))
	);
	groupLayout.setVerticalGroup(
		groupLayout.createParallelGroup(Alignment.TRAILING)
			.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
				.addGap(8))
	);
	getContentPane().setLayout(groupLayout);
    }
      
    
    ///////////////////////////////////////
    // getter 
    ///////////////////////////////////////

    
    public static int getUpdateRatePollenms() { // Integer wert zur Berechnung (in ms)
	int time;
	String rate = tfUpdateRatePollen.getText();
	if (rate.isEmpty()) {
	    time = 5000;
	}else {
	    time = Integer.parseInt(rate)*1000;
	    if (time<5000) time=5000;
	}
 	return time;
     }
    
    
    public static  String getChckbxOnlineUpdatePollen() {
	if( chckbxOnlineUpdatePollen.isSelected()) return "true";
	else return "false";
    } 
    

    public static URL getURLPollen() {
	URL Path = null;
	try {
	    String tf = "https://opendata.dwd.de/climate_environment/health/alerts/s31fg.json"; //tfPathPollen.getText();
	    Path = new URL(tf);
	} catch (MalformedURLException e) {
	    e.printStackTrace();
	}
        return Path;
    }
     
    public static String getPathSettings() {
	String path = "." + File.separator + tfPathSettings.getText() + File.separator;
 	return path;
     }
    
    
    public static File getNameSettings() {
	File file = new File (tfSettings.getText());
	return file;
    }
    
      
    
    ///////////////////////////////////////
    // Setter 
    ///////////////////////////////////////


    
    public static void setUpdateRatePollen(String rate) {
        tfUpdateRatePollen.setText(rate);
    }
    
 
    public static void saveArguments(String dir, File datei) {

	BufferedWriter out = null;
        File directory = new File(dir); 
        if (!directory.exists()) {
            if (directory.mkdirs()) 
                System.out.println("Multiple directories are created!");
            else 
                System.out.println("Failed to create multiple directories!");
        }
	try {
	    out = new BufferedWriter(new FileWriter(new File(dir + datei)));  
	    for (int i = 0; i < argumente.length; i++) {
		out.write(argumente[i]);
		out.newLine();
	    }
	} catch (IOException ex) {
	    ex.printStackTrace();
	    JOptionPane.showMessageDialog(null,"Fehler beim Speichern der Settings");
	} finally {
	    if (out != null) {
		try {
		    out.close();
		    System.out.println("out-closed");
		} catch (IOException ex) {
		    ex.printStackTrace();
		    JOptionPane.showMessageDialog(null,"Fehler beim Speichern der Settings");
		}
	    }
	}
    }
}

