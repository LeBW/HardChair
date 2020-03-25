package fudan.se.lab2.repository;

import fudan.se.lab2.domain.Conference;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LBW
 */
@SpringBootTest
class ConferenceRepositoryTest {
    @Autowired
    private ConferenceRepository conferenceRepository;

    @Test
    void findByShortName() {
        Conference test = new Conference();
        test.setShortName("ASE");
        conferenceRepository.save(test);
        conferenceRepository.findAll();
        conferenceRepository.findByShortName("ASE");
    }
}