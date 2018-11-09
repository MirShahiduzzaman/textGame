/**Mir Shahiduzzaman November 9*/
package Rooms;

import People.Monster;
import People.Person;

public abstract class Room
{
    String strOccupant;
    Person occupant;
    int xLoc,yLoc;
    boolean enter;

    /**
     * Sets x and y to the specified values
     * @param x the number of rows
     * @param y the number of columns
     */
    public Room(int x, int y)
    {
        xLoc = x;
        yLoc = y;
    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    public void enterRoom(Person x)
    {
        if(!(x instanceof Monster))
        {
            enter = true;
            System.out.println("You enter a plain old room");
        }

        if(occupant == null)
        {
            occupant = x;
        }
        else
        {
            System.out.println("THE MAD HORSEMAN CAUGHT YOU! TRY AGAIN.");
            System.exit(0);
        }

        strOccupant = x + "";
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }

    /**
     * Removes the player from the room.
     * @param x name of person leaving the room
     */
    public void leaveRoom(Person x)
    {
        occupant = null;
        strOccupant = null;
    }

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
        if(enter)
        {
          return("NOR");
        }
        else
        {
            return ("???");
        }
    }

}