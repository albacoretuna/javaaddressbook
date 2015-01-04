package text.editor;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UI extends JPanel {

    private JButton btnOpenForWriting, btnWriteThis, btnOpenForReading, btnReadNext;
    private JLabel  jlbName, jlbFamilyName, jlbNationality, jlbProfession, jlbInformation; 
    private JTextField i, jtxName, jtxFamilyName, jtxNationality, jtxProfession;
    private JComboBox jcbNationality, jcbProfession;
    public static int lineNumber = 1;


    public UI() {

        String[] nationalityStrings = { "Swedish", "Finnish", "Kurdish" };
        String[] professionStrings = { "Teacher", "Student", "Developer" };         
        jlbName = new JLabel("First Name");
        jlbFamilyName = new JLabel("Family Name");        
        jlbNationality = new JLabel("Nationality");  
        jlbProfession = new JLabel("Profession");   
        jlbInformation = new JLabel("Info:");
        jtxName = new JTextField(30);
        jtxFamilyName = new JTextField(30);        
        jcbNationality = new JComboBox(nationalityStrings);
        jcbProfession = new JComboBox(professionStrings);
        
        btnOpenForWriting = new JButton("Open For Writing");
        btnWriteThis = new JButton("Write This");
        btnOpenForReading = new JButton("Open First Row For Reading");
        btnReadNext = new JButton("Read Next");               
        this.setLayout(new GridLayout(8,2));
        this.setBorder(BorderFactory.createTitledBorder("Data Form"));
        this.add(jlbName);
        this.add(jlbFamilyName);
        this.add(jtxName);
        this.add(jtxFamilyName);   
        this.add(jlbNationality);
        this.add(jlbProfession);                
        this.add(jcbNationality);  
        this.add(jcbProfession);          
        this.add(btnOpenForWriting);
        this.add(btnWriteThis);
        this.add(btnOpenForReading);
        this.add(btnReadNext);  
        this.add(jlbInformation);
 
        final TextEditorBackEnd bc = new TextEditorBackEnd();
        
        btnOpenForWriting.addActionListener(new ActionListener( ) {
            public void actionPerformed(ActionEvent e) {
                try {
                    bc.WriteFile("justOpen");
                } catch (IOException ex) {
                    Logger.getLogger(DataBank.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnWriteThis.addActionListener(new ActionListener( ) {
            public void actionPerformed(ActionEvent e) {
               try {
                    bc.WriteFile("writeNow");
                } catch (IOException ex) {
                    Logger.getLogger(DataBank.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnOpenForReading.addActionListener(new ActionListener( ) {
            public void actionPerformed(ActionEvent e) {
                try {
                    lineNumber = 1; 
                    bc.ReadFile();
                    jlbInformation.setText("Info: data-file.txt opened for reading!");
                } catch (IOException ex) {
                    Logger.getLogger(DataBank.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });        
         btnReadNext.addActionListener(new ActionListener( ) {
            public void actionPerformed(ActionEvent e) {
                try {
                    lineNumber++;
                    ReadFile();
                } catch (IOException ex) {
                    Logger.getLogger(DataBank.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });         
        
        
    }

    public static void main(String[] args) {
        JFrame w = new JFrame("Data Bank");
        w.add(new DataBank(), BorderLayout.NORTH);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.pack( );
        w.setVisible(true);
    }
    

}

