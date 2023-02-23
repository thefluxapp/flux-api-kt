package app.flux.api.repositories

import app.flux.api.models.UserModel
import java.util.*
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository interface UserRepo : CoroutineCrudRepository<UserModel, UUID>
