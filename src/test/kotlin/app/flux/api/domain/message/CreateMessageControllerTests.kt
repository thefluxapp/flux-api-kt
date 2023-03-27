package app.flux.api.domain.message

import app.flux.api.ControllerTests
import com.fasterxml.jackson.databind.ObjectMapper
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureMockMvc
@WebMvcTest(CreateMessageController::class)
class CreateMessageControllerTests : ControllerTests() {
    @MockkBean
    lateinit var createMessageService: CreateMessageService

    @Test
    fun withoutToken_returns403() {
        val params = hashMapOf("text" to "TEXT")

        every { createMessageService.createMessage(any()) } returns Unit

        mockMvc.perform(
            post("/api/messages")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ObjectMapper().writeValueAsString(params)),
        ).andExpect(status().isForbidden)
    }

    @Test
    fun withoutBody_returns422() {
        every { createMessageService.createMessage(any()) } returns Unit

        mockMvc.perform(
            post("/api/messages")
                .contentType(MediaType.APPLICATION_JSON)
            ).andExpect(status().isUnprocessableEntity)
    }

    @Test
    @WithMockUser(username = "user", authorities = ["USER"])
    fun withToken_returnsOk() {
        val params = hashMapOf("text" to "TEXT")

        every { createMessageService.createMessage(any()) } returns Unit

        mockMvc.perform(
            post("/api/messages")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ObjectMapper().writeValueAsString(params)),
        ).andExpect(status().isOk)
    }

}
