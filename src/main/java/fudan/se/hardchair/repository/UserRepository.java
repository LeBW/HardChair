package fudan.se.hardchair.repository;

import fudan.se.hardchair.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author LBW
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
