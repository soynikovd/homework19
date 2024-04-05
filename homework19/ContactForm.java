package homework19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {
    JTextField name_field, secondName_field;
    JRadioButton age1, age2, age3, age4, age5;
    JCheckBox checkBox;

    public ContactForm() {
        super("Зарегеструйтесь");
        super.setBounds(200, 200, 600, 350);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(7, 7, 4, 5));

        JLabel name = new JLabel("Enter your name: ");
        name_field = new JTextField("", 1);

        JLabel secondName = new JLabel("\nEnter your surname: ");
        secondName_field = new JTextField("", 1);

        container.add(name);
        container.add(name_field);
        System.out.println();
        container.add(secondName);
        container.add(secondName_field);

        JLabel ageLabel = new JLabel("Enter your age:");
        container.add(ageLabel);

        age1 = new JRadioButton("0-6");
        age2 = new JRadioButton("7-17");
        age3 = new JRadioButton("18-23");
        age4 = new JRadioButton("24-60");
        age5 = new JRadioButton("60+");

        age1.setSelected(true);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(age1);
        buttonGroup.add(age2);
        buttonGroup.add(age3);
        buttonGroup.add(age4);
        buttonGroup.add(age5);

        container.add(age1);
        container.add(age2);
        container.add(age3);
        container.add(age4);
        container.add(age5);

        checkBox = new JCheckBox("Я погоджуюсь з умовами на обробку кукі", true);
        container.add(checkBox);

        JButton btn = new JButton("Send");
        container.add(btn);

        btn.addActionListener(new homework19.ContactForm.ButtonEventManager());
    }

    class ButtonEventManager implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = name_field.getText();
            String secondName = secondName_field.getText();

            String isAge;
            if (age1.isSelected()) {
                isAge = "0-6";
            } else if (age2.isSelected()) {
                isAge = "7-17";
            } else if (age3.isSelected()) {
                isAge = "18-23";
            } else if (age4.isSelected()) {
                isAge = "24-60";
            } else  {
                isAge = "60+";
            }
            boolean isCheck = checkBox.isSelected();
            JOptionPane.showMessageDialog(null,
                            "\nYour age: " + isAge + "\nYou agree " + isCheck,
                    "Hello, " + name + " " + secondName, JOptionPane.PLAIN_MESSAGE);
        }
    }
}