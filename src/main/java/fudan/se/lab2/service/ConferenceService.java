package fudan.se.lab2.service;

import fudan.se.lab2.domain.Conference;
import fudan.se.lab2.repository.ConferenceRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author LBW
 */
@Service
public class ConferenceService {
    private ConferenceRepository conferenceRepository;

    public ConferenceService(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    public Iterable<Conference> getAllConferences() {
        return conferenceRepository.findAll();
    }

    public Conference addConference(Conference conference) {
        return conferenceRepository.save(conference);
    }
}
