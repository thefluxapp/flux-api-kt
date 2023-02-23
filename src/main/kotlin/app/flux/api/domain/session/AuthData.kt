package app.flux.api.domain.session

import java.util.*

data class AuthData(val user: UserData, val jwt: JwtData) {
  data class UserData(val id: UUID, val login: String)
  data class JwtData(val token: String)
}
