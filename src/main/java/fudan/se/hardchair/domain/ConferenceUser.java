package fudan.se.hardchair.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(ConferenceUserId.class)
public class ConferenceUser implements Serializable {
    @Id
    @ManyToOne
    private Conference conference;

    @Id
    @ManyToOne
    private User user;

    private String userRole;

    public ConferenceUser() {}


    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
        conference.addConferenceUser(this);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        user.addConferenceUser(this);
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

}
