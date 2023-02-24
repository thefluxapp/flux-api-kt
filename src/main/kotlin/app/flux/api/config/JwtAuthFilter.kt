package app.flux.api.config

import app.flux.api.domain.session.AuthProperties
import app.flux.api.repositories.UserRepo
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.SignatureException
import java.util.UUID
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.server.*

@Component
class JwtAuthFilter(private val authProperties: AuthProperties, private val userRepo: UserRepo) :
  CoWebFilter() {
  override suspend fun filter(exchange: ServerWebExchange, chain: CoWebFilterChain) {
    val token =
      exchange.request.headers.get(HttpHeaders.AUTHORIZATION)?.get(0)?.substringAfter("Bearer ")

    // TODO: Add more edge cases and logs
    if (!token.isNullOrEmpty()) {
      try {
        val qq =
          Jwts.parserBuilder().setSigningKey(authProperties.publicKey).build().parseClaimsJws(token)

        // TODO: Remove as String
        val user = userRepo.findById(UUID.fromString(qq.body["sub"] as String))
        val authentication = UsernamePasswordAuthenticationToken(user, null)

        SecurityContextHolder.getContext().authentication = authentication
      } catch (e: SignatureException) {
        print("EX" + e)
      }
    }

    return chain.filter(exchange)
  }
}
