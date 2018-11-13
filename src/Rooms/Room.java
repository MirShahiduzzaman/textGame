/**Mir Shahiduzzaman November 9*/
package Rooms;

import Consumables.Consumable;
import People.Monster;
import People.Person;

public abstract class Room
{
    public Consumable food = null;
    String strFood="";
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
     * Checks for whether there are two people in the room, which would mean GAME OVER
     * @param x the Person entering
     */
    public void enterRoom(Person x)
    {
        if(!(x instanceof Monster))
        {
            enter = true;
            System.out.println("\nYou enter a plain old room");
            if(!(food == null))
            {
                this.food.gainHealth(x);
                this.food.foodImp(x);
                this.food = null;
            }
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

    /**
     * Default return for Room, which is an unknown normal room until the player goes on it
     * @return ??? or NOR depending on whether the player entered the room and M or P if a Person is in the Room
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
        if(enter)
        {
          return("NOR");
        }
        else
        {
            if(!(this.food == null))
            {
                strFood = "" + this.food;
                return(strFood.substring(0,3).toUpperCase());
            }
            else {
                return ("???");
            }
        }
    }

}