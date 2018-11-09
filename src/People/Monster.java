/**Mir Shahiduzzaman November 9*/
package People;

/**
 * Monster chases person and is shown on the map name: Mad HorseMan
 */
public class Monster extends Person
{
    /**
     * sets up Monster Class
     * @param firstName first name of monster
     * @param familyName last name of monster
     * @param xLoc the row the monster is in
     * @param yLoc the column the monster is in
     */
    public Monster (String firstName, String familyName, int xLoc, int yLoc)
    {
        super(firstName,familyName,xLoc,yLoc);
    }
}
