package Model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public int size;
    public PlayingPiece[][] board;

    public Board(int size){
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    //addPiece;
    //getFreeCells;

    public boolean addPiece(int row, int col, PlayingPiece piece){
        if(board[row][col] == null){
            board[row][col] = piece;
            return true;
        }
        return false;
    }

    public List<Position> getFreeCells(){
        List<Position> freePositions = new ArrayList<>();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[i][j] == null){
                    freePositions.add(new Position(i,j));
                }
            }
        }
        return freePositions;
    }

    public void printBoard() {
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[i][j] == null){
                    System.out.print("  |");
                }else {
                    System.out.print(board[i][j].pieceType.name());
                    System.out.print(" |");
                }
            }
            System.out.println();
        }
    }
}
