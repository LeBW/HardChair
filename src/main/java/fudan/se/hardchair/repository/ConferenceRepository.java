package fudan.se.hardchair.repository;

import fudan.se.hardchair.domain.Conference;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author LBW
 */
@Repository
public interface ConferenceRepository extends CrudRepository<Conference, Long> {
    public Conference findByShortName(String shortName);
}
