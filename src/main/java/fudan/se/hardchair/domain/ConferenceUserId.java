package fudan.se.hardchair.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author LBW
 */
public class ConferenceUserId implements Serializable {
    private Long conference;
    private Long user;

    public ConferenceUserId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConferenceUserId that = (ConferenceUserId) o;
        return Objects.equals(conference, that.conference) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conference, user);
    }
}
