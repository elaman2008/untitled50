package service.impl;

import database.Database;
import models.Group;
import service.GroupService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupServiceImpl implements GroupService {

    @Override
    public String add(Group newGroup) {
        Database.groups.add(newGroup);
        return "Successfully added ";
    }

    @Override
    public Set<Group> getAllGroupByName(String groupName) {
        return new HashSet<>(Database.groups);

    }

    @Override
    public String updateGroupNameByName(String groupName) {
        for (Group group : Database.groups) {
            if (group.getName().equals(groupName)) {  
                group.setName("Новое имя");
                return "Имя группы успешно обновлено";
            }
        }
        return "Группа с таким именем не найдена";

    }


    @Override
    public Set<Group> getAllGroups() {
        return new HashSet<>(Database.groups);
    }
    @Override
    public String deleteGroupById(Long GroupId) {
        boolean removed = Database.groups.removeIf(group -> group.getId().equals(GroupId));
        if (removed) {
            return "Группа успешно удалена";
        } else {
            return "Группа с таким ID не найдена";
        }
    }
    }
