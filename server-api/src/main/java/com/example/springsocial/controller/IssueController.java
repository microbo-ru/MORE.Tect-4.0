package com.example.springsocial.controller;

import com.example.springsocial.model.Issue;
import com.example.springsocial.payload.ApiResponse;
import com.example.springsocial.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class IssueController {

    @Autowired
    private IssueRepository issueRepository;

    @GetMapping("/issues")
    public List<Issue> getIssues() {
        return issueRepository.findAll();
    }

    @PostMapping("/issue")
    public ResponseEntity<?> postIssue(@Valid @RequestBody Issue issue) {

        issueRepository.save(issue);

        return ResponseEntity.ok(new ApiResponse(true, "Issue is saved." ));
    }
}
