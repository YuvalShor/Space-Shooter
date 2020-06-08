import javax.jws.soap.SOAPBinding;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class MainGui implements ActionListener {
    private static JTextField usertText;
    private static  JPasswordField passwordText;
    private static JLabel userLabel,passwordLabel,success;
    private static JButton loginButton;


    public static void main(String[] args) {
        Register register = new Register();
        String title = "Login";
        Border border = BorderFactory.createTitledBorder(title);


        JPanel jPanel=new JPanel();
        jPanel.setBorder(border);
        JFrame jFrame=new JFrame();
        jFrame.setTitle("Login");
        jFrame.setSize(350,200);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.add(jPanel);
        jPanel.setLayout(null);

        userLabel=new JLabel("User");
        userLabel.setBounds(10,20,80,25);//padding
        jPanel.add(userLabel);

        passwordLabel=new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);//padding
        jPanel.add(passwordLabel);




        passwordText=new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        jPanel.add(passwordText);


        usertText=new JTextField(20);
        usertText.setBounds(100,20,165,25);
        jPanel.add(usertText);

        loginButton=new JButton("Login");
        loginButton.setBounds(10,80,80,25);
        loginButton.addActionListener(new MainGui());
        jPanel.add(loginButton);

        success=new JLabel("");
        success.setBounds(10,110,300,25);
        jPanel.add(success);
//        success.setText("You have logged in succesfully");

        jFrame.setVisible(true);



    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String user=usertText.getText();
        String passText = getSha1Hex(new String(passwordText.getPassword()));
        System.out.println(Register.usersMap.get(user).hashCode());

        if(Register.usersMap.containsKey(user)){
            if( Register.usersMap.get(user).getPassword().equals(passText)) {
                success.setText("Hen Tistom Ya ben Shel 1000");
            }
            else{
                success.setText("Incorrect Password");
            }
        }else{
            success.setText("User not find  You Must Register first");
        }


    }

    public static String getSha1Hex(String clearString)
    {
        try
        {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(clearString.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = messageDigest.digest();
            StringBuilder buffer = new StringBuilder();
            for (byte b : bytes)
            {
                buffer.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            return buffer.toString();
        }
        catch (Exception ignored)
        {
            ignored.printStackTrace();
            return null;
        }
    }
}
