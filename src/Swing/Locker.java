package Swing;

import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Locker {

    private String password;
    private boolean isSet = false;

    public void init() {
        JFrame frame = new JFrame("Midterm Locker");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four = new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");

        JButton clear = new JButton("Clear");
        JButton enter = new JButton("Enter");

        JPasswordField input = new JPasswordField(10);

        JLabel status = new JLabel("Enter Password");

        enter.addActionListener(e -> {
            String temp = new String (input.getPassword());
            if(!temp.isEmpty() && !isSet) {
                password = temp;
                status.setText("Password Set");
                input.setText("");
                isSet = true;
            }
            else if(!temp.isEmpty()) {
                if(temp.equals(password)) {
                    status.setText("Correct Password");
                }else {
                    status.setText("Incorrect Password");
                }
            }
        });

        clear.addActionListener(e -> {
            input.setText("");
        });

        one.addActionListener(e->{
            input.setText(new String(input.getPassword()) + "1");
        });
        two.addActionListener(e->{
            input.setText(new String(input.getPassword()) + "2");
        });
        three.addActionListener(e->{
            input.setText(new String(input.getPassword()) + "3");
        });
        four.addActionListener(e->{
            input.setText(new String(input.getPassword()) + "4");
        });
        five.addActionListener(e->{
            input.setText(new String(input.getPassword()) + "5");
        });
        six.addActionListener(e->{
            input.setText(new String(input.getPassword()) + "6");
        });
        seven.addActionListener(e->{
            input.setText(new String(input.getPassword()) + "7");
        });
        eight.addActionListener(e->{
            input.setText(new String(input.getPassword()) + "8");
        });
        nine.addActionListener(e->{
            input.setText(new String(input.getPassword()) + "9");
        });


        one.setBounds(5, 5, 50, 30);
        two.setBounds(60, 5, 50, 30);
        three.setBounds(115, 5, 50, 30);
        four.setBounds(5, 40, 50, 30);
        five.setBounds(60, 40, 50, 30);
        six.setBounds(115, 40, 50, 30);
        seven.setBounds(5, 85, 50, 30);
        eight.setBounds(60, 85, 50, 30);
        nine.setBounds(115, 85, 50, 30);

        clear.setBounds(5, 200, 80, 30);
        input.setBounds(115, 200, 150, 30);
        enter.setBounds(300, 200, 80, 30);

        status.setBounds(5, 250, 300, 30);


        frame.add(one);
        frame.add(two);
        frame.add(three);
        frame.add(four);
        frame.add(five);
        frame.add(six);
        frame.add(seven);
        frame.add(eight);
        frame.add(nine);
        frame.add(enter);
        frame.add(clear);
        frame.add(input);
        frame.add(status);

        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
