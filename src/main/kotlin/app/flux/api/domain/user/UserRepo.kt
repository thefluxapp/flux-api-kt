package app.flux.api.domain.user

import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface UserRepo : CrudRepository<UserModel, UUID>
