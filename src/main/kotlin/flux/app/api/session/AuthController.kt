package flux.app.api.session

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/session")
class AuthCotroller (private val authService: AuthService) {
  @PostMapping("auth")
  fun call(): Mono<ResponseEntity<String>> {

    authService.call()

    return Mono.just(ResponseEntity("HELLO!", HttpStatus.OK))
  }
}
