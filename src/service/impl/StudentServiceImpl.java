package service.impl;

import database.Database;
import models.Lesson;
import models.Student;
import service.StudentService;

import java.util.HashSet;
import java.util.Set;

import static database.Database.lessons;
import static java.awt.AWTEventMulticaster.add;

public class StudentServiceImpl implements StudentService {

    @Override
    public String addNewStudents(Student newStudent, String groupName) {
        Database.students.add(newStudent);
        return groupName;
    }


    @Override
    public String update(Long studentId) {

        for (Student student : Database.students) {
            if (student.getId().equals(studentId)) {

                student.setId(1L);
                return "Информация о студенте обновлена";
            }
        }

        return "Студент не найден";
    }


    @Override
    public Student findStudentByFirstName(String firstName) {
        // Проходим по всем студентам и ищем по имени
        for (Student student : Database.students) {
            if (student.getName().equalsIgnoreCase(firstName)) {
                return student;
            }
        }
        return null;

    }

    @Override
    public Set<Student> getAllStudentsByGroupName(String groupName) {
        return new HashSet<>(Database.students);
    }

    @Override
    public Set<Lesson> getStudentsLesson(Set<Student> students) {
        lessons.addAll(lessons);
        return lessons;

    }
    @Override
    public String deleteStudentById(Long studentId) {
        for (Student student: Database.students){
            if (student.getId().equals(studentId)){
                Database.students.remove(student);
                return "Deleted successfully";
            }
        }
        return "Student " +studentId+" not found";




    }
}
