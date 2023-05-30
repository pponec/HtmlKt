package test

import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.html.*
import kotlinx.html.dom.append
import kotlinx.html.js.onClickFunction
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.events.Event
import kotlin.random.Random

val rootId = "root"
val tableSize = 5

fun main() {
    window.onload = { document.body?.printHtmlPage() }
}

fun Node.printHtmlPage() {

    append {
        body {
            h1 {
                text("Table random generator")
            }
            div {
                id = rootId
                div {
                    text("My table")
                }
            }
            button {
                onClickFunction = regenerateTableEvent()
                + "Refresh table"
            }
        }
    }

    regenerateTable()
}

fun createTable(): Element {
    val table : Element = document.createElement("table")

    table.id = "myTable"
    for (i in 0 until tableSize) {
        val row = document.createElement("tr")
        for (j in 0 until tableSize) {
            val cell = document.createElement("td")
            cell.textContent = generateRandomNumber().toString()
            row.appendChild(cell)
        }
        table.appendChild(row)
    }
    return table
}

fun generateRandomNumber(): Int {
    return Random.nextInt(1, 101)
}

fun regenerateTable() {
    val root = document.getElementById(rootId)
    removeAllChildElements(root)
    root?.appendChild(createTable())
}

fun regenerateTableEvent(): (Event) -> Unit {
    return { event ->
        regenerateTable()
    }
}

fun removeAllChildElements(parentElement: Element?) {
    parentElement?.let { parent ->
        while (parent.firstChild != null) {
            parent.removeChild(parent.firstChild!!)
        }
    }
}