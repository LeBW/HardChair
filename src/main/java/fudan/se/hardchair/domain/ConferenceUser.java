package fudan.se.hardchair.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ConferenceUser implements Serializable {
    @Id
    @ManyToOne
    @JsonIgnoreProperties("conferenceUserSet")
    private Conference conference;

    @Id
    @ManyToOne
    @JsonIgnoreProperties("conferenceUserSet")
    private User user;

    private String userRole;

    public ConferenceUser() {}


    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConferenceUser that = (ConferenceUser) o;
        return Objects.equals(conference.getId(), that.conference.getId()) &&
                Objects.equals(user.getId(), that.user.getId()) &&
                Objects.equals(userRole, that.userRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conference.getId(), user.getId(), userRole);
    }
}
