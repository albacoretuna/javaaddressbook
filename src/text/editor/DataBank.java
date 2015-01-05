package text.editor;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// (when file reaches the end, a message "No more data" is displayed). 
public class DataBank extends JPanel {

    private JButton btnOpenForWriting, btnWriteThis, btnOpenForReading, btnReadNext;
    private JLabel  jlbName, jlbFamilyName, jlbNationality, jlbProfession, jlbInformation; 
    private JTextField i, jtxName, jtxFamilyName, jtxNationality, jtxProfession;
    private JComboBox jcbNationality, jcbProfession;
    public static int lineNumber = 1;


    public DataBank() {

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
 
        btnOpenForWriting.addActionListener(new ActionListener( ) {
            public void actionPerformed(ActionEvent e) {
                try {
                    WriteFile("justOpen");
                } catch (IOException ex) {
                    Logger.getLogger(DataBank.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnWriteThis.addActionListener(new ActionListener( ) {
            public void actionPerformed(ActionEvent e) {
               try {
                    WriteFile("writeNow");
                } catch (IOException ex) {
                    Logger.getLogger(DataBank.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnOpenForReading.addActionListener(new ActionListener( ) {
            public void actionPerformed(ActionEvent e) {
                try {
                    lineNumber = 1; 
                    ReadFile();
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
    private void WriteFile(String theSwitch) throws IOException{
        String filename, line;
        String[] parts;
        int i = 0; 
        
        
        filename = "data-file.txt";
        File f = new File(filename);   
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f, true)))) {
        jlbInformation.setText("Info: Congrats! data-file.txt opened for writing!");
            if(theSwitch == "writeNow"){
                String nationality = (String)jcbNationality.getSelectedItem();
                String profession = (String)jcbProfession.getSelectedItem();                
                line = jtxName.getText()+","+jtxFamilyName.getText()+","+nationality+","+profession+","; 
                out.println(line);
                jlbInformation.setText("Info: Congrats! record entered into database successfully");

            }
        }
           
    
    }
    private void ReadFile() throws IOException{ 
        String filename, line;
        String[] parts;
        int i = 0; 

 
        filename = "data-file.txt";
        File f = new File(filename);
        BufferedReader in = new BufferedReader
                                         (new InputStreamReader(new FileInputStream(f)));
        do{
        line = in.readLine();
        i++;
        if(line == null){
            jlbInformation.setText("Info: Reached the end of file, no more records!");
            break;
        }
        }while(lineNumber > i);
        
        
        parts = line.split(",");
        in.close();
                jtxName.setFont(new Font("Arial", Font.BOLD, 16));
                jtxName.setText(parts[0]);
                jtxFamilyName.setFont(new Font("Arial", Font.BOLD, 16));
                
                jtxFamilyName.setText(parts[1]);
                
                // Setting the nationality combobox from the text file
                switch(parts[2]) {
                    case "Swedish":
                        jcbNationality.setSelectedIndex(0);
                    break;  
                    case "Kurdish":
                        jcbNationality.setSelectedIndex(2);
                    break;                          
                    case "Finnish":
                        jcbNationality.setSelectedIndex(1);
                    break;                          
                }
                // Setting the nationality combobox from the text file
                switch(parts[3]) {
                    case "Student":
                        jcbProfession.setSelectedIndex(1);
                    break;  
                    case "Teacher":
                        jcbProfession.setSelectedIndex(0);
                    break;                          
                    case "Developer":
                        jcbProfession.setSelectedIndex(2);
                    break;                          
                }
        
    }

}

