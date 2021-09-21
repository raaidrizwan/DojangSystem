/** A Student has a name, a BeltList (storing their belts), a beltIndex (used to access the BeltList), an age, and an entranceDate
*/
public class Student
{
  private String name;
  private BeltList beltList = new BeltList();
  private int beltIndex;
  private int age;

  /** Constructs a Student object with a given name, a beltIndex and age of 0, and an entranceDate of "N/A" 
  * @param studentName the color of the Student 
  */
  public Student(String studentName)
  {
    name = studentName;
    beltIndex = 0;
    age = 0;
  }

  /** Constructs a Student object with a given name, belt, age 
  * @param studentName the name of the Student
  * @param studentBelt the belt of the Student 
  * @param studentAge the age of the Student  
  */
  public Student(String studentName, int studentBelt, int studentAge)
  {
    name = studentName;
    beltIndex = studentBelt;
    age = studentAge;
  }
  
  /** Formats the Student object when printed
  * @return the formatted String of the Student 
  */
  public String toString()
  {
    return "Name: " + name + "\nBelt: " + beltList.get(beltIndex).getName() + "\nAge: " + age;
  }

  public String showAllInfo()
  {
    return "Name: " + name + "\nAge: " + age + "\n" + beltList.get(beltIndex) + "\n\nIs this student eligible to test? " + beltList.get(beltIndex).testEligibility();
  }

  /** Changes the belt of the Student
  * @param index the new beltIndex
  */
  public void setBelt(int index)
  {
    beltIndex = index;
  }

  public String getName()
  {
    return name;
  }
  
  public int getBelt()
  {
    return beltIndex;
  }

  public Belt getBeltList()
  {
    return beltList.get(beltIndex);
  }

  public int getAge()
  {
    return age;
  }

  /** Edits Student information and returns new information 
  * @param studentName the name of the Student 
  * @param studentAge the age of the Student 
  * @return the new information of the Student
  */
  public String editStudent(String studentName, int studentAge)
  {
    name = studentName;
    age = studentAge;
    return "Student information has now been set to the following: " + "\nName: " + name + "\nAge: " + age;
  }

  /** Evaluates whether Students share names
  * @param o the name of the Object 
  * @return whether the Object and Student share names
  */
  public boolean equals(Object o)
  {
  	Student other = (Student) o;
    return this.name.equals(other.name);
  }

  /** Compares Objects based on their names 
  * @param o the name of the Object 
  * @return comparison between Object and Student names
  */
  public int compareTo(Object o)
  {
    Student other = (Student) o;
    return this.name.toUpperCase().compareTo(other.name.toUpperCase());
  }

  /** Compares Objects based on their belts 
  * @param o the name of the Object 
  * @return comparison between Object and Student belts
  */
  public int compareToByBelt(Object o)
  {
    Student other = (Student) o;
    return (int) (beltIndex - other.beltIndex);
  }

  /** Compares Objects based on their ages 
  * @param o the name of the Object 
  * @return comparison between Object and Student belts
  */
  public int compareToByAge(Object o)
  {
    Student other = (Student) o;
    return (int) (age - other.age);
  }

  public String saveToFile()
      {
        return name + "\n" + beltIndex + "\n" + age;
      }
}