package sowhowas.character

import java.util.UUID

object Interface {
    fun all(): Collection<Character> = Core.all()
    fun findById(id: UUID): Character? = Core.findById(id)
}

data class Character(
        val id: UUID,
        val name: String
)