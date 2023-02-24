package app.flux.api.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableR2dbcAuditing
class AppConfig {
  @Bean
  fun securityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
    // Disable default security.
    // http.httpBasic().disable()
    // http.formLogin().disable()
    http.csrf().disable()
    http.logout().disable()

    return http.build()
  }
}
