package database;

import models.Group;
import models.Lesson;
import models.Student;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Database {
   public static final Set<Group>  groups  = new HashSet<>();
   public static   Set <Lesson> lessons = new HashSet<>();
   public static     Set <Student> students = new HashSet<>();
}
