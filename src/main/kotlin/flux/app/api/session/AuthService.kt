package flux.app.api.session

import flux.app.api.repositories.UserRepo
import org.springframework.stereotype.Service

@Service
class AuthService (
  private val userRepo: UserRepo
) {
  fun call () {
    userRepo.create()
    print("AuthService")
  }
}