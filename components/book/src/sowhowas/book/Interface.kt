package sowhowas.book

import java.util.UUID

object Interface {
    fun all(): Collection<Book> = Core.all()
    fun findById(id: UUID): Book? = Core.findById(id)
}

data class Book(
        val id: UUID,
        val name: String
)