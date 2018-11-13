/**Mir Shahiduzzaman November 9*/
package Consumables;

import People.Person;

public class Candy implements Consumable{
    /**
     * decreases Person's health by 4
     * @param p Person to remove health from
     */
    public void gainHealth(Person p)
    {
        p.health -= 4;
    }

    /**
     * Removes a random number from 0-4 from Person health
     * @param p Person to remove health from
     */
    public void foodImp(Person p)
    {
        int loss = (int)(Math.random()*5);
        p.health -= loss;
        System.out.println("You ate candy and now have cavities. You lost " + (4+loss) + " health as a result.");
        System.out.println("Health: " + p.health);
    }

    /**
     * Shows the candy on the map if its in a normal room
     * @return String Candy to represent a Candy
     */
    @Override
    public String toString()
    {
        return("Candy");
    }
}
