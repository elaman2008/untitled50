package service;

import models.Lesson;

import java.util.Set;

public interface LessonService {
    String AddLessonToGroup(Lesson newLesson,String  Id);
    String add (Lesson newLesson);
    Set<Lesson> GetAllLessonByName(String GroupName);
    String deleteLessonById(Long lessonId);


}
