package app.flux.api

import app.flux.api.configs.SecurityConfig
import app.flux.api.domain.session.AuthSessionProperties
import app.flux.api.domain.user.UserRepo
import com.ninjasquad.springmockk.MockkBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Import
import org.springframework.test.web.servlet.MockMvc

@Import(SecurityConfig::class)
open class ControllerTests {
    @Autowired lateinit var mockMvc: MockMvc
    @MockkBean lateinit var authsessionProperties: AuthSessionProperties
    @MockkBean lateinit var userRepo: UserRepo
}
