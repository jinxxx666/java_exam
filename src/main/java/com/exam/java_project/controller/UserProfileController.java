package com.exam.java_project.controller;
import com.exam.java_project.model.UserProfile;
import com.exam.java_project.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/userprofiles")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping
    public ResponseEntity<UserProfile> createUser Profile(@RequestBody UserProfile userProfile) {
        UserProfile createdUser Profile = userProfileService.createUser Profile(userProfile);
        return new ResponseEntity<>(createdUser Profile, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserProfile>> getAllUser Profiles() {
        List<UserProfile> userProfiles = userProfileService.getAllUser Profiles();
        return new ResponseEntity<>(userProfiles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUser ProfileById(@PathVariable Long id) {
        return userProfileService.getUser ProfileById(id)
                .map(userProfile -> new ResponseEntity<>(userProfile, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfile> updateUser Profile(@PathVariable Long id, @RequestBody UserProfile userProfile) {
        UserProfile updatedUser Profile = userProfileService.updateUser Profile(id, userProfile);
        return new ResponseEntity<>(updatedUser Profile, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser Profile(@PathVariable Long id) {
        userProfileService.deleteUser Profile(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
