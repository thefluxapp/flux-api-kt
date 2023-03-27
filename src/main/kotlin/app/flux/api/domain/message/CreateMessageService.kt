package app.flux.api.domain.message

import org.springframework.stereotype.Service

@Service
class CreateMessageService {
    fun createMessage(createMessageRequest: CreateMessageRequest) {
        println(createMessageRequest)
    }
}
