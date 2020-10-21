package com.thoughtworks.gtb.service;

import com.thoughtworks.gtb.exception.UserNotFoundException;
import com.thoughtworks.gtb.model.Education;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EducationService {

    private final Map<Long, List<Education>> educationMap = new HashMap<>();
    List<Education> educationList = new ArrayList<>();

    public void createEducation(long id, Education education) {
        education.setUserId(id);
        educationList.add(education);
        educationMap.put(id, educationList);
    }

    public List<Education> findEducation(long id) {
        if (educationMap.containsKey(id)) {
            return educationMap.get(id);
        } else {
            throw new UserNotFoundException("cannot find this user");
        }
    }
}
