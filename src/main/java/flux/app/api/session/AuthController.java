package flux.app.api.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
  Mono<ResponseEntity<String>> call() {
    authService.call();

    return Mono.just(new ResponseEntity<>("HELLO!", HttpStatus.OK));
  }
}
