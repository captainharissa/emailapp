package emailapp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;


public class Formulaire extends JFrame{
    private JTextField textField1;
    private JLabel first;
    private JTextField textField2;
    private JTextField textField3;
    private JButton validerButton;
    private JPanel panel;
    private JLabel password;
    private JLabel adresse;
    private JButton resetButton;
    private JLabel question1;
    private JLabel question2;

    //Constructeur de la fenêtre
    public Formulaire(){


        setResizable(false);
        setContentPane(panel);
        setSize(600,300);
        setTitle("Create your account");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        question1.setText("");
        question2.setText("");

        //Ajout des conditions du formulaire et action sur le bouton valider

        validerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prenom = textField1.getText();
                String nom = textField2.getText();
                Email email = new Email(prenom, nom);


                if(prenom.equals("") || nom.equals("") || nom.matches(".*[123456789].*") || prenom.matches(".*[123456789].*") || nom.matches(".*[àáâãäåæçèéêëìíîïðñòóôõöøœšÞùúûüýÿ].*") || prenom.matches(".*[àáâãäåæçèéêëìíîïðñòóôõöøœšÞùúûüýÿ].*") || nom.matches(".*[-_!@#$%^&*()+=;:'|,.<>/?].*") || prenom.matches(".*[-_!@#$%^&*()+=;:'|,.<>/?].*")){
                    JOptionPane.showMessageDialog(new JFrame(), "SAISIE INVALIDE DU PRENOM ET DU NOM. VEUILLEZ REESSAYER");
                    textField1.setText("");
                    textField2.setText("");
                    textField3.setText("");
                    password.setVisible(false);
                    adresse.setVisible(false);
                    question1.setText("");
                    question2.setText("");;
                }
                else if((!textField3.getText().equals("enseignant") && (!textField3.getText().equals("élève")) && (!textField3.getText().equals("admin"))) || textField3 == null) {
                    JOptionPane.showMessageDialog(new JFrame(), "SAISIE INVALIDE DU DEPARTEMENT. VEUILLEZ REESSAYER");
                    textField3.setText("");

                    adresse.setVisible(false);
                    password.setVisible(false);
                    question1.setText("");
                    question2.setText("");
                } else {


                password.setVisible(true);
                adresse.setVisible(true);
                    question1.setText("Votre password est :");
                    question2.setText("Votre e-mail est :");
                password.setText(email.randomPassword(5));
                adresse.setText(prenom.toLowerCase()+ "."+ nom.toLowerCase()+"@"+email.setDepartment(textField3.getText()) + "." + email.getCompany());
                DataBase data = new DataBase(adresse.getText(), password.getText());
                Login login = new Login(data.getLoginInfo());
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                question1.setText("");
                question2.setText("");
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                password.setText("");
                adresse.setText("");
                password.setVisible(false);
                adresse.setVisible(false);
            }
        });
        setVisible(true);

    }

}
