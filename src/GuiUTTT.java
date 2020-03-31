import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GuiUTTT extends JFrame implements Communicate {
    private int turn = 1;
    private GuiTTT[][] mainBoard = new GuiTTT[3][3];
    private int x = 0, y = 0;
    int playerColor;
     public static int totalCount=0;

    GuiUTTT() {
        super("Ultimate Tic Tac Toe");
        addBoards();
        setSize(600, 600);
        setLayout(new GridLayout(3, 3));
    }

    void playGame(int playerColor) {
        this.playerColor = playerColor;
        setVisible(true);
    }

    private void addBoards() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                mainBoard[i][j] = new GuiTTT(this);
                mainBoard[i][j].setBorder(new EmptyBorder(10, 10, 10, 10));
                add(mainBoard[i][j]);
            }
    }

    @Override
    public void allowedMove(int x, int y) {
        if (mainBoard[this.x][this.y].getBackground() == Color.YELLOW)
            mainBoard[this.x][this.y].setBackground(Color.WHITE);
        if (checkIfEmptyBoard(x, y))
            mainBoard[x][y].setBackground(Color.YELLOW);
        this.x = x;
        this.y = y;
    }

    @Override
    public void changeTurn() {
        turn = 3 - turn;
    }

    @Override
    public int getPlayerColor() {
        return playerColor;
    }

    @Override
    public int getTurn() {
        return turn;
    }

    @Override
    public boolean checkIfAnyYellow() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (mainBoard[i][j].getBackground() == Color.YELLOW)
                    return true;
            }
        return false;
    }

    private void perform(int i, int j) {
        ArrayList<JButton> temp = (ArrayList<JButton>) mainBoard[i][j].getAvailableButtons();
        if(temp.size()>0) {
            Random rand = new Random();
            JButton randomElement = temp.get(rand.nextInt(temp.size()));
            if (playerColor == 1)
                randomElement.setBackground(Color.BLUE);
            else
                randomElement.setBackground(Color.RED);
            if (mainBoard[i][j].checkForWin())
                mainBoard[i][j].changeWinColor();
            mainBoard[i][j].checkNextMove(randomElement);
        }
    }

    @Override
    public void computersTurn() {
        int a = 0;
        if (checkIfAnyYellow()) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (mainBoard[i][j].getBackground() == Color.YELLOW) {

                        if (mainBoard[i][j].getBackground() != Color.RED && mainBoard[i][j].getBackground() != Color.BLUE) {
                            perform(i, j);
                            a = 1;
                            break;
                        }
                    }
                }
                if (a == 1)
                    break;
            }
        } else if (!checkIfAnyYellow()) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (mainBoard[i][j].getBackground() != Color.RED && mainBoard[i][j].getBackground() != Color.BLUE && !mainBoard[i][j].endStatus) {
                        perform(i, j);
                        a = 1;
                        break;
                    }
                }
                if (a == 1)
                    break;
            }
        }
    }

    private int checkHorizontal() {
        boolean flag=false;
        int i=0;
        for (i = 0; i < 3; i++) {
            if (mainBoard[i][0].getBackground() == Color.BLUE || mainBoard[i][0].getBackground() == Color.RED)
                if (mainBoard[i][0].getBackground() == mainBoard[i][1].getBackground() && mainBoard[i][0].getBackground() == mainBoard[i][2].getBackground()) {
                    flag = true;
                    break;
                }
        }
        if(flag)
        {
            if(mainBoard[i][0].getBackground()==Color.BLUE)
                return 2;
            else
                return 1;
        }
        return 0;
    }
    private int checkVertical() {
        int i=0;
        boolean flag=false;
        for ( i = 0; i < 3; i++) {
            if (mainBoard[0][i].getBackground() == Color.BLUE || mainBoard[0][i].getBackground() == Color.RED)
                if (mainBoard[0][i].getBackground() == mainBoard[1][i].getBackground() && mainBoard[0][i].getBackground() == mainBoard[2][i].getBackground())
                {
                    flag=true;
                    break;
                }
        }
        if(flag)
        {
            if(mainBoard[0][i].getBackground()==Color.BLUE)
                return 2;
            else
                return 1;
        }
        return 0;
    }
    private int checkDiagonal() {

        boolean flag1=false, flag2=false;
        if (mainBoard[0][0].getBackground() == Color.BLUE || mainBoard[0][0].getBackground() == Color.RED)
            if (mainBoard[0][0].getBackground() == mainBoard[1][1].getBackground() && mainBoard[0][0].getBackground() == mainBoard[2][2].getBackground())
                flag1=true;
        if (mainBoard[0][2].getBackground() == Color.BLUE || mainBoard[0][2].getBackground() == Color.RED)
            if(mainBoard[0][2].getBackground() == mainBoard[1][1].getBackground() && mainBoard[0][2].getBackground() == mainBoard[2][0].getBackground())
                flag2=true;
        if(flag1)
        {
            if(mainBoard[0][0].getBackground()==Color.BLUE)
                return 2;
            else
                return 1;
        }
        if(flag2)
        {
            if(mainBoard[0][2].getBackground()==Color.BLUE)
                return 2;
            else
                return 1;
        }
        return 0;
    }
    @Override
    public int checkWinner() {
        int a=checkDiagonal();
        if(a!=0)
            return a;
        a=checkHorizontal();
        if(a!=0)
            return a;
        a=checkVertical();
        return a;
    }

    @Override
    public void disposeWindow() {
        dispose();
    }

    private boolean checkIfEmptyBoard(int x, int y) {
        return !mainBoard[x][y].endStatus;
    }
}
