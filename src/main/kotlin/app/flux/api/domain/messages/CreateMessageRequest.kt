package app.flux.api.domain.messages

import jakarta.validation.constraints.NotEmpty

data class CreateMessageRequest(@field:NotEmpty val text: String)
