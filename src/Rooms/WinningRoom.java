/**Mir Shahiduzzaman November 9*/
package Rooms;

import Game.Runner;
import People.Monster;
import People.Person;

public class WinningRoom extends Room
{

    /**
     * sets the coordinates of the Room
     * @param x the row the Winning Room is in
     * @param y the column the Winning Room is in
     */
    public WinningRoom(int x, int y) {
        super(x, y);

    }

    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x) {
        if(!(x instanceof Monster))
        {
            occupant = x;
            strOccupant = x + "";
            x.setxLoc(this.xLoc);
            x.setyLoc(this.yLoc);
            System.out.println("\nYou found the winning room! You're safe for now.");
            Runner.gameOff();
        }
    }

    /**
     * Distinguishes the WinningRoom on the map
     * @return String WIN to represent the WinningRoom or M or P to represent who is in the Room if there is one
     */
    @Override
    public String toString()
    {
        if(!(strOccupant==null))
        {
            if(occupant instanceof Monster)
            {
                return(" M ");
            }
            else
            {
                return(" P ");
            }
        }
        return("WIN");
    }

}