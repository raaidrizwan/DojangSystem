import java.util.*;
import java.io.*;

/**
* The StudentList organizes and manages a set of Students using methods. It has an ArrayList to aid in this process.
*/
public class StudentList
{
  private ArrayList<Student> studentList;

  /**
  * Constructs an empty StudentList 
  */
  public StudentList()
  {
    studentList = new ArrayList<Student>();
  }

  /** Formats the StudentList when printed
  * @return the formatted String of the StudentList 
  */
  public String toString()
  {
    String output = "";
    for (Student e : studentList)
      output += e + "\n";
    return output;
  }
  
  /**
  * addStudent adds a Student to the List 
  * @param name the Student being added
  */
  public void addStudent(Student name)
  {
    studentList.add(name);
  }

  /** 
	 * removeStudent removes a specified Student from the List if it exists and returns true.
	 * If the Student does not exist in the List, returns false.
	 * @param name the Student to search for and remove
	 * @return whether the Student was removed
	 */
	public String removeStudent(Student name)
  {
    boolean studentExist = studentList.remove(name);
    if (studentExist == true)
      return "Student successfully removed.";
    else
      return "Student not found.";
  }

  /**
  * countStudent counts the number of Students in the List
  * @return the number of Students in the List
  */
  public int countStudent()
  {
    return studentList.size();
  }

  public Student returnStudent(Student name)
  {
    int studentIndex = studentList.indexOf(name);
    return studentList.get(studentIndex);
  }

  public String searchStudent(Student findStudent)
  {
    int studentIndex = studentList.indexOf(findStudent);
    if(studentIndex == -1)
      return "Student not found.";
    else
      return studentList.get(studentIndex).showAllInfo();
  }

  public int searchStudentBelt(Student findStudent)
  {
    int studentIndex = studentList.indexOf(findStudent);
    if(studentIndex == -1)
      return -1;
    else
      return studentList.get(studentIndex).getBelt();
  }

  /**
  * Sorts the List in alphabetical order
  */
  public void sortByName()
  {
    for (int i = 1; i < studentList.size(); i++)
      for (int pos = 0; pos < studentList.size() - 1; pos++)
      {
        if (studentList.get(pos).compareTo(studentList.get(pos+1)) > 0)
        {
          Student temp = studentList.get(pos);
          studentList.set(pos, studentList.get(pos+1));
          studentList.set(pos+1, temp);
        }
      }
  }

  /**
  * Sorts the List in Belt order 
  */
  public void sortByBelt()
  {
    for (int i = 1; i < studentList.size(); i++)
      for (int pos = 0; pos < studentList.size() - 1; pos++)
      {
        if (studentList.get(pos).compareToByBelt(studentList.get(pos+1)) > 0)
        {
          Student temp = studentList.get(pos);
          studentList.set(pos, studentList.get(pos+1));
          studentList.set(pos+1, temp);
        }
      }
  }

  /**
  * Sorts the List in Age order 
  */
  public void sortByAge()
  {
    for (int i = 1; i < studentList.size(); i++)
      for (int pos = 0; pos < studentList.size() - 1; pos++)
      {
        if (studentList.get(pos).compareToByAge(studentList.get(pos+1)) > 0)
        {
          Student temp = studentList.get(pos);
          studentList.set(pos, studentList.get(pos+1));
          studentList.set(pos+1, temp);
        }
      }
  }

  public String saveToFile()
  {
    String output = "";
    for (Student e : studentList)
      output += e.saveToFile() +"\n";
    return output;
  }
}