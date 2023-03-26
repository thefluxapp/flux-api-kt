package app.flux.api.domain.session

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/session")
class AuthSessionController(private val authSessionService: AuthSessionService) {
    @PostMapping("auth")
    fun authSession(): AuthSessionResponse {
//        TODO: Create mapper between sesrive and response
        return AuthSessionResponse(accessToken = authSessionService.authSession())
    }
}
