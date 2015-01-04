/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.editor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/**
 *
 * @author omid
 */
public class TextEditorBackEnd {
        public static void main(String[ ] a) throws Exception {
        String filename, line;
        filename = "data-file.txt";
        File f = new File(filename);
        BufferedReader in = new BufferedReader
                                         (new InputStreamReader(new FileInputStream(f)));
        String message = "See file content:\n";
        while(true) {
            line = in.readLine();
            if(line == null)
                break;
            message += line + "\n";
        }
        in.close();
        JOptionPane.showMessageDialog(null, message);
        System.out.println(message);
    }
    
}
