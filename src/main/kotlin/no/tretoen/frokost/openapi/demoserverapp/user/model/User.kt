package no.tretoen.frokost.openapi.demoserverapp.user.model

import java.time.Instant
import java.time.LocalDate

data class User(
    val id: Int,
    val name: String,
    val dateOfBirth: LocalDate,
    val createdAt: Instant = Instant.now(),
    val updatedAt: Instant = Instant.now()
)

