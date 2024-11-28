package service.impl;

import database.Database;
import models.Lesson;
import service.LessonService;

import java.util.HashSet;
import java.util.Set;

import static database.Database.lessons;

public class LessonServiceImpl implements LessonService {

    @Override
    public String AddLessonToGroup(Lesson newLesson, String groupId) {
        newLesson.setId(1L);
        if (lessons.add(newLesson)) {
            return "Lesson added to group ID: " + groupId + " successfully.";
        } else {
            return "Lesson already exists in the group!";
        }
    }

    @Override
    public String add(Lesson newLesson) {
        if (lessons.add(newLesson)) {
            return "Lesson added successfully!";
        } else {
            return "Lesson already exists!";
        }
    }

    @Override
    public Set<Lesson> GetAllLessonByName(String groupName) {
        Set<Lesson> result = new HashSet<>();
        for (Lesson lesson : lessons) {
            if (lesson.getLessonName().equalsIgnoreCase(groupName)) {
                result.add(lesson);
            }
        }
        return result;
    }

    @Override
    public String deleteLessonById(Long lessonId) {
        for (Lesson lesson : lessons) {
            if (lesson.getId().equals(lessonId)) {
                lessons.remove(lesson);
                return "Lesson with ID: " + lessonId + " was successfully deleted.";
            }
        }
        return "Lesson with ID: " + lessonId + " not found.";
    }
}
