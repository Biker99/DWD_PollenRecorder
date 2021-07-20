# pollen
 Java 14 [JDK-14.0.2]
 
 Eclipse IDE Version: 2020-12 (4.18.0)
 
 Window-Builder implemented in Eclipse
 
This tool can be used to 
- download DWD Pollen status on daily basis
- DWD data (JSON file) is parsed, content is recorded in PollenSymptome.dat file 
- (data format is something close to .csv, not verified yet)
- each day, new download is started at 11am and a new line is added this file 
- with this, personal health status can be tracked on daily basis

 --> I use the tool to track my daily health status in relation to environmental distortions
 
 the java main file is located at /gui/PollenGUI.java
