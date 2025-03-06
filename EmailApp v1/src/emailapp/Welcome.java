package emailapp;

import javax.swing.*;

public class Welcome extends JFrame {

    private JPanel panel1;
    private JLabel message;

    public Welcome(){
        setSize(700,700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(panel1);
        add(new JLabel(new ImageIcon("Path/To/Your/Image.png")));
        setVisible(true);
    }

}
