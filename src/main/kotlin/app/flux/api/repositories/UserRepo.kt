package app.flux.api.repositories

//import app.flux.api.models.UserModel
import app.flux.api.models.UserModel
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.r2dbc.core.DatabaseClient
//import org.springframework.data.r2dbc.repository.R2dbcRepository
//import org.springframework.data.repository.Repository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
//import org.springframework.r2dbc.core.DatabaseClient
import java.util.*

//import org.springframework.stereotype.Repository
//import java.util.*

//@Repository
//class UserRepo(
//  private val databaseClient: DatabaseClient
//) {
//  suspend fun save(user: UserModel) {
//    databaseClient.insert()
//  }
//}



@Repository
interface UserRepo : CoroutineCrudRepository <UserModel, UUID> {

}
