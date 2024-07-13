package com.test.Inoteqia.Services;

import com.test.Inoteqia.Entity.GroupeMed;
import com.test.Inoteqia.Reposotories.GroupeMedReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupeMedService {
    @Autowired
    private GroupeMedReposotory groupeMedReposotory;

    public void deleteGroupeMed(Long id){
        groupeMedReposotory.deleteById(id);
    }
    public void addGroupeMed(GroupeMed groupeMed){
        groupeMedReposotory.save(groupeMed);

    }
    public GroupeMed getGroupeMedById(Long id){
        return groupeMedReposotory.findById(id).get();
    }
    public List<GroupeMed> getAllGroupeMed(){
        return groupeMedReposotory.findAll();
    }
}
