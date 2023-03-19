package app.flux.api

import app.flux.api.domain.session.AuthProperties
import app.flux.api.domain.session.AuthService
import app.flux.api.repositories.UserRepo
import com.ninjasquad.springmockk.MockkBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc

open class ControllerTests {
    @Autowired lateinit var mockMvc: MockMvc

    @MockkBean lateinit var authProperties: AuthProperties

    @MockkBean lateinit var userRepo: UserRepo

    @MockkBean lateinit var authService: AuthService
}
