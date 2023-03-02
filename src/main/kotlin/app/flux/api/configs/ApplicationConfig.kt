package app.flux.api.configs

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableR2dbcAuditing
@EnableReactiveMethodSecurity(useAuthorizationManager=true)
class ApplicationConfig {
  @Bean
  fun securityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
    http.csrf().disable()

    return http.build()
  }
}
