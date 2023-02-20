package flux.app.api.repositories;

import java.util.UUID;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import flux.app.api.models.UserModel;

public interface UserRepo extends ReactiveCrudRepository<UserModel, UUID> {
}
