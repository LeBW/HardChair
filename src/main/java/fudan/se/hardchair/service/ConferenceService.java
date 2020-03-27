package fudan.se.hardchair.service;

import fudan.se.hardchair.domain.Conference;
import fudan.se.hardchair.repository.ConferenceRepository;
import org.springframework.stereotype.Service;

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
