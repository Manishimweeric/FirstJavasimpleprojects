package Model;

/**
 *
 * @author M NJERIC
 */
public class Student {
    //private variables
    private String studentId;
    private String firstnName;
    private String lastName;
    //constractor with  no arg
    public Student(String studentId, String firstnName, String lastName){
        this.studentId = studentId;
        this.firstnName = firstnName;
        this.lastName = lastName;
  
    }
    public Student() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstnName() {
        return firstnName;
    }

    public void setFirstnName(String firstnName) {
        this.firstnName = firstnName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
    
    
    
    
     

     
    
}
