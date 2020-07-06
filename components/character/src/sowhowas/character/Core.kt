package sowhowas.character

import java.util.UUID
import java.util.UUID.randomUUID

internal object Core {
    fun all(): Collection<Character> = characters.values
    fun findById(id: UUID): Character? = characters[id]

    private val id1 = randomUUID()
    private val id2 = randomUUID()
    private val id3 = randomUUID()

    private val characters = mapOf(
            id1 to Character(id1, "Character 1"),
            id2 to Character(id2, "Character 2"),
            id3 to Character(id3, "Character 3")
    )
}