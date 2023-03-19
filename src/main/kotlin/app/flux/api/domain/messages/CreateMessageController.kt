package app.flux.api.domain.messages

import jakarta.validation.Valid
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CreateMessageController(private val createMessageService: CreateMessageService) {
    @PostMapping("api/messages")
    fun call(
        @Valid @RequestBody
        createMessageRequest: CreateMessageRequest,
        authentication: Authentication?,
    ) {
        println("authentication: ${authentication?.principal}")
        createMessageService.call(createMessageRequest)
    }
}
