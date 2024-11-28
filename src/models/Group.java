package models;

import service.GroupService;
import service.impl.LessonServiceImpl;

import java.util.Set;

public class Group {
    private  Long id;
    private String name;
    private String description;
    private String lessons;
    private Set<Student> students;


    public Group() {
    }

    public Group(Long id, String name, String description, String lessons, Set<Student> students) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.lessons = lessons;
        students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getLessons() {
        return lessons;
    }

    public void setLessons(String lessons) {
        this.lessons = lessons;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", lessons='" + lessons + '\'' +
                ", Students='" + students + '\'' +
                '}';
    }
}

