package app.flux.api.domain.session

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class AuthData(
@JsonProperty("access_token")
  val accessToken: String
)
