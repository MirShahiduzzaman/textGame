/**Mir Shahiduzzaman November 9*/
package Board;

import Consumables.Consumable;
import Rooms.Room;

public class Board
{
    private Room[][] map;

    /**
     * sets map equal to a 2D array of Rooms
     * @param map a 2D array of Rooms
     */
    public Board(Room[][] map)
    {
        this.map = map;
    }

    /**
     * sets map to have the specified height and width
     * @param height the number of rows in the map
     * @param width the number of columns in the map
     */
    public Board(int height,int width)
    {
        map = new Room[height][width];
    }

    /**
     * replaces the specified space in the 2D array with a Room
     * @param row the row to add a Room to
     * @param column the column to add a Room to
     * @param r the Room that will be placed in the specified location
     */
    public void addRoom(int row,int column,Room r)
    {
        map[row][column] = r;
    }
    public void addFood(int row, int column, Consumable c)
    {
        map[row][column].food = c;
        System.out.println(map[row][column].food);
    }

    /**
     * Prints out map
     * @return a String, which will be displayed in the terminal to look like a map
     */
    @Override
    public String toString()
    {
        String showBoard = "\n";
        for(int i = 0;i<map.length;i++)
        {
            for(int a = 0;a<map[i].length;a++)
            {
                showBoard += "{ " + map[i][a] + " }";
            }
            showBoard += "\n";
        }
        showBoard += "Key\nP=You  M=Mad Horseman  BED=Bedroom  NOR=Normal Room  STR=Strategy Room  WIN=Win Room  " +
                "TRP=Trap Room\n";
        return(showBoard);
    }
}
