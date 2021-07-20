package DWD_PollenRecorder.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.EventQueue;

import DWD_PollenRecorder.common.AktualisierenPollen;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PollenGUI extends JFrame {
    private static final long serialVersionUID = 6879979648016135699L;
   
    public static DefaultListModel<String> symptomeModel2;
    public static DefaultListModel<String> dateModel;
    
    private static int lastIndex;


    private static String lastUpdate;
    private static String pollenToday4rec;
    private static JTextPane tpPollenToday;
    private static JTextPane tpPollenTomorrow;
    private static JButton btnBearbeiten;
    private static JButton btnBearbeitenSave;
    private static JButton btnLoeschen;
    private static JButton btnUebernehmen;
    private static JButton btnGetDWD_Data;
    private static JButton btnAbbrechen;
    private static JButton btnSave;
    
    private static JLabel lblLastUpdate;
    private static JLabel lblNextUpdate;
    private static JPanel contentPane;
    private static JList<String> lstDateList;
    private static JTextField tfSymptome01;
    private static JTextField tfSymptome02;
    private static JTextField tfSymptome03;
    private static JTextField tfSymptome04;
    private static JTextField tfSymptome05;
    private static JTextField tfSymptome06;
    private static JTextField tfSymptome07;
    private static JTextField tfSymptome08;
    private static JTextField tfSymptome09;
    private static JTextField tfSymptome10;
    private JLabel lblSavedData;
//    private static JList<String> lstSymptomeList;


    
	///////////////////////////////////////////////////////
	// Launch the application.
	////////////////////////////////////////////////////// 
   
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    PollenGUI frame = new PollenGUI();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		    JOptionPane.showMessageDialog(null,"main-run - Fehler \n"+e.getMessage());
		}
       
		AktualisierenPollen aktualisierenPollen = new AktualisierenPollen();	//thread zum automatischen update und countdown anzeigen
		aktualisierenPollen.start();
	    }
	});
    }


	///////////////////////////////////////////////////////
	// Create the frame.
	////////////////////////////////////////////////////// 

    public PollenGUI() throws Exception {	
	setTitle("Pollenspeicher");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 791, 712);
	contentPane = new JPanel();
	contentPane.setToolTipText("dvb");
	contentPane.setLayout(null);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));	
	setContentPane(contentPane);
	
	tfSymptome01 = new JTextField();
	tfSymptome01.setMaximumSize(new Dimension(20, 20));
	tfSymptome01.setHorizontalAlignment(SwingConstants.CENTER);
	tfSymptome01.setAutoscrolls(false);
	tfSymptome01.setText("-1");
	tfSymptome01.setBounds(195, 116, 18, 18);
	tfSymptome01.setColumns(1);
	tfSymptome01.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			tfSymptome02.requestFocus();
			tfSymptome02.selectAll();
		    }
		}
	});
	
	tfSymptome02 = new JTextField();
	tfSymptome02.setText("-1");
	tfSymptome02.setMaximumSize(new Dimension(20, 20));
	tfSymptome02.setHorizontalAlignment(SwingConstants.CENTER);
	tfSymptome02.setColumns(1);
	tfSymptome02.setAutoscrolls(false);
	tfSymptome02.setBounds(195, 134, 18, 18);
	tfSymptome02.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			tfSymptome03.requestFocus();
			tfSymptome03.selectAll();
		    }
		}
	});

	
	tfSymptome03 = new JTextField();
	tfSymptome03.setText("-1");
	tfSymptome03.setMaximumSize(new Dimension(20, 20));
	tfSymptome03.setHorizontalAlignment(SwingConstants.CENTER);
	tfSymptome03.setColumns(1);
	tfSymptome03.setAutoscrolls(false);
	tfSymptome03.setBounds(195, 152, 18, 18);
	tfSymptome03.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			tfSymptome04.requestFocus();
			tfSymptome04.selectAll();
		    }
		}
	});
	
	tfSymptome04 = new JTextField();
	tfSymptome04.setText("-1");
	tfSymptome04.setMaximumSize(new Dimension(20, 20));
	tfSymptome04.setHorizontalAlignment(SwingConstants.CENTER);
	tfSymptome04.setColumns(1);
	tfSymptome04.setAutoscrolls(false);
	tfSymptome04.setBounds(195, 170, 18, 18);
	tfSymptome04.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			tfSymptome05.requestFocus();
			tfSymptome05.selectAll();
		    }
		}
	});

	
	tfSymptome05 = new JTextField();
	tfSymptome05.setText("-1");
	tfSymptome05.setMaximumSize(new Dimension(20, 20));
	tfSymptome05.setHorizontalAlignment(SwingConstants.CENTER);
	tfSymptome05.setColumns(1);
	tfSymptome05.setAutoscrolls(false);
	tfSymptome05.setBounds(195, 188, 18, 18);
	tfSymptome05.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			tfSymptome06.requestFocus();
			tfSymptome06.selectAll();
		    }
		}
	});
	
	tfSymptome06 = new JTextField();
	tfSymptome06.setText("-1");
	tfSymptome06.setMaximumSize(new Dimension(20, 20));
	tfSymptome06.setHorizontalAlignment(SwingConstants.CENTER);
	tfSymptome06.setColumns(1);
	tfSymptome06.setAutoscrolls(false);
	tfSymptome06.setBounds(195, 206, 18, 18);
	tfSymptome06.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			tfSymptome07.requestFocus();
			tfSymptome07.selectAll();
		    }
		}
	});
	
	tfSymptome07 = new JTextField();
	tfSymptome07.setText("-1");
	tfSymptome07.setMaximumSize(new Dimension(20, 20));
	tfSymptome07.setHorizontalAlignment(SwingConstants.CENTER);
	tfSymptome07.setColumns(1);
	tfSymptome07.setAutoscrolls(false);
	tfSymptome07.setBounds(195, 224, 18, 18);
	tfSymptome07.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			tfSymptome08.requestFocus();
			tfSymptome08.selectAll();
		    }
		}
	});
	
	tfSymptome08 = new JTextField();
	tfSymptome08.setText("-1");
	tfSymptome08.setMaximumSize(new Dimension(20, 20));
	tfSymptome08.setHorizontalAlignment(SwingConstants.CENTER);
	tfSymptome08.setColumns(1);
	tfSymptome08.setAutoscrolls(false);
	tfSymptome08.setBounds(195, 242, 18, 18);
	tfSymptome08.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			tfSymptome09.requestFocus();
			tfSymptome09.selectAll();
		    }
		}
	});
	
	tfSymptome09 = new JTextField();
	tfSymptome09.setText("-1");
	tfSymptome09.setMaximumSize(new Dimension(20, 20));
	tfSymptome09.setHorizontalAlignment(SwingConstants.CENTER);
	tfSymptome09.setColumns(1);
	tfSymptome09.setAutoscrolls(false);
	tfSymptome09.setBounds(195, 260, 18, 18);
	tfSymptome09.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			btnBearbeitenSave.requestFocus();
		    }
		}
	});
	
	tfSymptome10 = new JTextField();
	tfSymptome10.setEnabled(false);
	tfSymptome10.setEditable(false);
	tfSymptome10.setText("auto");
	tfSymptome10.setMaximumSize(new Dimension(20, 20));
	tfSymptome10.setHorizontalAlignment(SwingConstants.CENTER);
	tfSymptome10.setColumns(1);
	tfSymptome10.setAutoscrolls(false);
	tfSymptome10.setBounds(195, 278, 35, 18);


	
	JLabel lblSymptome01 = new JLabel("Schnupfen");
	lblSymptome01.setBounds(251, 116, 132, 14);
	
	JLabel lblSymptome02 = new JLabel("Nasenkitzel");
	lblSymptome02.setBounds(251, 134, 132, 14);
	
	JLabel lblSymptome03 = new JLabel("tränende Augen");
	lblSymptome03.setBounds(251, 152, 132, 14);
	
	JLabel lblSymptome04 = new JLabel("geschwollene Augen");
	lblSymptome04.setBounds(251, 170, 132, 14);
	
	JLabel lblSymptome05 = new JLabel("Halsweh");
	lblSymptome05.setBounds(251, 188, 132, 14);
	
	JLabel lblSymptome06 = new JLabel("belegter Hals");
	lblSymptome06.setBounds(251, 206, 132, 14);
	
	JLabel lblSymptome07 = new JLabel("Lunge");
	lblSymptome07.setBounds(251, 224, 132, 14);
	
	JLabel lblSymptome08 = new JLabel("Haut");
	lblSymptome08.setBounds(251, 242, 132, 14);
	
	JLabel lblSymptome09 = new JLabel("Fieber");
	lblSymptome09.setBounds(251, 260, 132, 14);
	
	JLabel lblSymptome10 = new JLabel("Auto Save");
	lblSymptome10.setBounds(251, 280, 132, 14);
	
	symptomeModel2 = new DefaultListModel<String>();
	dateModel = new DefaultListModel<String>();
	
	JScrollPane scrollPane_3 = new JScrollPane();
	scrollPane_3.setBounds(195, 327, 150, 160);
	contentPane.add(scrollPane_3);
	
	JTextPane tpGespeichert = new JTextPane();
	scrollPane_3.setViewportView(tpGespeichert);
	tpGespeichert.setText("tpGespeichert");
	
	JLabel lblUeberschrift = new JLabel("DWD Pollwenvorhersage");
	lblUeberschrift.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblUeberschrift.setBounds(20, 5, 478, 24);
	
	
	lblSavedData = new JLabel("lblSavedData");
	lblSavedData.setBounds(195, 40, 274, 14);
	
	
	JScrollPane scrollPane_4 = new JScrollPane();
	scrollPane_4.setBounds(25, 116, 140, 371);


	lstDateList = new JList<String>();
	lstDateList.setModel(dateModel);
	lstDateList.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
		    int index=lstDateList.getSelectedIndex();
		    tpGespeichert.setText(AktualisierenPollen.getPollenSelectedPollen(index));
		    btnUebernehmen.setVisible(true);
		    btnBearbeiten.setVisible(true);
		    btnBearbeitenSave.setVisible(false);
		    btnLoeschen.setVisible(false);
		    btnAbbrechen.setVisible(false);
		    symptomeZurueckschreibenString(index);
		    lblSavedData.setText("gespeicherte Daten vom: "+AktualisierenPollen.getPollenSelectedDate(index));

		}
	});
	lstDateList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	
	
	scrollPane_4.setViewportView(lstDateList);

	btnUebernehmen = new JButton("\u00DCbernehmen >>");
	btnUebernehmen.setBounds(35, 571, 223, 23);
	btnUebernehmen.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		uebernehmen();
	    }
	});
	btnUebernehmen.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) uebernehmen(); }
	});
	
	

	
	btnBearbeiten = new JButton("letztes Element bearbeiten");
	btnBearbeiten.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		btnUebernehmen.setVisible(false);
		btnBearbeiten.setVisible(false);
		btnBearbeitenSave.setVisible(true);
		btnLoeschen.setVisible(true);
		btnAbbrechen.setVisible(true);
		btnAbbrechen.requestFocus();
		setCheckBox2Modified();
		lastIndex = symptomeModel2.size()-1;
		if (lastIndex > 0) {
		    symptomeZurueckschreibenString(lastIndex);
		    if (tfSymptome10.getText().contains("auto")) {
			setCheckBox2Modified();
		    }
		} else JOptionPane.showMessageDialog(null,"Kein Eintrag markiert.");
		lblSavedData.setText("gespeicherte Daten vom: "+AktualisierenPollen.getPollenSelectedDate(lastIndex));
		tfSymptome01.requestFocus();
		tfSymptome01.selectAll();
		tfSymptome10.setText("manu");
	    }
	});
	btnBearbeiten.setBounds(35, 605, 223, 23);
	

	btnBearbeitenSave = new JButton("Bearbeitung übernehmen>>");
	btnBearbeitenSave.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {bearbeitenSave();}
	});
	btnBearbeitenSave.setVisible(false);
	btnBearbeitenSave.setBounds(35, 605, 223, 23);
	btnBearbeitenSave.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {if (e.getKeyCode() == KeyEvent.VK_ENTER) bearbeitenSave(); }
	});

	
	btnLoeschen = new JButton("letzten Eintrag l\u00F6schen");
	btnLoeschen.setVisible(false);
	btnLoeschen.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		btnUebernehmen.setVisible(true);
		btnBearbeiten.setVisible(true);
		btnBearbeitenSave.setVisible(false);
		btnLoeschen.setVisible(false);
		btnAbbrechen.setVisible(false);
		int index = symptomeModel2.size()-1;
		if (index > 0) {
		    symptomeModel2.remove(index);
		    dateModel.remove(index);
		    btnLoeschen.setVisible(false);
		} else  JOptionPane.showMessageDialog(null,"Kein Eintrag markiert.");
	    }
	});
	btnLoeschen.setBounds(35, 639, 223, 23);
	
	btnAbbrechen = new JButton("Bearbeitung abbrechen");
	btnAbbrechen.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		btnUebernehmen.setVisible(true);
		btnBearbeiten.setVisible(true);
		btnBearbeitenSave.setVisible(false);
		btnLoeschen.setVisible(false);
		btnAbbrechen.setVisible(false);
		btnUebernehmen.requestFocus();
		symptomeZurueckschreibenString(lastIndex);
	    }
	});
	btnAbbrechen.setVisible(false);
	btnAbbrechen.setBounds(279, 605, 267, 23);


	btnSave = new JButton("save");
	btnSave.setBounds(598, 639, 167, 23);
	btnSave.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {save(); }
	});
	btnSave.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {if (e.getKeyCode() == KeyEvent.VK_ENTER) save();}
	});

	
	
	btnGetDWD_Data = new JButton("set Data-reload");
	btnGetDWD_Data.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    dataReload();
		    btnUebernehmen.requestFocus();
		}
	});
	btnGetDWD_Data.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			dataReload();
			btnUebernehmen.requestFocus();
		    }
		}
	});

	
	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(null, "DWD data", TitledBorder.LEADING, TitledBorder.BOTTOM, null, null));
	panel.setBounds(505, 67, 244, 527);
	
	btnGetDWD_Data.setBounds(565, 22, 167, 23);

	lblLastUpdate = new JLabel("last update: ");	
	lblNextUpdate = new JLabel("Next Update");
	JLabel lblTomorrow = new JLabel("Vorhersage für morgen");
	JLabel lbltoday = new JLabel("aktuelle Daten von heute");
	
	tpPollenToday = new JTextPane();
	tpPollenToday.setEditable(false);
	tpPollenToday.setText("tpPollenToday");
	
	tpPollenTomorrow = new JTextPane();
	tpPollenTomorrow.setAutoscrolls(false);
	tpPollenTomorrow.setEditable(false);
	tpPollenTomorrow.setText("tpPollenTomorrow");
	
	JScrollPane scrollPane_1 = new JScrollPane();
	scrollPane_1.setViewportView(tpPollenToday);
	JScrollPane scrollPane_2 = new JScrollPane();
	scrollPane_2.setViewportView(tpPollenTomorrow);

	contentPane.add(btnBearbeiten);
	contentPane.add(btnLoeschen);
	contentPane.add(btnUebernehmen);
	contentPane.add(btnSave);
	contentPane.add(btnGetDWD_Data);
	contentPane.add(btnAbbrechen);
	contentPane.add(btnBearbeitenSave);
	contentPane.add(lblUeberschrift);
	contentPane.add(scrollPane_4);
	contentPane.add(lblSavedData);
	
	contentPane.add(tfSymptome01);
	contentPane.add(tfSymptome02);
	contentPane.add(tfSymptome03);
	contentPane.add(tfSymptome04);
	contentPane.add(tfSymptome05);
	contentPane.add(tfSymptome06);
	contentPane.add(tfSymptome07);
	contentPane.add(tfSymptome08);
	contentPane.add(tfSymptome09);
	contentPane.add(tfSymptome10);
	contentPane.add(lblSymptome01);
	contentPane.add(lblSymptome02);
	contentPane.add(lblSymptome03);
	contentPane.add(lblSymptome04);
	contentPane.add(lblSymptome05);
	contentPane.add(lblSymptome06);
	contentPane.add(lblSymptome07);
	contentPane.add(lblSymptome08);
	contentPane.add(lblSymptome09);
	contentPane.add(lblSymptome10);
	contentPane.add(panel);
	
	GroupLayout gl_panel = new GroupLayout(panel);
	gl_panel.setHorizontalGroup(
		gl_panel.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_panel.createSequentialGroup()
				.addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(10)
						.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(10)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
					.addComponent(lblLastUpdate, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addComponent(lbltoday, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblTomorrow, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblNextUpdate, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(14, Short.MAX_VALUE))
	);
	gl_panel.setVerticalGroup(
		gl_panel.createParallelGroup(Alignment.TRAILING)
			.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
				.addContainerGap()
				.addComponent(lblLastUpdate)
				.addGap(18)
				.addComponent(lbltoday)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addComponent(lblTomorrow)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addComponent(lblNextUpdate)
				.addContainerGap(52, Short.MAX_VALUE))
	);
	panel.setLayout(gl_panel);
    }
        
    protected void uebernehmen() {
	lastIndex = symptomeModel2.size()-1;
	System.out.println(AktualisierenPollen.getPollenSelectedDate(lastIndex));
	String date1 = (AktualisierenPollen.getPollenSelectedDate(lastIndex));
	System.out.println(lastUpdate);
	String date2 = lastUpdate;
	if (date1.contentEquals(date2)) {
	    System.out.println("gleich"); 
	    if (tfSymptome10.getText().contains("auto")) setCheckBox2Modified();
	    lblSavedData.setText("gespeicherte Daten vom: "+AktualisierenPollen.getPollenSelectedDate(lastIndex));
	    btnUebernehmen.setVisible(false);
	    btnBearbeiten.setVisible(false);
	    btnBearbeitenSave.setVisible(true);
	    btnLoeschen.setVisible(true);
	    btnAbbrechen.setVisible(true);
	    btnAbbrechen.requestFocus();	
	}else {
	    System.out.println("ungleich");
	    dataReload();
	    setUebernehmen();
	    AktualisierenPollen.setSymptomeModelZerlegen();
	    lblSavedData.setText("gespeicherte Daten vom: "+AktualisierenPollen.getPollenSelectedDate(lastIndex+1));
	}
	tfSymptome01.requestFocus();
	tfSymptome01.selectAll();
	    
	}


    protected void bearbeitenSave() {
	btnUebernehmen.setVisible(true);
	btnBearbeiten.setVisible(true);
	btnBearbeitenSave.setVisible(false);
	btnLoeschen.setVisible(false);
	int index = symptomeModel2.size()-1;
	if (index > 0) {
	    symptomeModel2.remove(index);
	    symptomeModel2.addElement(
			lastUpdate+";"
			+ tfSymptome01.getText() + ";"
			+ tfSymptome02.getText() + ";"
			+ tfSymptome03.getText() + ";"
			+ tfSymptome04.getText() + ";"
			+ tfSymptome05.getText() + ";"
			+ tfSymptome06.getText() + ";"
			+ tfSymptome07.getText() + ";"
			+ tfSymptome08.getText() + ";"
			+ tfSymptome09.getText() + ";"
			+ tfSymptome10.getText() + "/"
    			+pollenToday4rec);
    		btnSave.requestFocus();
	} else JOptionPane.showMessageDialog(null,"Kein Eintrag markiert.");
    }


    private void save() {
	btnUebernehmen.setVisible(true);
	btnBearbeiten.setVisible(true);
	btnBearbeitenSave.setVisible(false);
	btnLoeschen.setVisible(false);
	btnAbbrechen.setVisible(false);
	btnUebernehmen.requestFocus();
	AktualisierenPollen.setSave();   
    }


    private static void dataReload() {
	setCheckBox2AutoSave();
	AktualisierenPollen.setPollenReload();   
    }
    
    public static void symptomeZurueckschreibenString(int i) {
	    String zeile = symptomeModel2.elementAt(i);
	    zeile = zeile.substring(zeile.indexOf(";") + 1,zeile.length());
	    tfSymptome01.setText(zeile.substring(0, zeile.indexOf(";")));	    
	    zeile = zeile.substring(zeile.indexOf(";") + 1,zeile.length());
	    tfSymptome02.setText(zeile.substring(0, zeile.indexOf(";")));
	    zeile = zeile.substring(zeile.indexOf(";") + 1,zeile.length());
	    tfSymptome03.setText(zeile.substring(0, zeile.indexOf(";")));
	    zeile = zeile.substring(zeile.indexOf(";") + 1,zeile.length());
	    tfSymptome04.setText(zeile.substring(0, zeile.indexOf(";")));
	    zeile = zeile.substring(zeile.indexOf(";") + 1,zeile.length());
	    tfSymptome05.setText(zeile.substring(0, zeile.indexOf(";")));
	    zeile = zeile.substring(zeile.indexOf(";") + 1,zeile.length());
	    tfSymptome06.setText(zeile.substring(0, zeile.indexOf(";")));
	    zeile = zeile.substring(zeile.indexOf(";") + 1,zeile.length());
	    tfSymptome07.setText(zeile.substring(0, zeile.indexOf(";")));
	    zeile = zeile.substring(zeile.indexOf(";") + 1,zeile.length());
	    tfSymptome08.setText(zeile.substring(0, zeile.indexOf(";")));
	    zeile = zeile.substring(zeile.indexOf(";") + 1,zeile.length());
	    tfSymptome09.setText(zeile.substring(0, zeile.indexOf(";")));
	    zeile = zeile.substring(zeile.indexOf(";") + 1,zeile.length());
	    tfSymptome10.setText(zeile.substring(0, zeile.indexOf("/")));
	}


    public static void setLastUpdate(String lUpdate) {
	lastUpdate = lUpdate.substring(0, 10);
	lblLastUpdate.setText("Last Update: "+lUpdate);
    }
    
    public static void setNextUpdate(String nUpdate) {
	lblNextUpdate.setText("Next Update: "+nUpdate);
    }
    
    public static void setPollenToday(String pToday) {
	tpPollenToday.setText(pToday);
    }
    
    public static void setPollenToday4rec(String pToday4rec) {
	pollenToday4rec = pToday4rec;
    }
    
    public static void setPollenTomorrow(String pTomorrow) {
	tpPollenTomorrow.setText(pTomorrow);
    }
    
    
    public static void setUebernehmen() {
	String newString;
	newString = lastUpdate+";"
		+ tfSymptome01.getText() + ";"
		+ tfSymptome02.getText() + ";"
		+ tfSymptome03.getText() + ";"
		+ tfSymptome04.getText() + ";"
		+ tfSymptome05.getText() + ";"
		+ tfSymptome06.getText() + ";"
		+ tfSymptome07.getText() + ";"
		+ tfSymptome08.getText() + ";"
		+ tfSymptome09.getText() + ";"
		+ tfSymptome10.getText() + "/"
		+pollenToday4rec;
	symptomeModel2.addElement(newString);
	dateModel.addElement(lastUpdate);
    }
    
    public static void setCheckBox2AutoSave() {
	tfSymptome01.setText("-1");
	tfSymptome02.setText("-1");
	tfSymptome03.setText("-1");
	tfSymptome04.setText("-1");
	tfSymptome05.setText("-1");
	tfSymptome06.setText("-1");
	tfSymptome07.setText("-1");
	tfSymptome08.setText("-1");
	tfSymptome09.setText("-1");
	tfSymptome10.setText("auto");
    }
    
    public static void setCheckBox2Modified() {
	tfSymptome01.setText("0");
	tfSymptome02.setText("0");
	tfSymptome03.setText("0");
	tfSymptome04.setText("0");
	tfSymptome05.setText("0");
	tfSymptome06.setText("0");
	tfSymptome07.setText("0");
	tfSymptome08.setText("0");
	tfSymptome09.setText("0");
	tfSymptome10.setText("manu");
    }
 }
