/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.editor;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author omid
 */
public class TextEditorBackEnd {

    public TextEditorBackEnd() {
        
    }
    
    

    static void WriteFile(String theSwitch) throws IOException {
        String filename;
        String line;
        String[] parts;
        int i = 0;
        filename = "data-file.txt";
        File f = new File(filename);
        try (final PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f, true)))) {
            ui1.jlbInformation.setText("Info: Congrats! data-file.txt opened for writing!");
            if (theSwitch == "writeNow") {
                String nationality = (String) ui1.jcbNationality.getSelectedItem();
                String profession = (String) ui1.jcbProfession.getSelectedItem();
                line = ui1.jtxName.getText() + "," + ui1.jtxFamilyName.getText() + "," + nationality + "," + profession + ",";
                out.println(line);
                ui1.jlbInformation.setText("Info: Congrats! record entered into database successfully");
            }
        }
    }

    static void ReadFile() throws IOException {
        String filename;
        String line;
        String[] parts;
        int i = 0;
        filename = "data-file.txt";
        File f = new File(filename);
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        do {
            line = in.readLine();
            i++;
        } while (UI.lineNumber > i);
        parts = line.split(",");
        in.close();
        ui1.jtxName.setFont(new Font("Arial", Font.BOLD, 16));
        ui1.jtxName.setText(parts[0]);
        ui1.jtxFamilyName.setFont(new Font("Arial", Font.BOLD, 16));
        ui1.jtxFamilyName.setText(parts[1]);
        switch (parts[2]) {
            case "Swedish":
                ui1.jcbNationality.setSelectedIndex(0);
                break;
            case "Kurdish":
                ui1.jcbNationality.setSelectedIndex(2);
                break;
            case "Finnish":
                ui1.jcbNationality.setSelectedIndex(1);
                break;
        }
        switch (parts[3]) {
            case "Student":
                ui1.jcbProfession.setSelectedIndex(1);
                break;
            case "Teacher":
                ui1.jcbProfession.setSelectedIndex(0);
                break;
            case "Developer":
                ui1.jcbProfession.setSelectedIndex(2);
                break;
        }
    }





}
