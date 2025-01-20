import Model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {

    public Board gameBoard;
    Deque<Player> playerList;

    public void initializeGame(){
        gameBoard = new Board(3);
        playerList = new LinkedList<>();

        PlayingPieceX cross = new PlayingPieceX();
        playerList.add(new Player("Ramesh", cross));

        PlayingPieceO zero = new PlayingPieceO();
        playerList.add(new Player("Suresh", zero));
    }

    public String playGame(){
        boolean noWinner = true;
        while(noWinner){
            gameBoard.printBoard();

            List<Position> freeCells = gameBoard.getFreeCells();
            if(freeCells.isEmpty()){
                break;
            }

            Player currPlayer = playerList.removeFirst();
            System.out.print(currPlayer.getName() + " Please put position : ");

            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.parseInt(values[0]);
            int inputCol = Integer.parseInt(values[1]);

            boolean putPieceSuccessful = gameBoard.addPiece(inputRow, inputCol, currPlayer.getPiece());
            if(!putPieceSuccessful) {
                System.out.println("Incorred possition chosen, try again");
                playerList.addFirst(currPlayer);
                continue;
            }

            boolean isCurrWinner = isWinner(inputRow, inputCol, currPlayer.getPiece());
            if(isCurrWinner){
                System.out.println("Congrats, winner is : " + currPlayer.getName());
                return currPlayer.getName();
            }else {
                playerList.addLast(currPlayer);
            }

        }
        return "Game Tie";
    }

    private boolean isWinner(int row, int col, PlayingPiece piece){
        boolean fullInRow = true;
        boolean fullInCol = true;
        boolean fullInDiag = true;
        boolean fullInAntiDiag = true;

        for(int i = 0; i < gameBoard.size; i++){
            if(gameBoard.board[row][i] != piece){
                fullInRow = false;
                break;
            }
        }
        if(fullInRow) return true;

        for(int i = 0; i < gameBoard.size; i++){
            if(gameBoard.board[i][col] != piece){
                fullInCol = false;
                break;
            }
        }
        if(fullInCol) return true;

        for(int i = 0, j = 0; i < gameBoard.size && j < gameBoard.size; i++, j++){
            if(gameBoard.board[i][j] != piece) {
                fullInDiag = false;
                break;
            }
        }
        if(fullInDiag) return true;

        for(int i = 0, j = gameBoard.size - 1; i < gameBoard.size && j >= 0; i++, j--){
            if(gameBoard.board[i][j] != piece){
                fullInAntiDiag = false;
                break;
            }
        }
        if(fullInAntiDiag) return true;
        return false;
    }
}
