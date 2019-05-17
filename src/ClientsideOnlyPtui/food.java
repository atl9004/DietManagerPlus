package ClientsideOnlyPtui;

/***
 * This abstract class represents any sort of food.
 *
 * @Author Aidan Lear, 5/15/2019, atl9004@rit.edu
 */

public abstract class Food {

    int cal;
    String name;

    public Food(String name, int calories){
        cal = calories;
        this.name = name;
    }


    public int getCal(){
        return this.cal;
    }

    public String getName(){
        return this.name;
    }

}
