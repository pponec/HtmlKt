package test2

import kotlinx.html.div
import kotlinx.html.dom.append
import org.w3c.dom.Node
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.html.*
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.events.Event
import org.w3c.dom.get

fun main() {
    window.onload = { document.body?.printHtmlPage() }
}

fun Node.printHtmlPage() {

    val pageTitle = "Původní název stránky"

    append {
        body {
            h1 {
                text(pageTitle)
            }
            div {
                button {
                    id = "button1"
                    onClickFunction = changeTitleOnClick("Button 1")
                    text("Button 1")
                }
            }
            div {
                button {
                    id = "button2"
                    onClickFunction = changeTitleOnClick("Button 2")
                    text("Button 2")
                }
            }
        }
    }
}

fun changeTitleOnClick(newTitle: String): (Event) -> Unit {
    return { event ->
        val button = event.target as? HTMLButtonElement
        button?.let {
            val h1 = document.getElementsByTagName("h1").get(0)
            h1?.textContent = newTitle
        }
    }
}