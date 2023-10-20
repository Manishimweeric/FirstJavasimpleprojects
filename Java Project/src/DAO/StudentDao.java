package DAO;
import Model.*;
import java.sql.*;
import  java.util.*;
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author M NJERIC
 */
public class StudentDao {
    //global declaration
    private static String dburl="jdbc:mysql://localhost:3306/tuesday_morning_db";
    private static   String username="root";
    private  static  String password="";
   
     /////// default constructor
    public StudentDao() {
    }
    
    /////CRUD Operations/////
    
    //Insert
    public  String registerStudent(Student studentobject){
        
        try{
            
            ///create connection
            Connection con= DriverManager.getConnection(dburl,username,password);
            Statement st= con.createStatement();
            String sql="insert into student(student_id,first_name,last_name) values('"+studentobject.getStudentId()+"','"+studentobject.getFirstnName()+"','"+studentobject.getLastName()+"')";
            ///execute query
            int rowaffected=st.executeUpdate(sql);
            con.close();
            if(rowaffected>=1){
                
                return"Insert Successfulll";
                
                
            }else{
                return"Fail to insert";
            }
            
           
        
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
         
            
        
        
        
        
        return"Server error";       
    }
    
      public  String registerStudentbyusingprepared(Student studentobject){
        
        try{
            
            ///create connection
            Connection con= DriverManager.getConnection(dburl,username,password);
            ///create preapared statement
             String sql="insert into student(student_id,first_name,last_name) values(?,?,?)";
             PreparedStatement pst=con.prepareStatement(sql);
             ///1.insert values inside the ?
             //2.Each ?mark a posion start from 1
             pst.setString(1,studentobject.getStudentId());
             pst.setString(2,studentobject.getFirstnName());
             pst.setString(3,studentobject.getLastName());
            Statement st= con.createStatement();
            ///execute query
            int rowaffected=pst.executeUpdate();
            con.close();
            if(rowaffected>=1){
                return"Insert Successfulll";
  
            }else{
                return"Fail to insert";
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return"Server error";       
    }
      
      /////////////////updated 
   
      public static void update(Student studentobject){
          try{
          Connection con= DriverManager.getConnection(dburl,username,password);
            ///create preapared statement
             String sql="UPDATE STUDENT SET first_name=?,last_name=? where student_id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            ///1.insert values inside the ?
             //2.Each ?mark a posion start from 1
             pst.setString(3,studentobject.getStudentId());
             pst.setString(1,studentobject.getFirstnName());
             pst.setString(2,studentobject.getLastName());
         
            ///execute query
            int rowaffected=pst.executeUpdate();
            con.close();
            if(rowaffected>=1){
                
                 System.out.println("Update Successfulll");
                
                
            }else{
               System.out.println("Fail to updated");
            }
            
          
          
          
                         
                     }catch(Exception e){
                         e.printStackTrace();
                     }               
          
      }
                
       ///////////////display data/////////////////////////////////
      public List<Student> retrieveData() {
        List<Student> data = new ArrayList<>();
           try{
            
             Connection con= DriverManager.getConnection(dburl,username,password);
          String query = "SELECT * FROM student";
            PreparedStatement statement =con.prepareStatement(query);
        
             ResultSet resultSet = statement.executeQuery();
              
             boolean found=false;
             
             int count=0;
             
             
            
             System.out.println("LIST OF ALL STUDENT WE HAVE  ");
             System.out.println("================================");
             System.out.println( "No FIRST NAME  \tLAST NAME \tSTUDENT_ID ");
            while (resultSet.next()) {
                
                
                count+=1;
                Student model = new Student();
                model.setStudentId(resultSet.getString("student_id"));
                model.setFirstnName(resultSet.getString("first_name"));
                model.setLastName(resultSet.getString("last_name"));
                data.add(model);                             
                System.out.println(count+"   "+model.getFirstnName()+"\t"+ model.getLastName()+"\t\t"+model.getStudentId());
                
                found=true;
            }
            
            if(!found){
                System.err.println("Not data Found");
            }
            
             
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
      
    //////////////////delete data ///////////////////////////
      
        public static void delete(Student studentobject){
           
          
          
          try{
          Connection con= DriverManager.getConnection(dburl,username,password);
            ///create preapared statement
             String sql="DELETE FROM STUDENT  where student_id=?";
             PreparedStatement pst=con.prepareStatement(sql);
           
            pst.setString(1,studentobject.getStudentId());
            
          
            ///execute query
            int rowaffected=pst.executeUpdate();
            con.close();
            if(rowaffected>=1){
                
                 System.out.println("Data Deleted Successfulll");
                
                
            }else{
               System.out.println("your Id Is not Exist");
            }
    
                     }catch(Exception e){
                         e.printStackTrace();
                     }               
                }
        
        ////////////////////////////////////////////////////////search/
        
        public List<Student> searchData( Student studentobject) {
        List<Student> data = new ArrayList<>();
           try{
         Connection con= DriverManager.getConnection(dburl,username,password);
          String query = "SELECT * FROM student where student_id=?";
            PreparedStatement statement =con.prepareStatement(query);
            statement.setString(1,studentobject.getStudentId());
            
            ResultSet resultSet = statement.executeQuery();
             if(resultSet.next()){              
              System.out.println("LIST OF ALL STUDENT WE HAVE  ");
             System.out.println("================================");
             System.out.println( "FIRST NAME  \tLAST NAME \tSTUDENT_ID ");
                Student model = new Student();
                model.setStudentId(resultSet.getString("student_id"));
                model.setFirstnName(resultSet.getString("first_name"));
                model.setLastName(resultSet.getString("last_name"));
                data.add(model);                             
                System.out.println(model.getFirstnName()+"\t\t"+ model.getLastName()+"\t\t"+model.getStudentId());
             }else{
                 System.out.println("Your StudentId is Not Exist");
             }
        } catch (SQLException e) {
            e.printStackTrace();
             System.err.println("SQL Exception: " + e.getMessage());
        }

        return data;
    }
      
      
      
      
      
      
      
    
    
    
       
    
}
