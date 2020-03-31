public interface Communicate
{
    void allowedMove (int x, int y);
    void changeTurn();
    int getTurn();
    int getPlayerColor();
    boolean checkIfAnyYellow();
    void computersTurn();
    int checkWinner();
    void disposeWindow();
}
