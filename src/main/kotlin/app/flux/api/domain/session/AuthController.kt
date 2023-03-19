package app.flux.api.domain.session

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/session")
class AuthController(private val authService: AuthService) {
  @PostMapping("auth")
  fun call(): AuthData {
    return AuthData(accessToken = authService.call())
  }
}
