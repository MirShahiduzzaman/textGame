package Board;


import Rooms.Room;

public class Board
{
    private Room[][] map;
    String showBoard = "";

    boolean s;

    public Board(Room[][] map)
    {
        this.map = map;
    }

    public Board(int height,int width)
    {
        map = new Room[height][width];
    }

    public void addRoom(int row,int column,Room r)
    {
        map[row][column] = r;
    }

    public void changeS()
    {
        s =false;
    }

    @Override
    public String toString()
    {
        for(int i = 0;i<map.length;i++)
        {
            for(int a = 0;a<map[i].length;a++)
            {
                if(!s)
                {
                    showBoard += "wow";
                }
                showBoard += "{ " + map[i][a] + " }";
            }
            showBoard += "\n";
        }
        return(showBoard);
    }
}
