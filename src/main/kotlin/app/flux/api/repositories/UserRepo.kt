package app.flux.api.repositories

import app.flux.api.models.UserModel
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface UserRepo : CrudRepository<UserModel, UUID>
