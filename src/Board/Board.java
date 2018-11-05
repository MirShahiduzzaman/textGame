/**Mir Shahiduzzaman November 5*/
package Board;

import Rooms.Room;

public class Board
{
    private Room[][] map;
    //maybe use boolean to change room status and maybe set it up in the room class!!

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

    @Override
    public String toString()
    {
        String showBoard = "";
        for(int i = 0;i<map.length;i++)
        {
            for(int a = 0;a<map[i].length;a++)
            {
                showBoard += "{ " + map[i][a] + " }";
            }
            showBoard += "\n";
        }
        return(showBoard);
    }
}
