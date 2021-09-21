// Name: Raaid Rizwan
/** A Belt object has a color and five booleans (form, blocks, and three kicking combinations) signalling education progress
*/
public class Belt
{
  private String color;
  private boolean form;
  private boolean blocks;
  private boolean comb1;
  private boolean comb2;
  private boolean comb3;

  /** Constructs a Belt object with a given color and all booleans set to false 
  * @param beltName the color of the Belt 
  */
  public Belt(String beltName)
  {
    color = beltName;
    form = false;
    blocks = false;
    comb1 = false;
    comb2 = false;
    comb3 = false;
  }

  /** Formats the Belt object when printed
  * @return the formatted String of the Belt 
  */
  public String toString()
  {
    return "Color: " + color + "\nForm? " + form + "\nBlocks? " + blocks + "\nCombination 1? " + comb1 + "\nCombination 2? " + comb2 + "\nCombination 3? " + comb3;
  }

  public String getName()
  {
    return color;
  }

  public boolean getForm()
  {
    return form;
  }

  public boolean getBlocks()
  {
    return blocks;
  }

  public boolean getComb1()
  {
    return comb1;
  }

  public boolean getComb2()
  {
    return comb2;
  }

  public boolean getComb3()
  {
    return comb3;
  }

  /** Sets the form boolean to the specified input
  * @param input the boolean to set the form to 
  */
  public void setForm(boolean input)
  {
    form = input;
  }
  
  /** Sets the blocks boolean to the specified input
  * @param input the boolean to set the blocks to 
  */
  void setBlocks(boolean input)
  {
    blocks = input;
  }

  /** Sets the comb1 boolean to the specified input
  * @param input the boolean to set the comb1 to 
  */
  void setComb1(boolean input)
  {
    comb1 = input;
  }

  /** Sets the comb2 boolean to the specified input
  * @param input the boolean to set the comb2 to 
  */
  void setComb2(boolean input)
  {
    comb2 = input;
  }

  /** Sets the comb3 boolean to the specified input
  * @param input the boolean to set the comb3 to 
  */
  void setComb3(boolean input)
  {
    comb3 = input;
  }

  /**
  * Checks if Student is eligible for promotion based on Belt info
  * @return if all booleans are set to true or not
  */
  public boolean testEligibility()
  {
    if(form == true && blocks == true && comb1 == true && comb2 == true && comb3 == true)
      return true; 
    else 
      return false;
  }
}