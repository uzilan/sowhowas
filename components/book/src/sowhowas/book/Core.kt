package sowhowas.book

import java.util.UUID
import java.util.UUID.randomUUID

internal object Core {
    internal fun findById(id: UUID): Book? = books[id]
    internal fun all(): Collection<Book> = books.values

    private val id1 = randomUUID()
    private val id2 = randomUUID()
    private val id3 = randomUUID()

    private val books = mapOf(
            id1 to Book(id1, "Book 1"),
            id2 to Book(id2, "Book 2"),
            id3 to Book(id3, "Book 3")
    )
}