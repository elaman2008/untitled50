package service;

import models.Lesson;
import models.Student;

import java.util.Set;

public interface StudentService  {
    String addNewStudents (Student newStudent, String groupName);
    String update (Long studentId);
    Student findStudentByFirstName (String firstName);
    Set<Student> getAllStudentsByGroupName (String groupName);
    Set<Lesson>  getStudentsLesson (Set<Student> students );
    String  deleteStudentById(Long studentId);



}
