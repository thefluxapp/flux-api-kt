package app.flux.api.domain.session

import com.fasterxml.jackson.annotation.JsonProperty

data class AuthData(@JsonProperty("access_token") val accessToken: String)
