
public class Board  {


    private int rows;
    private int cols;
    
    /** The grid of pieces */
    private Player[][] grid;
    
    

    public Board(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        grid = new Player[rows][cols];
        //set each cell to null
        reset();

    }
    
    public void reset() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = null;
            }
        }
    }
    
    public int getRows() {
        return rows;
    }
    
    public int getCols() {
        return cols;
    }
    
    
    /**
    * Returns the Player whose piece occupies the given location, 
    * @param row int
    * @param col int
    */
    public Player getCell(int row, int col ) throws IndexOutOfBoundsException{
        if( (row < 0) || (col < 0) || (row >= rows) || (col >= cols) ) {
            throw new IndexOutOfBoundsException();
        } else {
            return grid[row][col];
        }
    }
    
    //returns true if there are no more plays left
    // public boolean boardFilled(){
    //     //TODO: write this
    //     for (int i = 0; i < grid[0].length; i++){
    //         if (grid[0][i] == null){
    //             return false;
    //         }
    //     }

    //     return true; 
    // }
    public boolean boardFilled(){
        for(int c = 0; c < cols; c++){
            if(grid[grid.length - 1][c] == null){
                return false;
            }
        }
        return true; 
    }

    // Returns true if move is possible given board state.  
    public boolean possibleMove(Move move) {
        // TODO: write this.  Right now, it ignores filled columns, claiming any move is possible
        int col = move.getColumn();
        for (int i = grid.length-1; i >= 0; i++){
            if (grid[i][col] == null){
                return true;
            }

        }
        return false;
    }
    
    // Adds a piece to the board for a given Move
    public void addPiece(Move move) {
        //TODO: this is a test stub, you need to rewrite this.
    	//grid[0][move.getColumn()] = move.getPlayer();
        int col = move.getColumn();
        if (possibleMove(move)){
            for (int i = 0; i < grid.length; i++){
                if (grid[i][col] == null){
                    grid[i][col] = move.getPlayer();
                    break;
                }
    
            }
        }
    }

    // if the board contains a winning position, returns the Player that wins.
    // Otherwise, returns null.  You could ignore lastMove.
    
    // public Player winner(Move lastMove) {
    //     // TODO: write this.  Currently, there is never a winnder.
    //     for (int r = 0; r < grid.length; r++){
    //         for(int c = 3; c < grid[0].length; c++){
    //             if(grid[r][c - 3] == grid[r][c - 2] && grid[r][c - 2] == grid[r][c-1] && grid[r][c-1]== grid[r][c]){
    //                 return grid[r][c];
    //             }

    //         }
    //     }

    //     for (int r = 3; r < grid.length; r++){
    //         for(int c = 0; c < grid[0].length; c++){
    //             if(grid[r-3][c] == grid[r-2][c] && grid[r-2][c] == grid[r-1][c] && grid[r-1][c]== grid[r][c]){
    //                 return grid[r][c];
    //             }

    //         }

    //     }
    //     for (int r = 0; r < grid.length - 3; r++){
    //         for (int c = 0; c < grid[0].length - 3; c++){
    //             if (grid[r][c] == grid[r+1][c+1] && grid[r+1][c+1] == grid[r+2][c+2] && grid[r+2][c+2]== grid[r+3][c+3]){
    //                 return grid[r][c];
    //             }
    //         }
    //     }



        

    //     return null;
    // }
   
    public Player winner(Move lastMove) {
        for(int r = grid.length - 1; r >= 0; r--){
            for(int c = 0; c < grid[r].length; c++){
                Player z = grid[r][c];
                if(z != null) {
                    if(c + 3 < cols && z == grid[r][c + 1] && z == grid[r][c + 2] && z == grid[r][c + 3]) {
                        return z;
                    }
                    if(r - 3 >= 0 && z == grid[r - 1][c] && z == grid[r - 2][c] && z == grid[r - 3][c]) {
                        return z;
                    }
                    if(r - 3 >= 0 && c + 3 < cols && z == grid[r - 1][c + 1] && z == grid[r - 2][c + 2] && z == grid[r - 3][c + 3]) {
                        return z;
                    }
                    if(r + 3 < rows && c + 3 < cols && z == grid[r + 1][c + 1] && z == grid[r + 2][c + 2] && z == grid[r + 3][c + 3]) {
                        return z;
                    }
                }
            }
        }
        return null;
    }
    
    
} // end Board class
