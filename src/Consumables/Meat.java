/**Mir Shahiduzzaman November 9*/
package Consumables;

import People.Person;

public class Meat implements Consumable{
    /**
     * increases Person's health by 5
     * @param p Person to add health to
     */
    public void gainHealth(Person p)
    {
        p.health += 5;
    }

    /**
     * Adds a random number from 0 to 5 to Person health
     * @param p Person to add health to
     */
    public void foodImp(Person p)
    {
        int gain = (int)(Math.random()*5);
        p.health += gain;
        System.out.println("You ate some buff meat and gained " + (5+gain) + "health as a bonus.");
        System.out.println("Health: " + p.health);
    }

    /**
     * Shows the meat on the map if its in a normal room
     * @return String meat to represent meat
     */
    @Override
    public String toString()
    {
        return("Meat");
    }
}
