/**Mir Shahiduzzaman November 9*/
package Consumables;

import People.Person;

public class Apple implements Consumable{
    /**
     * increases Person's health by 10
     * @param p Person to add health to
     */
    public void gainHealth(Person p)
    {
        p.health += 10;
    }

    /**
     * Adds a random number from 1-5 to Person health
     * @param p Person to add health to
     */
    public void foodImp(Person p)
    {
        int gain = (int)(Math.random()*5+1);
        p.health += gain;
        System.out.println("You ate a healthy apple and gained " + (10 + gain) + " health as a bonus.");
        System.out.println("Health: " + p.health);
    }

    /**
     * Shows the apple on the map if its in a normal room
     * @return String Apple to represent an Apple
     */
    @Override
    public String toString()
    {
        return("Apple");
    }
}
