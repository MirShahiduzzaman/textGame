/**Mir Shahiduzzaman November 9*/
package Rooms;

import People.Monster;
import People.Person;

public class RookieRoom extends Room
{
    /**
     * Sets up the variables for RookieRoom
     * @param x row RookieRoom is in
     * @param y column RookieRoom is in
     */
    public RookieRoom(int x, int y)
    {
        super(x,y);
    }

    /**
     * Makes the player lose a turn upon entering. Does not affect the monster
     * Checks for whether there are two people in the room, which would mean GAME OVER
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x) {
        if(!(occupant == null))
        {
            System.out.println("THE MAD HORSEMAN CAUGHT YOU! TRY AGAIN.");
            System.exit(0);
        }

        occupant = x;
        strOccupant = x + "";
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);

        if(!(x instanceof Monster))
        {
            System.out.println("You are bombarded with memories and faint for one turn. The horseman has now moved " +
                    "twice!");
        }
    }

    /**
     * Shows where TRP is and if there's a Person in it, it shows the Person
     * @return M or P if someone is in the room and TRP if no one is in it
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
        return("TRP");
    }
}
