package app.flux.api.models.callbacks

import app.flux.api.models.UserModel
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class UserModelCallbacks : BeforeConvertCallback<UserModel> {
    override fun onBeforeConvert(user: UserModel): UserModel {
        if (user.id == null) {
            user.id = UUID.randomUUID()
        }

        return user
    }
}
