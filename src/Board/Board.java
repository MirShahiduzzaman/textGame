package Board;

public class Board
{
    String[][] chessBoard;
    String showBoard = "";

    public Board(String[][] chessBoard)
    {
        this.chessBoard = chessBoard;
    }

    /**
     * fills in the private array chessBoard with a string
     * @param str string that will fill in all spaces in chessBoard
     */
    public void fill(java.lang.String str)
    {
        for(int i = 0;i<this.chessBoard.length;i++)
        {
            for(int a = 0;a<this.chessBoard[i].length;a++)
            {
                chessBoard[i][a] = str;
            }
        }
    }

    @Override
    public String toString()
    {
        for(int i = 0;i<chessBoard.length;i++)
        {
            for(int a = 0;a<chessBoard[i].length;a++)
            {
                showBoard += "{ " + chessBoard[i][a] + " }";
            }
            showBoard += "\n";
        }
        return(showBoard);
    }
}
