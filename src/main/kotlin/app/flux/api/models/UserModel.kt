package app.flux.api.models

import java.time.LocalDateTime
import java.util.UUID
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Table

@Table("users")
data class UserModel(
  @Id var id: UUID? = null,
  val login: String,
  val firstName: String? = null,
  val lastName: String? = null,
  @CreatedDate val createdAt: LocalDateTime? = null,
  @LastModifiedDate val updatedAt: LocalDateTime? = null,
)
