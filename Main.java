// Name: Raaid Rizwan

import java.io.*;
import java.util.*;
import javax.swing.*;

public class Main 
{
  static StudentList stuList;
  public static void main(String[] args) 
  {
    stuList = new StudentList();
    JFrame jput = new JFrame();
    int choice = -1;

    do
    {
      try
      {
        choice = Integer.parseInt(JOptionPane.showInputDialog(jput, "Enter your choice (integer only). \n0 - Exit Program. 1 - Display All Students. 2 - Display Specified Student. \n3 - Add Student. 4 - Remove Student. 5 - Edit Student Information. \n6 - Change Student Belt. 7 - Download Data. 8 - Save Data. \n9 - Sort by Alphabetical Order. 10 - Sort by Belt Order. \n11 - Sort by Age Order. 12 - Edit Student Belt Progress."));
      }
      catch(NumberFormatException e)
      {
        JOptionPane.showMessageDialog(jput, "Invalid Input.", "Error", JOptionPane.WARNING_MESSAGE);
        continue;
      }
      
      if(choice != 0)
      {
        jChooser(choice);
      }
    }
    while(choice != 0);
    
    JOptionPane.showMessageDialog(jput, "You have successfully exited the program.");
    System.exit(0);

  }

  public static void jChooser(int choice)
  {
    JFrame jput = new JFrame();
    
    String name;
    String newName;
    int beltIndex;
    int age;
    int currentIndex;
    Student findStu;
    boolean temp;

    switch(choice)
    {
      case 1:
        JOptionPane.showMessageDialog(jput, stuList.toString() + "\nTotal amount of Students: " + stuList.countStudent());
        break;

      case 2:
        name = (String) JOptionPane.showInputDialog(jput, "Enter Student name: ");
        Student findStudent = new Student(name);
        JOptionPane.showMessageDialog(jput, stuList.searchStudent(findStudent));
        break;

      case 3:
        name = (String) JOptionPane.showInputDialog(jput, "Enter Student name: ");
        beltIndex = Integer.parseInt(JOptionPane.showInputDialog(jput, "Enter Student Belt index: \n0 - White. 1 - Yellow. 2 - Orange. \n3 - Green. 4 - Blue. 5 - Red. 6 - Black."));
        age = Integer.parseInt(JOptionPane.showInputDialog(jput, "Enter Student Age: "));
        Student stu = new Student(name, beltIndex, age);
        stuList.addStudent(stu);
        break;

      case 4: 
        name = (String) JOptionPane.showInputDialog(jput, "Enter Student name: ");
        Student removeStu = new Student(name);
        JOptionPane.showMessageDialog(jput, stuList.removeStudent(removeStu));
        break;

      case 5:
        name = (String) JOptionPane.showInputDialog(jput, "Enter Student name: ");
        findStu = new Student(name);
        currentIndex = stuList.searchStudentBelt(findStu);
        if (currentIndex == -1)
          JOptionPane.showMessageDialog(jput, "Student not found.");
        else
        {
          newName = JOptionPane.showInputDialog(jput, "Enter new Student name: \nCurrent Student name is: " + stuList.returnStudent(findStu).getName());
          age = Integer.parseInt(JOptionPane.showInputDialog(jput, "Enter new Student age: \nCurrent Student age is: " + stuList.returnStudent(findStu).getAge()));
          JOptionPane.showMessageDialog(jput, stuList.returnStudent(findStu).editStudent(newName, age));
        }
        break;

      case 6:
        name = (String) JOptionPane.showInputDialog(jput, "Enter Student name: ");
        findStu = new Student(name);
        currentIndex = stuList.searchStudentBelt(findStu);
        if (currentIndex == -1)
          JOptionPane.showMessageDialog(jput, "Student not found.");
        else
        {
          beltIndex = Integer.parseInt(JOptionPane.showInputDialog(jput, "Enter Student Belt index: \n0 - White. 1 - Yellow. 2 - Orange. \n3 - Green. 4 - Blue. 5 - Red. 6 - Black." + "\nCurrent Belt Index: " + currentIndex));
          stuList.returnStudent(findStu).setBelt(beltIndex);
        }
        break;

      case 7:
        try
          {
            PrintWriter outFile = new PrintWriter(new File("list.txt"));
            outFile.print(stuList.saveToFile());
            outFile.close();
          }
          catch (IOException e)
          {
            JOptionPane.showMessageDialog(jput, "Failed to write data " + e, "Error", JOptionPane.WARNING_MESSAGE);
          }
        break;

      case 8:
        Scanner saved;
          try
          {
            saved = new Scanner(new File("list.txt"));
            while (saved.hasNext())
            {
              name = saved.nextLine();
              beltIndex = saved.nextInt();
              age = saved.nextInt();
              if (saved.hasNext())
                saved.nextLine();
              stuList.addStudent(new Student(name, beltIndex, age));
            }
          }
          catch (IOException e)
          {
            JOptionPane.showMessageDialog(jput, "Input read failed " + e, "Error", JOptionPane.WARNING_MESSAGE);
          }
        break;

      case 9:
        stuList.sortByName();
        break;

      case 10:
        stuList.sortByBelt();
        break;

      case 11:
        stuList.sortByAge();
        break;

      case 12:
        name = (String) JOptionPane.showInputDialog(jput, "Enter Student name: ");
        findStu = new Student(name);
        currentIndex = stuList.searchStudentBelt(findStu);
        if (currentIndex == -1)
          JOptionPane.showMessageDialog(jput, "Student not found.");
        else
        {
          temp = Boolean.parseBoolean(JOptionPane.showInputDialog(jput, "Set FORM to either 'true' or 'false'. \nWARNING: Anything other than 'true' will set the boolean to false. \nCurrent FORM is: " + stuList.returnStudent(findStu).getBeltList().getForm()));
          stuList.returnStudent(findStu).getBeltList().setForm(temp);
          
          temp = Boolean.parseBoolean(JOptionPane.showInputDialog(jput, "Set BLOCKS to either 'true' or 'false'. \nWARNING: Anything other than 'true' will set the boolean to false. \nCurrent BLOCKS are: " + stuList.returnStudent(findStu).getBeltList().getBlocks()));
          stuList.returnStudent(findStu).getBeltList().setBlocks(temp);

          temp = Boolean.parseBoolean(JOptionPane.showInputDialog(jput, "Set COMBINATION 1 to either 'true' or 'false'. \nWARNING: Anything other than 'true' will set the boolean to false. \nCurrent COMBINATION 1 is: " + stuList.returnStudent(findStu).getBeltList().getComb1()));
          stuList.returnStudent(findStu).getBeltList().setComb1(temp);

          temp = Boolean.parseBoolean(JOptionPane.showInputDialog(jput, "Set COMBINATION 1 to either 'true' or 'false'. \nWARNING: Anything other than 'true' will set the boolean to false. \nCurrent COMBINATION 2 is: " + stuList.returnStudent(findStu).getBeltList().getComb2()));
          stuList.returnStudent(findStu).getBeltList().setComb2(temp);

          temp = Boolean.parseBoolean(JOptionPane.showInputDialog(jput, "Set COMBINATION 3 to either 'true' or 'false'. \nWARNING: Anything other than 'true' will set the boolean to false. \nCurrent COMBINATION 3 is: " + stuList.returnStudent(findStu).getBeltList().getComb3()));
          stuList.returnStudent(findStu).getBeltList().setComb3(temp);
        }
        break;

      default:
        JOptionPane.showMessageDialog(jput, "Invalid Integer.", "Error", JOptionPane.WARNING_MESSAGE);
    }
  }
}