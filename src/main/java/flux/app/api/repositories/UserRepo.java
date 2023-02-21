package flux.app.api.repositories;

import org.springframework.stereotype.Repository;
import java.util.UUID;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import flux.app.api.models.UserModel;

@Repository
public interface UserRepo extends ReactiveCrudRepository<UserModel, UUID> {
}
