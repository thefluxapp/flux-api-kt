package app.flux.api.domain.session

import app.flux.api.domain.user.UserModel
import app.flux.api.domain.user.UserRepo
import io.jsonwebtoken.Jwts
import org.apache.commons.lang3.RandomStringUtils
import org.springframework.stereotype.Service

@Service
class AuthSessionService(private val authSessionProperties: AuthSessionProperties, private val userRepo: UserRepo) {
    fun authSession(): String {
        val user = userRepo.save(UserModel(login = RandomStringUtils.random(12, true, true)))

        return generateToken(user)
    }

    private fun generateToken(user: UserModel): String {
        return Jwts.builder()
            .signWith(authSessionProperties.privateKey)
            .setSubject(user.id.toString())
            .compact()
    }
}
