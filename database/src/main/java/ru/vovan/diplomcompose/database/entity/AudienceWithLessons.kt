package ru.vovan.diplomcompose.database.entity

import androidx.room.Embedded
import androidx.room.Relation

data class AudienceWithLessons (
    @Embedded val audience: Audience,
    @Relation(
        parentColumn = "numberOfAudience",
        entityColumn = "audienceId"
    )
    val lesson: List<Lesson>
)