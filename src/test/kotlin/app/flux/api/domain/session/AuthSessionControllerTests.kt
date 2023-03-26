package app.flux.api.domain.session

import app.flux.api.ControllerTests
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@AutoConfigureMockMvc
@WebMvcTest(AuthSessionController::class)
class AuthSessionControllerTests : ControllerTests() {
    @MockkBean
    lateinit var authSessionService: AuthSessionService


    @Test
    fun withoutAnything_returnsToken() {
        every { authSessionService.authSession() } returns "XXX"

        mockMvc.perform(post("/api/session/auth"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.access_token").value("XXX"))
    }
}