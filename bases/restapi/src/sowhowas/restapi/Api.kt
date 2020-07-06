package sowhowas.restapi

import io.javalin.Javalin
import io.javalin.http.NotFoundResponse
import java.util.UUID
import sowhowas.book.Interface as Book
import sowhowas.character.Interface as Character

object Api {

    @JvmStatic
    fun main(args: Array<String>) {
        val javalin = Javalin.create().start(7000)

        javalin.get("/") { ctx ->
            ctx.result(links(ctx.url()))
        }

        javalin.get("/books") { ctx -> ctx.json(Book.all()) }
        javalin.get("/books/:uuid") { ctx ->
            ctx.json(Book.findById(UUID.fromString(ctx.pathParam("uuid"))) ?: NotFoundResponse())
        }

        javalin.get("/characters") { ctx -> ctx.json(Character.all()) }
        javalin.get("/characters/:uuid") { ctx ->
            ctx.json(Character.findById(UUID.fromString(ctx.pathParam("uuid"))) ?: NotFoundResponse())
        }

//        sowhowas.character.Core.all()
//        sowhowas.book.Core.all()
    }

    private fun links(url: String): String {
        val groups = listOf("books", "characters").joinToString(",") {
            """
                        "$it": {
                            "href": "$url$it"
                        }
                    """
        }
        return """
                    "_links": { 
                        $groups
                    }
                """.trimIndent()
    }
}