package com.MentalHealthProject.mentalHealth.controller;

import com.MentalHealthProject.mentalHealth.entities.*;
import com.MentalHealthProject.mentalHealth.services.SupportGroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SupportGroupsController {

    @Autowired
    private SupportGroupsService supportGroupsService;

    @GetMapping("/supportGroups")
    public List<SupportGroups> getSupportGroups() {
        return this.supportGroupsService.getSupportGroups();
    }

    @PostMapping("/addGroups")
    public SupportGroups addSupportGroups(@RequestBody SupportGroups supportGroups) {
        return this.supportGroupsService.addSupportGroups(supportGroups);
    }

    @GetMapping("/{id}")
    public SupportGroups getSpecificGroup(@PathVariable String id) {
        return this.supportGroupsService.getSpecificGroup(id);
    }

    @PutMapping(value = "/updateGroupMembers/{id}")
    public ResponseEntity<SupportGroups> updateGroup(@PathVariable String id) {
        SupportGroups group = this.supportGroupsService.updateGroup(id);
        return ResponseEntity.ok(group);
    }

    @PutMapping(value = "/addPost/{id}")
    public SupportGroups addPost(@PathVariable String id, @RequestBody CommunityPosts post){
        return this.supportGroupsService.addPosts(id,post);
    }

    @GetMapping("/getPosts/{id}")
    public List<CommunityPosts> getPosts(@PathVariable String id, @RequestHeader(name="MyDate") String date) {
        return this.supportGroupsService.getPosts(id, date);
    }

    @PutMapping(value = "/updatePostLikes/{id}")
    public ResponseEntity<SupportGroups> updatePostLikes(@PathVariable String id, @RequestBody String postID, @RequestHeader(name="Liked") Boolean liked) {
        SupportGroups group = this.supportGroupsService.updatePostLikes(id, postID, liked);
        return ResponseEntity.ok(group);
    }

    @PutMapping("/addComment/{id}")
    public SupportGroups addComment(@PathVariable String id, @RequestBody Comment comment, @RequestHeader(name="postID") String postID){
        return this.supportGroupsService.addComment(id,comment,postID);
    }

    @PutMapping(value = "/addReview/{id}")
    public SupportGroups addReview(@PathVariable String id, @RequestBody Review review){
        return this.supportGroupsService.addReview(id,review);
    }

    @GetMapping("/getReviews/{id}")
    public List<Review> getReview(@PathVariable String id, @RequestHeader(name="MyDate") String date) {
        return this.supportGroupsService.getReviewsList(id, date);
    }

    @PutMapping(value = "/addEvent/{id}")
    public SupportGroups addEvent(@PathVariable String id, @RequestBody Event event){
        return this.supportGroupsService.addEvent(id,event);
    }

    @GetMapping("/getEvents/{id}")
    public List<Event> getEvent(@PathVariable String id, @RequestHeader(name="MyDate") String date) {
        return this.supportGroupsService.getEventsList(id, date);
    }

}
