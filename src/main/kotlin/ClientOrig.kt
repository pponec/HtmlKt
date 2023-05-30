package xx

import kotlinx.html.div
import kotlinx.html.dom.append
import org.w3c.dom.Node
import kotlinx.browser.document
import kotlinx.browser.window

fun main() {
    window.onload = { document.body?.sayHello() }
}

fun Node.sayHello() {
    append {
        div {
            +"Hello from JS"
            div { + "--------1"}
            div { + "--------2"}
            div { + "--------3"}
            +"11"
            +"22"
            +"33"

        }

        div {
            +"Hello from JS2"
        }

        div {
            +"Hello from JS3"
        }

    }
}