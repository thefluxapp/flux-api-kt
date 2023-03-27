package app.flux.api.domain.message

import jakarta.validation.Valid
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/messages")
class CreateMessageController(private val createMessageService: CreateMessageService) {
    @PostMapping
    @PreAuthorize("isAuthenticated()")
    fun create(
        @Valid @RequestBody
        createMessageRequest: CreateMessageRequest,
        authentication: Authentication?,
    ) {
        println("createMessageRequest: $createMessageRequest")
        println("authentication: ${authentication?.principal}")
        createMessageService.createMessage(createMessageRequest)
    }
}
