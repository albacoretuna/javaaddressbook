package text.editor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InputForm extends JDialog {

    private JButton ok;
    private JButton cancel;
    private String fname, sname, tel, elm;
    private JTextField fnamef, snamef, telf, elmf;

    public InputForm(Frame f, String s) {
        super(f, s, true);
        fnamef = new JTextField(20);
        snamef = new JTextField(20);
        telf = new JTextField(20);
        elmf = new JTextField(20);
        ok = new JButton("OK");
        cancel = new JButton("Cancel");
        JPanel upper = new JPanel(new GridLayout(0,2,10,10));
        JPanel namep = new JPanel(new BorderLayout());
        JPanel nl = new JPanel(new GridLayout(2,0));
        nl.add(new JLabel("First name"));
        nl.add(new JLabel("Surname"));
        JPanel nf = new JPanel(new GridLayout(2,0));
        nf.add(fnamef);
        nf.add(snamef);
        namep.add(nl, BorderLayout.WEST);
        namep.add(nf);
        JPanel telp = new JPanel(new BorderLayout());
        JPanel tl = new JPanel(new GridLayout(2,0));
        tl.add(new JLabel("Telephone"));
        tl.add(new JLabel("e-mail"));
        JPanel tf = new JPanel(new GridLayout(2,0));
        tf.add(telf);
        tf.add(elmf);
        telp.add(tl, BorderLayout.WEST);
        telp.add(tf);
        upper.add(namep);
        upper.add(telp);
        this.add(upper, BorderLayout.NORTH);
        JPanel lower = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel bp = new JPanel(new GridLayout(1,0,5,5));
        bp.add(ok);
        bp.add(cancel);
        lower.add(bp, BorderLayout.EAST);
        this.add(lower, BorderLayout.SOUTH);
        ok.addActionListener(new ActionListener( )  {
            public void actionPerformed(ActionEvent e)  {
                save( );
                setVisible(false);
            }
        });
        cancel.addActionListener(new ActionListener( )  {
            public void actionPerformed(ActionEvent e)  {
                setVisible(false);
            }
        });
        pack( );
    }

    private void save( )  {
        fname = fnamef.getText();
        sname = snamef.getText();
        tel = telf.getText();
        elm = elmf.getText();
    }

}


