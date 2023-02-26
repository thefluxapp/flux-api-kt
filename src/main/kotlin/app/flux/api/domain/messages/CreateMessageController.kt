package app.flux.api.domain.messages

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@RestController
class CreateMessageController (
  private val createMessageService: CreateMessageService
) {
  @PostMapping("api/messages")
  fun call (@Valid @RequestBody createMessageRequest: CreateMessageRequest) {
    createMessageService.call(createMessageRequest)
  }
}
