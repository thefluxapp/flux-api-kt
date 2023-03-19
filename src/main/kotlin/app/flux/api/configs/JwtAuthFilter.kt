package app.flux.api.configs

import app.flux.api.domain.session.AuthProperties
import app.flux.api.repositories.UserRepo
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.SignatureException
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import java.util.UUID
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.GenericFilterBean

@Configuration
class JwtAuthFilter(private val authProperties: AuthProperties, private val userRepo: UserRepo) :
  GenericFilterBean() {
  override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
    val token =
      (request as HttpServletRequest)
        .getHeader(HttpHeaders.AUTHORIZATION)
        ?.substringAfter("Bearer ")

    if (!token.isNullOrEmpty()) {
      try {
        val parsedToken =
          Jwts.parserBuilder().setSigningKey(authProperties.publicKey).build().parseClaimsJws(token)

        val user = userRepo.findById(UUID.fromString(parsedToken.body.subject))
        val authenticationToken =
          UsernamePasswordAuthenticationToken.authenticated(
            user,
            null,
            listOf(SimpleGrantedAuthority("ROLE_USER"))
          )

        SecurityContextHolder.getContext().authentication = authenticationToken
      } catch (e: SignatureException) {
        // TODO: Process it
        print("EX: $e")
      }
    }

    chain.doFilter(request, response)
  }
}
