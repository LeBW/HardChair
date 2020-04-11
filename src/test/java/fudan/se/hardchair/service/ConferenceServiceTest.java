package fudan.se.hardchair.service;

import fudan.se.hardchair.domain.Conference;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LBW
 */
@SpringBootTest
class ConferenceServiceTest {
    @Autowired
    private ConferenceService conferenceService;

    @Test
    void getAllConferences() {
    }

    @Test
    void addConference() {
        String username = "admin";
        Conference conference = new Conference();
        conference.setShortName("ase");
        conference.setFullName("asdfsdafasd");

        Conference newConference = conferenceService.addConference(username, conference);
        System.out.println(newConference);
    }
}