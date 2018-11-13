/**Mir Shahiduzzaman November 9*/
package Consumables;

import People.Person;

public class ExpiredMilk implements Consumable{
    /**
     * decreases Person's health by 10
     * @param p Person to remove health from
     */
    public void gainHealth(Person p)
    {
        p.health -= 10;
    }

    /**
     * Removes a random number from 11 to 15 from Person health
     * @param p Person to remove health from
     */
    public void foodImp(Person p)
    {
        int loss = (int)(Math.random()*5+11);
        p.health -= loss;
        System.out.println("RIP, that milk was expired! You now have a stomachache and as a result, you lost " + (10+loss) + " health.");
        System.out.println("Health: " + p.health);
    }

    /**
     * Shows the milk on the map if its in a normal room
     * @return String Milk to represent milk
     */
    @Override
    public String toString()
    {
        return("Milk");
    }
}
