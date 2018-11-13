/**Mir Shahiduzzaman November 9*/
package People;

/**
 * Person represents the player as they move through the game.
 */
public class Person {
    String firstName;
    String familyName;
    int xLoc, yLoc;
    public int health = 1;

    /**
     * Gets the row the specified Person is in
     * @return an int representing the row the Person is in
     */
    public int getxLoc() {
        return xLoc;
    }

    /**
     * Sets the row a Person is in
     * @param xLoc row to move the Person to
     */
    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    /**
     * Gets the column the specified Person is in
     * @return int representing the column the Person is in
     */
    public int getyLoc() {
        return yLoc;
    }

    /**
     * Sets the column a Person is in
     * @param yLoc column to move the Person to
     */
    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    /**
     * Sets up all of the main aspects of the Person
     * @param firstName the first name of the Person
     * @param familyName the last name of the Person
     * @param xLoc the row the Person is in
     * @param yLoc the column the Person is in
     */
    public Person (String firstName, String familyName, int xLoc, int yLoc)
    {
        this.firstName = firstName;
        this.familyName = familyName;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
    }

    /**
     * Sets up all of the main aspects of the Person and the health
     * @param firstName the first name of the Person
     * @param familyName the last name of the Person
     * @param xLoc the row the Person is in
     * @param yLoc the column the Person is in
     * @param health the HP of the Person
     */
    public Person (String firstName, String familyName, int xLoc, int yLoc, int health)
    {
        this.firstName = firstName;
        this.familyName = familyName;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.health = health;
    }
}