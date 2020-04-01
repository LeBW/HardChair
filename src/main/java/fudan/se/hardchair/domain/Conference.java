package fudan.se.hardchair.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author LBW
 */
@Entity
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String shortName;

    @Column(unique = true)
    private String fullName;

    private String holdingPlace;

    private Date submitDeadline;

    private Date publishTime;

    private Date holdingTime;

    @OneToMany(mappedBy = "conference", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ConferenceUser> conferenceUserSet = new HashSet<>();

    public Conference() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getHoldingPlace() {
        return holdingPlace;
    }

    public void setHoldingPlace(String holdingPlace) {
        this.holdingPlace = holdingPlace;
    }

    public Date getSubmitDeadline() {
        return submitDeadline;
    }

    public void setSubmitDeadline(Date submitDeadline) {
        this.submitDeadline = submitDeadline;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getHoldingTime() {
        return holdingTime;
    }

    public void setHoldingTime(Date holdingTime) {
        this.holdingTime = holdingTime;
    }

    public Set<ConferenceUser> getConferenceUserSet() {
        return conferenceUserSet;
    }

    public void setConferenceUserSet(Set<ConferenceUser> conferenceUserSet) {
        this.conferenceUserSet = conferenceUserSet;
    }

    public void addConferenceUser(ConferenceUser conferenceUser) {
        conferenceUserSet.add(conferenceUser);
    }
}
