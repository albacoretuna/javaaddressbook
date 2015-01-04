/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.editor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author omid
 */
public class TextEditorUI extends JFrame {
    
    private InputForm myForm;
    
    public TextEditorUI(){
        super("Tha Data Form");
        myForm = new InputForm(this, "An input form");
        JButton n = new JButton("Open form...");
        this.add(n, BorderLayout.NORTH);
        n.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myForm.setVisible(true);
            }
        });
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setVisible(true);;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new TextEditorUI();
    }
    
}
