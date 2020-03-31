import javax.swing.*;
import java.awt.*;

public class Error extends JFrame {
    Error()
    {
        JLabel jLabel=new JLabel("Cannot input here ");
        add(jLabel);
        setLayout(new FlowLayout());
        setSize(400,100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
