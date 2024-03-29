import java.util.Scanner;

class TicTacToe {
	static char[][] board;

	public TicTacToe() {
		board = new char[3][3];
		initBoard();
	}

	void initBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = ' ';
			}
		}
	}

	static void Display() {
		System.out.println("-------------");
		for (int i = 0; i < board.length; i++) {
			System.out.print("| ");
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}

	static void placeMark(int row, int col, char mark) {
		if (row >= 0 && row <= 2 & col >= 0 && col <= 2) {
			board[row][col] = mark;
		} else {
			System.out.println("Invalid position");
		}
	}

	static boolean checkColWin() {
		for (int j = 0; j <= 2; j++) {
			if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
				return true;
			}
		}
		return false;
	}

	static boolean checkRowWin() {

		for (int i = 0; i <= 2; i++) {
			if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return true;
			}
		}
		return false;

	}

	static boolean checkDiagWin() {
		if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]
				|| board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			return true;
		} else {
			return false;
		}
	}

}

public class LaunchGame {
	public static void main(String[] args) {
		TicTacToe t = new TicTacToe();

		Human p1 = new Human("bob", 'X');
		Human p2 = new Human("jon", '0');
		Human cp;
		cp = p1;

		while (true) {
			System.out.println(cp.name + " turn");
			cp.makemove();
			TicTacToe.Display();
			if (TicTacToe.checkColWin() || TicTacToe.checkRowWin() || TicTacToe.checkDiagWin()) {
				System.out.println(cp.name + " has won");
				break;
			} else {
				if (cp == p1) {
					cp = p2;
				} else {
					cp = p1;
				}
			}
		}

	}
}

class Human {
	String name;
	char mark;

	Human(String name, char mark) {
		this.name = name;
		this.mark = mark;
	}

	void makemove() {
		int row;
		int col;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("enter the row and col :");
			row = sc.nextInt();
			col = sc.nextInt();
		} while (!isValidMove(row, col));
		TicTacToe.placeMark(row, col, mark);
	}

	boolean isValidMove(int row, int col) {
		if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
			if (TicTacToe.board[row][col] == ' ') {
				return true;
			}
		}
		return false;
	}
}