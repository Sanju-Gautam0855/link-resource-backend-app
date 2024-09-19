package com.example.res_lib.service;

import com.example.res_lib.repository.LinkRepo;
import com.example.res_lib.model.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LinkService {

    @Autowired
    private LinkRepo linkRepository;

    public Map<String, List<Link>> mapLinksToTeams(String teamName, List<Link> links) {
        Map<String, List<Link>> teamLinksMap = new HashMap<>();

        // Initialize lists for the teams
        teamLinksMap.put("AI_Ops", linkRepository.findAll());
        teamLinksMap.put("ML_Engineering", linkRepository.findAll());
        teamLinksMap.put("GenAI", linkRepository.findAll());

        // Map the links to the correct team
        if (teamLinksMap.containsKey(teamName)) {
            for (Link link : links) {
                linkRepository.save(link);  // Save the link to the H2 database
                teamLinksMap.get(teamName).add(link);
            }
        }

        return teamLinksMap;
    }

    public void saveLinks(String teamName, List<Link> links) {
        for (Link link : links) {
            link.setTeamName(teamName); // Set team name for each link
            linkRepository.save(link); // Save each link to the database
        }
    }
}
