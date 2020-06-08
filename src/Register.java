import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Register implements ActionListener {
    public static Map<String,Person> usersMap;
    private static JTextField usertText;
    private static  JPasswordField passwordText;
    private static JLabel userLabel,passwordLabel,success,dobLabel;
    private static JButton loginButton,exitButton;
    private static JPanel jPanel;
    private static JFrame jFrame;


    public Register(){
        String title = "Register";
        Border border = BorderFactory.createTitledBorder(title);
        usersMap=new HashMap<>();
        jPanel=new JPanel();
        jPanel.setBorder(border);
        jFrame=new JFrame();
        jFrame.setTitle("Register");
        jFrame.setSize(500,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        jFrame.add(jPanel);
        jPanel.setLayout(null);


        usertText=new JTextField(20);
        usertText.setBounds(100,20,165,25);
        jPanel.add(usertText);


        passwordText=new JPasswordField(20);
        passwordText.setBounds(100,80,165,25);
        jPanel.add(passwordText);


        userLabel=new JLabel("Username");
        userLabel.setBounds(10,20,80,25);//padding
        jPanel.add(userLabel);



        passwordLabel=new JLabel("Password");
        passwordLabel.setBounds(10,80,80,25);//padding
        jPanel.add(passwordLabel);

        loginButton=new JButton();
        loginButton.addActionListener(this);
        loginButton.setText("Register");
        loginButton.setBounds(10,120,100,25);

        jPanel.add(loginButton);

        exitButton=new JButton();
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exit");
                jFrame.dispose();
            }
        });
        exitButton.setText("Exit");
        exitButton.setBounds(120,120,140,25);
        jPanel.add(exitButton);

        jFrame.setVisible(true);



    }



    @Override
    public void actionPerformed(ActionEvent e) {
        Register.usersMap.put(usertText.getText(),new Person(usertText.getText(),MainGui.getSha1Hex(new String(passwordText.getPassword()))));
        //adding a user to the hashmap username is the Key.
        //person are the values.
        System.out.println("good");
    }
}
