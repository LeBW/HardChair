package fudan.se.hardchair.controller;

import fudan.se.hardchair.domain.Conference;
import fudan.se.hardchair.service.ConferenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

/**
 * @author LBW
 */
@Controller
public class ConferenceController {
    private ConferenceService conferenceService;

    public ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @GetMapping("/conferences")
    public ResponseEntity<?> getAllConferences() {
        return ResponseEntity.ok().body(conferenceService.getAllConferences());
    }

    @GetMapping("/conferences/{id}")
    public ResponseEntity<?> getConferenceById(@PathVariable Long id) {
        return ResponseEntity.ok().body(conferenceService.getConferenceById(id));
    }

    @PostMapping("/conferences")
    public ResponseEntity<?> addConference(@RequestBody Conference conference) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return ResponseEntity.ok().body(conferenceService.addConference(username, conference));
    }

}
