package app.flux.api.domain.messages

import app.flux.api.ControllerTests
import com.ninjasquad.springmockk.MockkBean
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

// @SpringBootTest
@AutoConfigureMockMvc
@WebMvcTest
class CreateMessageControllerTests : ControllerTests() {
  @MockkBean lateinit var createMessageService: CreateMessageService

  @Test
  fun withoutToken_returnsUnauthorized() {
    mockMvc.perform(get("/api/messages")).andExpect(status().isUnauthorized)
  }
}
