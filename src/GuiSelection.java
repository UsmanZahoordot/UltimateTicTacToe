import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiSelection extends JFrame {
    private JLabel error;
    private JTextField textfield;

    GuiSelection(GuiUTTT guiUTTT) {
        JButton blue = new JButton();
        JButton red = new JButton();
        textfield = new JTextField();
        JLabel name = new JLabel("Enter Name :");
        JLabel select = new JLabel("Select Color");
        error = new JLabel();

        blue.setBounds(100, 100, 70, 40);
        red.setBounds(180, 100, 70, 40);
        select.setBounds(10, 100, 140, 40);
        name.setBounds(10, 10, 100, 100);
        textfield.setBounds(110, 50, 130, 25);
        error.setBounds(10, 140, 140, 40);

        blue.setBackground(Color.RED);
        red.setBackground(Color.BLUE);
        error.setForeground(Color.red);


        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textfield.getText().isBlank())
                    error.setText("Enter Name Please");
                else
                {
                    dispose();
                    guiUTTT.playGame(1);
                }
            }
        });
        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textfield.getText().isBlank())
                    error.setText("Enter Name Please");
                else
                {
                    dispose();
                    guiUTTT.playGame(2);
                }
            }
        });


        add(textfield);
        add(name);
        add(error);
        add(select);
        add(blue);
        add(red);
        setSize(300, 300);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
