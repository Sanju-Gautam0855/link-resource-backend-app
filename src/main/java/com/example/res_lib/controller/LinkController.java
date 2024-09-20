package com.example.res_lib.controller;

import com.example.res_lib.service.LinkService;
import com.example.res_lib.model.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/links")
@CrossOrigin(origins = "http://localhost:3000") // Ensure the frontend URL is correct
public class LinkController {

    @Autowired
    private LinkService linkService;

    // Method to save links in the database
    @PostMapping("/{teamName}/map")
    public ResponseEntity<Map<String, List<Link>>> mapLinks(
            @PathVariable String teamName,
            @RequestBody List<Link> links) {
        linkService.saveLinks(teamName, links); // Save links to the database
        return ResponseEntity.ok(Map.of(teamName, links));
    }
}
