package emailapp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import static java.lang.Thread.sleep;

public class Login extends JFrame {
    private JLabel title;
    private JTextField entree1;
    private JPasswordField entree2;
    private JPanel panel2;
    private JButton button1;
    private HashMap<String, String> loginInfo;

    public Login(HashMap<String, String> loginInfo){
        setResizable(false);
        setContentPane(panel2);
        setSize(600,200);
        setTitle("Login Page");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.loginInfo=loginInfo;


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userID = entree1.getText();
                String password = String.valueOf(entree2.getPassword());
                if(loginInfo.containsKey(userID)) {
                    if(loginInfo.get(userID).equals(password)) {
                        JOptionPane.showMessageDialog(new JFrame(), "LOGIN SUCCESSFUL");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            JOptionPane.showMessageDialog(new JFrame(), "CONNEXION INTERROMPUE");
                        }
                        Welcome bienvenue = new Welcome();

                    }
                    else {
                        JOptionPane.showMessageDialog(new JFrame(), "LOGIN NOT SUCCESSFUL");
                        entree2.setText("");
                    }

                }
                else {
                    JOptionPane.showMessageDialog(new JFrame(), "USERNAME NOT FOUND");
                    entree1.setText("");
                    entree2.setText("");
                }}
        });

    }



}

