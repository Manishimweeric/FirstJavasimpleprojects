package View;

import DAO.*;
import Model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author M NJERIC
 */
public class StudentMgtSyastemUI {
    
    public static void main(String[] args) {
        
        boolean condition=true;
        String  studentId="";
        String firstname;
        String lastname;
        while(condition){
                         System.out.println("=====================================");
             System.out.println("STUDENT MANAGEMENT SYSTEM :");
             System.out.println("-------------------------");
             System.out.println("1.Register Stududent ");          
             System.out.println("2.Update Stududent ");
             System.out.println("3.Delete Stududent ");
             System.out.println("4.Retrive Student ");
             System.out.println("5.Search Student by ID");
              System.out.println("0. Exist");
             System.out.println("------------------------");
             System.out.print("Choose : ");
             int choice;
             Scanner input= new Scanner(System.in);
             StudentDao upstudDao=new StudentDao();
              Student stud= new Student();
             choice= input.nextInt();
             String answer;
              int count;
             boolean valid = false;

             switch(choice){
                 
                 case 1:
                     while (!valid) {
                       System.out.print("Enter Student  ID :");
                        studentId=input.next();
                         count=studentId.length();
            
                         if(count==5){
                               System.out.println("Success your Id is 5 digit");
                               if (studentId.matches("\\d{5}")) {
                                 valid = true;
                                System.out.println("Success You Student ID is only numbers : " );
                               }else{
                        System.err.println("You Student ID should be a number only Try Again !!!"); 
                        }
                        } else {
                        System.err.println("Invalid input. Please enter a 5-digit number Try Again!!!");
                        }
                        }

                     
                     System.out.print("Enter First_Name :");
                     firstname=input.next();
                     System.out.print("EnterLast_name :");
                     lastname=input.next();
                     stud=new Student();
                     stud.setStudentId(studentId);
                     stud.setFirstnName(firstname);
                     stud.setLastName(lastname);
                     StudentDao stdao=new StudentDao();
                     String feedback=stdao.registerStudentbyusingprepared(stud);
                     System.out.println(feedback);
                                         
                     System.out.println("Enter yes/No continues or exist  : ");
                     
                         answer= input.next();
                         if(answer.equalsIgnoreCase("yes")){
                             condition=true;
                         }else{
                             
                             System.out.println("Thinks your using the system");
                             condition=false;
                         }
         
                     
                     break;
                     
                 case 2:
                     
                     
                     while (!valid) {
                      System.out.print("Enter exist StudentID your want to update  :");
                        studentId=input.next();
                         count=studentId.length();
            
                         if(count==5){
                               System.out.println("Success your Id is 5 digit");
                               if (studentId.matches("\\d{5}")) {
                                 valid = true;
                                System.out.println("Success You Student ID is only numbers : " );
                               }else{
                        System.err.println("You Student ID should be a number only Try Again !!!"); 
                        }
                        } else {
                        System.err.println("Invalid input. Please enter a 5-digit number Try Again!!!");
                        }
                        }
                     
                    
                     System.out.print("Enter New or Old First_Name :");
                     firstname=input.next();
                     System.out.print("Enter New or Old Last_name :");
                     lastname=input.next();
                     Student st= new Student();
                     st.setStudentId(studentId);
                     st.setFirstnName(firstname);
                     st.setLastName(lastname);
                    
                     upstudDao.update(st);
                      System.out.println("Enter yes/No continues or exist  : ");
                     
                         answer= input.next();
                         if(answer.equalsIgnoreCase("yes")){
                             condition=true;
                         }else{
                             
                             System.out.println("Thinks your using the system");
                             condition=false;
                         }
                     
                     break;
                 case 3:
                      while (!valid) {
                     System.out.print("Enter Your StudentID your want to Delete :");
                        studentId=input.next();
                         count=studentId.length();
            
                         if(count==5){
                               System.out.println("Success your Id is 5 digit");
                               if (studentId.matches("\\d{5}")) {
                                 valid = true;
                                System.out.println("Success You Student ID is only numbers : " );
                               }else{
                        System.err.println("You Student ID should be a number only Try Again !!!"); 
                        }
                        } else {
                        System.err.println("Invalid input. Please enter a 5-digit number Try Again!!!");
                        }
                        }
                     stud.setStudentId(studentId);
                     
                     upstudDao.delete(stud);
                     break;
                 case 4:
                       List<Student> data = new ArrayList<>();
                       
          
                      upstudDao.retrieveData();
                     
                     break;
                             
                 case 5:
                        while (!valid) {
                    System.out.print("Enter Your StudentID your want to Search :");
                        studentId=input.next();
                         count=studentId.length();
                          if(count==5){
                               System.out.println("Success your Id is 5 digit");
                               if (studentId.matches("\\d{5}")) {
                                 valid = true;
                                System.out.println("Success You Student ID is only numbers : " );
                               }else{
                        System.err.println("You Student ID should be a number only Try Again !!!"); 
                        }
                        } else {
                        System.err.println("Invalid input. Please enter a 5-digit number Try Again!!!");
                        }
                        }
                     stud.setStudentId(studentId);
                     
                     upstudDao.searchData(stud);
                     
                     
                     break;
                case 0:
                     System.out.println("Thanks for using the system");
                      System.exit(0);
                     break ;             
                 default:
                     
                 
             }     
             
             
             
        }
        
        
        
    }
    
    
}
