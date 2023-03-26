package app.flux.api.domain.message

import jakarta.validation.constraints.NotEmpty

data class CreateMessageRequest(@field:NotEmpty val text: String)
