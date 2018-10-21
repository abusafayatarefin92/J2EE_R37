
package test;

import dao.StudentDAO;
import domain.Student;
import service.StudentDAOImpl;

public class Test {
    public static void main(String[] args) {
        String sql = "create table student(id number(5) primary key, name varchar2(30))";
        StudentDAO obj = new StudentDAOImpl();
        //obj.creteTable(sql);
        Student s = new Student();
        s.setId(1);
        s.setName("Arefin");
      //  obj.insert(s);
      //obj.update(s);
     // obj.delete(s);
     Student st = obj.getById(1);
        System.out.println("ID: " + st.getId()+ " Name: " + st.getName());
        for (Student stu : obj.getStudents()) {
            System.out.println("ID: " + stu.getId() + " Name: " + stu.getName());
       }
        
    }
}
