package app.flux.api.domain.session

import app.flux.api.models.UserModel
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("api/session")
class AuthController (
  private val authService: AuthService
) {
  @PostMapping("auth")
  suspend fun call (): UserModel {
    return authService.createWithRandomLogin()
  }

}