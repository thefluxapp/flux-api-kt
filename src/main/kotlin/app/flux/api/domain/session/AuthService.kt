package app.flux.api.domain.session

import app.flux.api.models.UserModel
import app.flux.api.repositories.UserRepo
import io.jsonwebtoken.Jwts
import org.apache.commons.lang3.RandomStringUtils
import org.springframework.stereotype.Service

@Service
class AuthService(private val userRepo: UserRepo, private val authProperties: AuthProperties) {
  suspend fun call(): Pair<UserModel, String> {
    val user = userRepo.save(UserModel(login = RandomStringUtils.random(12, true, true)))
    val token = generateToken(user)

    return Pair(user, token)
  }

  private fun generateToken(user: UserModel): String {
    return Jwts.builder()
      .signWith(authProperties.privateKey)
      .setSubject(user.id.toString())
      .compact()
  }
}
