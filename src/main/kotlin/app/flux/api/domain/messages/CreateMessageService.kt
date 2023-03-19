package app.flux.api.domain.messages

import org.springframework.stereotype.Service

@Service
class CreateMessageService {
    fun call(createMessageRequest: CreateMessageRequest) {
        println(createMessageRequest)
    }
}
