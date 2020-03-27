package fudan.se.hardchair.repository;

import fudan.se.hardchair.domain.Conference;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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