package flux.app.api.repositories;

import flux.app.api.models.UserModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends ReactiveCrudRepository<UserModel, UUID> {
}
