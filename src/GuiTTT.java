import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GuiTTT extends JPanel implements ActionListener {
    private int winner = 0;
    private int count = 0;
    boolean endStatus = false;
    private JButton buttons[][] = new JButton[3][3];

    public int getWinner() {
        return winner;
    }
    private Communicate UTTT;

    GuiTTT(Communicate UTTT) {
        this.UTTT=UTTT;
        addButtons();
        setLayout(new GridLayout(3, 3));
        setBackground(Color.WHITE);
    }

    private void addButtons() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
    }

    public void checkNextMove(JButton jButton) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (jButton == buttons[i][j]) {
                        UTTT.allowedMove(i,j);
                    break;
                }
            }
        }
    }
    List<JButton> getAvailableButtons()
    {
        List<JButton> a=new ArrayList<>();
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(buttons[i][j].getBackground()!=Color.RED && buttons[i][j].getBackground()!=Color.BLUE)
                {
                    a.add(buttons[i][j]);
                }
            }
        }
        return a;
    }
    private void changeButtonColor(JButton jButton)
    {
        if (UTTT.getPlayerColor() == 1)
            jButton.setBackground(Color.RED);
        else
            jButton.setBackground(Color.BLUE);
        count++;
    }
    public void changeWinColor()
    {

        GuiUTTT.totalCount++;
        this.winner =3- UTTT.getTurn();
        if (UTTT.getTurn() == 2 && UTTT.getPlayerColor() == 1)
            setBackground(Color.blue);
        else if (UTTT.getTurn() == 2 && UTTT.getPlayerColor() != 1)
            setBackground(Color.red);
        else if (UTTT.getTurn() == 1 && UTTT.getPlayerColor() == 1)
            setBackground(Color.red);
        else if (UTTT.getTurn() == 1 && UTTT.getPlayerColor() != 1)
            setBackground(Color.blue);
        endStatus = true;
        int b=UTTT.checkWinner();
        if(b!=0)
        {
            if(b==UTTT.getPlayerColor())
            {
                GuiWin g =new GuiWin("Player Wins");
                UTTT.disposeWindow();
            }
            else {
                GuiWin a=new GuiWin("Computer Wins");
                UTTT.disposeWindow();
            }
        }
        if(GuiUTTT.totalCount==9) {
            GuiWin a=new GuiWin("Draw");
            UTTT.disposeWindow();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!endStatus)
        {
            JButton jButton = (JButton) e.getSource();
            if(UTTT.checkIfAnyYellow())
            {   if(getBackground()==Color.YELLOW)
                {
                    if (jButton.getBackground() != Color.BLUE && jButton.getBackground() != Color.RED) {
                        changeButtonColor(jButton);
                        checkNextMove(jButton);
                        if (checkForWin())
                            changeWinColor();
                        if(GuiUTTT.totalCount!=9) {
                            UTTT.changeTurn();
                            UTTT.computersTurn();
                            UTTT.changeTurn();
                        }
                    }
                }
                else
                {
                    Error error =new Error();
                }
              }
            else
            {
                if (jButton.getBackground() != Color.BLUE && jButton.getBackground() != Color.RED) {
                    checkNextMove(jButton);
                    changeButtonColor(jButton);
                    if (checkForWin())
                        changeWinColor();
                    if(GuiUTTT.totalCount!=9) {
                        UTTT.changeTurn();
                        UTTT.computersTurn();
                        UTTT.changeTurn();
                    }
                }
            }

            if (count == 9) {
                winner = 0;
                endStatus = true;
            }

        }
        else {
            Error error=new Error();
        }

    }

    private boolean checkHorizontal() {
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getBackground() == Color.BLUE || buttons[i][0].getBackground() == Color.RED)
                if (buttons[i][0].getBackground() == buttons[i][1].getBackground() && buttons[i][0].getBackground() == buttons[i][2].getBackground())
                    return true;
        }
        return false;
    }

    private boolean checkVertical() {
        for (int i = 0; i < 3; i++) {
            if (buttons[0][i].getBackground() == Color.BLUE || buttons[0][i].getBackground() == Color.RED)
                if (buttons[0][i].getBackground() == buttons[1][i].getBackground() && buttons[0][i].getBackground() == buttons[2][i].getBackground())
                    return true;
        }
        return false;
    }

    private boolean checkDiagonal() {

        if (buttons[0][0].getBackground() == Color.BLUE || buttons[0][0].getBackground() == Color.RED)
            if (buttons[0][0].getBackground() == buttons[1][1].getBackground() && buttons[0][0].getBackground() == buttons[2][2].getBackground())
                return true;
        if (buttons[0][2].getBackground() == Color.BLUE || buttons[0][2].getBackground() == Color.RED)
            return buttons[0][2].getBackground() == buttons[1][1].getBackground() && buttons[0][2].getBackground() == buttons[2][0].getBackground();
        return false;
    }
    public boolean checkForWin() {
        if (checkHorizontal())
            return true;
        else if (checkVertical())
            return true;
        else return checkDiagonal();
    }
}
