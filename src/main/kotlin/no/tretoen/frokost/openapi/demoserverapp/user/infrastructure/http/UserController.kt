package no.tretoen.frokost.openapi.demoserverapp.user.infrastructure.http

import no.tretoen.frokost.openapi.demoserverapp.user.UserService
import no.tretoen.frokost.openapi.demoserverapp.user.model.User
import no.tretoen.tech.example.api.UserApi
import no.tretoen.tech.example.api.model.UserDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.time.ZoneOffset

@RestController
class UserController(
    val userService: UserService
) : UserApi {
    override fun getUsers(limit: Int?, offset: Long?): ResponseEntity<List<UserDto>> {
        val users = userService.getUsers(limit, offset)
        return ResponseEntity.ok(users.map { it.toDto() })
    }

    override fun getUserById(id: String): ResponseEntity<UserDto> {
        return userService.getUserById(id.toInt())
            ?.let { ResponseEntity.ok(it.toDto()) }
            ?: ResponseEntity.notFound().build()
    }
}

fun User.toDto(): UserDto {
    return UserDto()
        .id(this.id.toString())
        .name(this.name)
        .dateOfBirth(this.dateOfBirth)
        .createdAt(this.createdAt.atOffset(ZoneOffset.UTC))
        .updatedAt(this.updatedAt.atOffset(ZoneOffset.UTC))
}
