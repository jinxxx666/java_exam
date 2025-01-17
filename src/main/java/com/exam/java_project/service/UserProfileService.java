package com.exam.java_project.service;

import com.exam.java_project.model.UserProfile;
import com.exam.java_project.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile createUser Profile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    public List<UserProfile> getAllUser Profiles() {
        return userProfileRepository.findAll();
    }

    public Optional<UserProfile> getUser ProfileById(Long id) {
        return userProfileRepository.findById(id);
    }

    public UserProfile updateUser Profile(Long id, UserProfile userProfile) {
        userProfile.setId(id);
        return userProfileRepository.save(userProfile);
    }

    public void deleteUser Profile(Long id) {
        userProfileRepository.deleteById(id);
    }
}
