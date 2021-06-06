
# **Ultimate Tic-Tac-Toe**
We all know [Tic-Tac-Toe ](https://www.hackerrank.com/challenges/tic-tac-toe)ends in a predictable draw when both players choose optimal moves. To make the game interesting, a group of mathematicians decided to fill in each square of the board with a smaller Tic-Tac-Toe board to produce what is now called **Ultimate Tic-Tac-Toe**.

## **Challenge:**
Here is an abstract flow of the application:

1. The program asks for the name of player.

1. Player is asked to choose the preferable sign in the game. Computer takes the opposite sign to that.

1. The game starts with the empty ultimate tic-tac-toe board (shown below)
1. You need to win the game by continually printing the best next move, based on the game rules below. You will lose the test case if you write to an invalid board and/or write to a square that already has an X or O.

For the purposes of these instructions:

- **board** = one of the 9 tic-tac-toe game boards
- **square** = one of the 81 individual squares


![tic-tac-toe](Aspose.Words.a06cdf3d-9b46-439e-853a-29294dd3c6e1.001.png)


## **Game Rules**
Like the original Tic-Tac-Toe, Player 1 is represented by either 'X' or ‘O’ and Player 2 (player 2 is computer, in this case) is represented by the opposite sign (if Player 1 is ‘X’, then Player 2 is ‘O’). To start the game, Player 1 places his/her chosen sign on any one of the 81 empty squares, and then players alternate turns.

However, after the initial move, players must play the board that mirrors the square from the previous player.

![alt](Aspose.Words.a06cdf3d-9b46-439e-853a-29294dd3c6e1.002.jpeg)

For example: If Player 1 places an X in the upper-right *square* of a board, then Player 2 must play the upper-right *board*.


![alt2](Aspose.Words.a06cdf3d-9b46-439e-853a-29294dd3c6e1.003.jpeg)


Continuing the example: If Player 2 places an O on the lower-middle square, then Player 1 must next play the lower-middle board.

Here are the necessary exceptions:

If the next move is to a board that is full or has already been won, then that player may choose an **open** square on **any** board, for that turn.

If a player marks 3 consecutive squares (horizontally, vertically or diagonally) on any given board, he wins that board. The first player to win 3 consecutive *boards* (horizontally, vertically or diagonally) wins the game.


