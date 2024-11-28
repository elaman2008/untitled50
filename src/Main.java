import enums.Gender;
import models.Group;
import models.Lesson;
////import enums.Gender;
////import models.Group;
////import models.Lesson;
import models.Student;
import service.impl.GroupServiceImpl;
import service.impl.LessonServiceImpl;
import service.impl.StudentServiceImpl;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;




//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Кируу учун Электрондук почтанызды жана парольнузду жазыныз");
        System.out.println("Элуктрондук почтанызды жазыныз");
        String email = scanner.nextLine();
        try {
            if (!email.contains("@")) {
               throw new IllegalAccessException("Email cосуз турдо '@' камтышы керек");
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            System.out.println("Emailды туура жазыныз:  " + e.getMessage());
        }

        GroupServiceImpl groupService = new GroupServiceImpl();
        LessonServiceImpl lessonService = new LessonServiceImpl();
        StudentServiceImpl studentService = new StudentServiceImpl();


        Set<Student> students = new HashSet<>();
        Student student = new Student(1L, "Elaman", "Abjalov", "elamam@gmail.com", 1234, Gender.MALE);
        Student student2 = new Student(2L, "Nurs", "Bekov", "nurs@gmail.com", 12222, Gender.MALE);
        Student student3 = new Student(2L, "Jyky", "Amangulov", "gyrgal@gmail.com", 12222, Gender.MALE);
        Student student4 = new Student(2L, "Adi", "Egemberdiev", "adi@gmail.com", 12222, Gender.MALE);


        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить группу");
            System.out.println("2. Показать все группы");
            System.out.println("3. Обновить название группы");
            System.out.println("4. Удалить группу по ID");
            System.out.println("5. Добавить урок");
            System.out.println("6. Добавить урок в группу");
            System.out.println("7. Показать все уроки по имени группы");
            System.out.println("8. Удалить урок по ID");
            System.out.println("9. Добавить студента");
            System.out.println("10. Найти студента по имени");
            System.out.println("11. Показать всех студентов группы");
            System.out.println("12. Удалить студента по ID");
            System.out.println("13. Выйти");
            System.out.print("Выберите опцию: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите ID группы: ");
                    Long groupId = scanner.nextLong();
                    scanner.nextLine(); // Очистка ввода
                    System.out.print("Введите название группы: ");
                    String groupName = scanner.nextLine();
                    System.out.print("Введите описание группы: ");
                    String groupDescription = scanner.nextLine();
                    Group newGroup = new Group();
                    System.out.println(groupService.add(newGroup));
                    break;

                case 2:
                    Set<Group> groups = groupService.getAllGroups();
                    System.out.println("Все группы:");
                    for (Group group : groups) {
                        System.out.println(group);
                    }
                    break;

                case 3:
                    System.out.print("Введите текущее название группы: ");
                    String currentGroupName = scanner.nextLine();
                    System.out.println(groupService.updateGroupNameByName(currentGroupName));
                    break;

                case 4:
                    System.out.print("Введите ID группы для удаления: ");
                    Long groupIdToDelete = scanner.nextLong();
                    scanner.nextLine(); // Очистка ввода
                    System.out.println(groupService.deleteGroupById(groupIdToDelete));
                    break;

                case 5:
                    System.out.print("Введите ID урока: ");
                    Long lessonId = scanner.nextLong();
                    scanner.nextLine(); // Очистка ввода
                    System.out.print("Введите название урока: ");
                    String lessonName = scanner.nextLine();
                    System.out.print("Введите описание урока: ");
                    String lessonDescription = scanner.nextLine();
                    Lesson newLesson = new Lesson(lessonId, lessonName, lessonDescription);
                    System.out.println(lessonService.add(newLesson));
                    break;

                case 6:
                    System.out.print("Введите ID урока: ");
                    Long lessonToAddId = scanner.nextLong();
                    scanner.nextLine(); // Очистка ввода
                    System.out.print("Введите название урока: ");
                    String lessonToAddName = scanner.nextLine();
                    System.out.print("Введите ID группы: ");
                    String groupIdForLesson = scanner.nextLine();
                    Lesson lessonToAdd = new Lesson(lessonToAddId, lessonToAddName, "Описание урока");
                    System.out.println(lessonService.AddLessonToGroup(lessonToAdd, groupIdForLesson));
                    break;

                case 7:
                    System.out.print("Введите название группы: ");
                    String groupNameForLessons = scanner.nextLine();
                    Set<Lesson> lessons = lessonService.GetAllLessonByName(groupNameForLessons);
                    System.out.println("Уроки группы " + groupNameForLessons + ":");
                    for (Lesson lesson : lessons) {
                        System.out.println(lesson);
                    }
                    break;

                case 8:
                    System.out.print("Введите ID урока для удаления: ");
                    Long lessonIdToDelete = scanner.nextLong();
                    scanner.nextLine(); // Очистка ввода
                    System.out.println(lessonService.deleteLessonById(lessonIdToDelete));
                    break;

                case 9:
                    System.out.print("Введите ID студента: ");
                    Long studentId = scanner.nextLong();
                    scanner.nextLine(); // Очистка ввода
                    System.out.print("Введите имя студента: ");
                    String studentFirstName = scanner.nextLine();
                    System.out.print("Введите фамилию студента: ");
                    String studentLastName = scanner.nextLine();
                    System.out.print("Введите email студента: ");
                    String studentEmail = scanner.nextLine();
                    System.out.print("Введите пароль студента: ");
                    int studentPassword = scanner.nextInt();
                    scanner.nextLine(); // Очистка ввода
                    System.out.print("Введите пол студента (MALE/FEMALE): ");
                    String genderInput = scanner.nextLine();
                    Gender gender = Gender.valueOf(genderInput.toUpperCase());
                    System.out.print("Введите название группы: ");
                    String groupNameForStudent = scanner.nextLine();
                    Student newStudent = new Student(studentId, studentFirstName, studentLastName, studentEmail, studentPassword, gender);
                    System.out.println(studentService.addNewStudents(newStudent, groupNameForStudent));
                    break;

                case 10:
                    System.out.print("Введите имя студента: ");
                    String studentName = scanner.nextLine();
                    Student foundStudent = studentService.findStudentByFirstName(studentName);
                    if (foundStudent != null) {
                        System.out.println("Найден студент: " + foundStudent);
                    } else {
                        System.out.println("Студент с именем " + studentName + " не найден.");
                    }
                    break;

                case 11:
                    System.out.print("Введите название группы: ");
                    String groupNameForStudents = scanner.nextLine();
                    Set<Student> studentsInGroup = studentService.getAllStudentsByGroupName(groupNameForStudents);
                    System.out.println("Студенты группы " + groupNameForStudents + ":");
                    for (Student student1 : studentsInGroup) {
                        System.out.println(student);
                    }
                    break;

                case 12:
                    System.out.print("Введите ID студента для удаления: ");
                    Long studentIdToDelete = scanner.nextLong();
                    scanner.nextLine(); // Очистка ввода
                    System.out.println(studentService.deleteStudentById(studentIdToDelete));
                    break;

                case 13:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }


    }






















































