package fudan.se.hardchair.controller;

import fudan.se.hardchair.domain.Conference;
import fudan.se.hardchair.service.ConferenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @PostMapping("/conferences")
    public ResponseEntity<?> addConference(@RequestBody Conference conference) {
        return ResponseEntity.ok().body(conferenceService.addConference(conference));
    }

}
