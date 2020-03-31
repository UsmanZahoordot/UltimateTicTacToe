import javax.swing.*;
import java.awt.*;

public class GuiWin extends JFrame {
    GuiWin(String player)
    {
        JLabel jLabel=new JLabel(player);
        add(jLabel);
        setLayout(new FlowLayout());
        setSize(400,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
