package flux.app.api.models;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public record UserModel(
  @Id UUID id, String login, Optional<String> first_name, Optional<String> last_name,
  @CreatedDate LocalDateTime created_at,
  @LastModifiedDate LocalDateTime updated_at
) {
}
