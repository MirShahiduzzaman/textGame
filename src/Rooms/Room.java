/**Mir Shahiduzzaman November 5*/
package Rooms;

import People.Person;

public class Room {
    String strOccupant;
    Person occupant;
    int xLoc,yLoc;

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
        System.out.println("You enter a plain old room");
        occupant = x;
        strOccupant = x + "";
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }

    /**
     * Removes the player from the room.
     * @param x
     */
    public void leaveRoom(Person x)
    {
        strOccupant = null;
        occupant = null;
    }

    @Override
    public String toString()
    {
        if(!(strOccupant==null))
        {
            return("P");
        }
        return("NR");
    }

}