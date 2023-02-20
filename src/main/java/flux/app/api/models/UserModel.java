package flux.app.api.models;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public class UserModel {
  @Id
  private UUID id;

  private final String login;

  public UserModel(String login) {
    this.id = UUID.randomUUID();
    this.login = login;
  }
}
