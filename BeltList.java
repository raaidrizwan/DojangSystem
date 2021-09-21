/*
0 - White
1 - Yellow
2 - Orange
3 - Green
4 - Blue
5 - Red
6 - Black
*/

/**
* A BeltList object has an array of 7 preset Belts with colors. There are no parameters needed to create it so the default Java constructor will be utilized.
*/
public class BeltList
{
  private Belt white = new Belt("WHITE");
  private Belt yellow = new Belt("YELLOW");
  private Belt orange = new Belt("ORANGE");
  private Belt green = new Belt("GREEN");
  private Belt blue = new Belt("BLUE");
  private Belt red = new Belt("RED");
  private Belt black = new Belt("BLACK");
  private Belt[] beltList = {white, yellow, orange, green, blue, red, black};
  
  //s

  /**
  * Returns a chosen belt from the beltList 
  * @param i the belt index integer 
  * @return the Belt specified by the index
  */
  public Belt get(int i)
  {
    return beltList[i];
  }

  public String getString(int i)
  {
    return beltList[i].toString();
  }
}