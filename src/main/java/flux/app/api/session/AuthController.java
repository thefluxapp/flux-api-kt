package flux.app.api.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import flux.app.api.models.UserModel;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/session")
public class AuthController {
  private final AuthService authService;

  @Autowired
  AuthController(AuthService authService) {
    this.authService = authService;
  }

  @PostMapping("auth")
  Mono<UserModel> call() {
    Mono<UserModel> user = authService.call();

    return user;
  }
}
