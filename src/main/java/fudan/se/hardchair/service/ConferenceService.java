package fudan.se.hardchair.service;

import fudan.se.hardchair.domain.Conference;
import fudan.se.hardchair.domain.ConferenceUser;
import fudan.se.hardchair.domain.User;
import fudan.se.hardchair.repository.ConferenceRepository;
import fudan.se.hardchair.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @author LBW
 */
@Service
public class ConferenceService {
    private ConferenceRepository conferenceRepository;
    private UserRepository userRepository;

    public ConferenceService(ConferenceRepository conferenceRepository, UserRepository userRepository) {
        this.conferenceRepository = conferenceRepository;
        this.userRepository = userRepository;
    }

    public Iterable<Conference> getAllConferences() {
        return conferenceRepository.findAll();
    }

    public Conference addConference(String username, Conference conference) {

        User applyUser = userRepository.findByUsername(username);

        //make a new entity of ConferenceUser.
        ConferenceUser conferenceUser = new ConferenceUser();
        conferenceUser.setUser(applyUser);
        conferenceUser.setConference(conference);
        conferenceUser.setUserRole("Chair");

        // set the conferenceUser to the conference.
        conference.setConferenceUserSet(Collections.singleton(conferenceUser));

        return conferenceRepository.save(conference);
    }
}
