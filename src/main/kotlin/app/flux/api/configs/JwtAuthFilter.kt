package app.flux.api.configs

import app.flux.api.domain.session.AuthProperties
import app.flux.api.repositories.UserRepo
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.SignatureException
import java.util.UUID
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.authorization.AuthenticatedReactiveAuthorizationManager
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.ReactiveSecurityContextHolder
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
        val parsedToken =
          Jwts.parserBuilder().setSigningKey(authProperties.publicKey).build().parseClaimsJws(token)

        // TODO: Remove as String
        val user = userRepo.findById(UUID.fromString(parsedToken.body["sub"] as String))
        val authenticationToken = UsernamePasswordAuthenticationToken.authenticated(user, null, listOf(
          SimpleGrantedAuthority("ROLE_USER")
        ))
        // val authentication = reactiveAuthenticationManager.authenticate(authenticationToken)

        println("filter: " + authenticationToken)
        SecurityContextHolder.getContext().authentication = authenticationToken
        ReactiveSecurityContextHolder.withAuthentication(authenticationToken)

        println("In Filter After Set #: " + SecurityContextHolder.getContext().authentication)
      } catch (e: SignatureException) {
        print("EX" + e)
      }
    }

    return chain.filter(exchange)
  }
}
