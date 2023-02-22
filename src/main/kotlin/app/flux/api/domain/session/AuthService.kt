package app.flux.api.domain.session

import app.flux.api.models.UserModel
import app.flux.api.repositories.UserRepo
import org.apache.commons.lang3.RandomStringUtils
import org.springframework.stereotype.Service

@Service
class AuthService(private val userRepo: UserRepo) {
  suspend fun createWithRandomLogin(): UserModel {
    val user = UserModel(login = RandomStringUtils.random(12, true, true))

    return userRepo.save(user)
  }
}
