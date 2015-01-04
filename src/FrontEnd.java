
import java.awt.Container;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author omid
 */
public class FrontEnd implements ActionListener {
    
    ArrayList personsList;
    PersonDAO pDAO;
    JFrame appFrame;
    JLabel jlbName, jlbFamilyName, jlbNationality, jlbProfession;
    JTextField jtfName, jtfAddress, jtfPhone, jtfEmail;
    JButton jbbOpenForWriting, jbbWriteThis, jbbOpenForReading, jbbReadThis;
    String firstName, familyName, nationality, profession; 
    
    Container cPane;
    public static void main(String args[]){
        new FrontEnd();
    }
    public FrontEnd(){
    firstName = '';
    familyName = '';
    nationality = '';
    profession = '';
    createGUI();
    personsList = new ArrayList();
    
    pDAO = new PersonDAO();
    }
    public void createGUI(){
    appFrame = new JFrame("Data Center");
    cPane = appFrame.getContentPane();
    cPane.setLayout(new GridBagLayout());
    
    arrangeComponents();
    appFrame.setSize(240, 300);
    appFrame.setResizable(false);
    appFrame.setVisible(true);
    
    
    }
    
    public void arrangeComponents(){
        jlbName = new JLabel("Name");
        jlbFamilyName = new JLabel("Family Name");
        jlbNationality = new JLabel("Nationality");
        jlbProfession = new JLabel("Profession");
    }
    
    
    
    
    
    
}
