package app.flux.api.repositories

import app.flux.api.models.UserModel
import java.util.UUID
import org.springframework.data.repository.CrudRepository

interface UserRepo : CrudRepository<UserModel, UUID>
