package fr.mbonnot;

class TicTacToe {
  public char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

  public void playMove(int row, int col, char player) {
    if (board[row][col] == ' ') {
      board[row][col] = player;
    } else {
      System.out.println("Case déjà occupée!");
    }
  }

  public void displayBoard() {
    for (char[] row : board) {
      System.out.println(row);
    }
  }

  public static void main(String[] args) {
    TicTacToe game = new TicTacToe();
    game.playMove(0, 0, 'X');
    game.displayBoard();
  }
}