//        Scanner scanner = new Scanner(System.in);
//        StudentServiceImpl studentService = new StudentServiceImpl();
//        LessonServiceImpl lessonService = new LessonServiceImpl();
//        GroupServiceImpl groupService = new GroupServiceImpl();
//
//
//        Set<Student> students = new HashSet<>();
//        Student student = new Student(1L, "Elaman", "Eroi", "elamam@gmail.com", 1234, Gender.MALE);
//        Student student1 = new Student(2L, "Sanjar", "Bekov", "sangar@gmail.com", 12222, Gender.MALE);
//
//        Set<Group> groups = new HashSet<>();
//        groups.add(new Group(1L, "Elaman", "Eroi", "Algebra", students));
//        groups.add(new Group(2L, "Sangar", "Erss", "Fizra", students));
//
//
//        Set<Lesson> lessons = new HashSet<>();
//        lessons.add(new Lesson(1L, "Abstrct", "AAaaa"));
//        System.out.println(groups);
//        System.out.println(student);
//        System.out.println(lessons);
//
//        Scanner scanner1 = new Scanner(System.in);
//        System.out.println("Кируу учун Электрондук почтанызды жана парольнузду жазыныз");
//        System.out.println("Элуктрондук почтанызды жазыныз");
//        String email = scanner1.nextLine();
//        try {
//            if (!email.contains("@")) {
//                throw new IllegalAccessException("Email cосуз турдо '@' камтышы керек");
//            }
//        } catch (IllegalArgumentException | IllegalAccessException e) {
//            System.out.println("Emailды туура жазыныз:  " + e.getMessage());
//        }
//        System.out.println("Пароль жазыныз  :");
//        String password = scanner1.nextLine();
//        Student student2 = null;
//        try {
//            if (student2.equals("CorrectUserName") && password.equals("correctPasswjrd")){
//            }
//
//

































































