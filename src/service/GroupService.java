package service;

import models.Group;
import java.util.Set;



public interface GroupService {
    String add (Group newGroup);
    Set<Group> getAllGroupByName( String groupName);
    String updateGroupNameByName(String groupName);
    Set<Group> getAllGroups ();
    String  deleteGroupById(Long GroupId);


}
