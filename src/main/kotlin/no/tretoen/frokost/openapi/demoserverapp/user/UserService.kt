package no.tretoen.frokost.openapi.demoserverapp.user

import no.tretoen.frokost.openapi.demoserverapp.user.model.User
import org.springframework.stereotype.Service
import java.time.LocalDate

val mrWhite = User(1, name = "Mr. White", dateOfBirth = LocalDate.of(1950, 10, 10))
val mrPink = User(2, name = "Mr. Pink", dateOfBirth = LocalDate.of(1955, 4, 1))
val mrOrange = User(3, name = "Mr. Orange", dateOfBirth = LocalDate.of(1959, 3, 4))
val mrBrown = User(4, name = "Mr. Brown", dateOfBirth = LocalDate.of(1961, 6, 3))

val users = listOf(mrWhite, mrPink, mrOrange, mrBrown)

val userMap = users.associateBy { it.id }

@Service
class UserService {
    fun getUsers(limit: Int?, offset: Long?): List<User> {
        return users
    }
    
    fun getUserById(id: Int): User? {
        return userMap[id]
    }
}
