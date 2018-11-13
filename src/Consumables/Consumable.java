/**Mir Shahiduzzaman November 9*/
package Consumables;

import People.Person;

public interface Consumable
{
    /**
     * increases or decreases health based on the item
     * @param p Person to add or remove health from
     */
    void gainHealth(Person p);

    /**
     * adds or removes a random number from Person health
     * @param p Person to add or remove health from
     */
    void foodImp(Person p);
}
