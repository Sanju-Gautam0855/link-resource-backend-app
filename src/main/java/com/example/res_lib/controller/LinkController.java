package com.example.res_lib.controller;

import com.example.res_lib.service.LinkService;
import com.example.res_lib.model.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//Prod
@CrossOrigin(origins = "https://learn-frontapp.azurewebsites.net")
//Dev
//@CrossOrigin(origins = "https://localhost:3030") // Allow requests from frontend
public class LinkController {

    @Autowired
    private LinkService linkService;

    // Basic hello message at the root ("/")
    @GetMapping("/")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello! Backend is running fine on learn-backapp.azurewebsites.net");
    }

    // Method to save links in the database
    @PostMapping("/api/links/{teamName}/map")
    public ResponseEntity<Map<String, List<Link>>> mapLinks(
            @PathVariable String teamName,
            @RequestBody List<Link> links) {
        linkService.saveLinks(teamName, links); // Save links to the database
        return ResponseEntity.ok(Map.of(teamName, links));
    }
}
