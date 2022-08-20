package pvduc.dev.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pvduc.dev.authorization.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
