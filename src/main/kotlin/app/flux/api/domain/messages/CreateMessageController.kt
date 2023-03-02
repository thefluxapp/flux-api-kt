package app.flux.api.domain.messages

import jakarta.validation.Valid
import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.ReactiveSecurityContextHolder
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@RestController
class CreateMessageController (
  private val createMessageService: CreateMessageService
) {
  @PostMapping("api/messages")
  suspend fun call (@Valid @RequestBody createMessageRequest: CreateMessageRequest, authentication: Authentication?) {

    val qq2 = SecurityContextHolder.getContext().authentication?.principal
    val qq3 = ReactiveSecurityContextHolder.getContext().awaitSingle()?.authentication
    val qq = authentication?.principal
    println("authentication: " + authentication)
    println("qq: " + qq)
    println("qq2: " + qq2)
    println("qq3: " + qq3)
    createMessageService.call(createMessageRequest)
  }
}
