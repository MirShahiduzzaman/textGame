/**Mir Shahiduzzaman November 9*/
package Consumables;

import People.Person;

//fill with gainHealth and gainPotent
//gainHealth increases health or decreases health depends on int value
//gainPotent increases chance to move twice!
//Once you move twice 0% potent again
public interface Consumable
{
    void gainHealth(Person p);
    void foodImp(Person p);
    //void gainPotent(Person p, int gain);
}
