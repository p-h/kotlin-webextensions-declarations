package networkStatus

import kotlin.js.Promise
import webextensions.Event

/**
 * @param status Status of the network link, if "unknown" then link is usually assumed to be "up"
 * @param type If known, the type of network connection that is avialable.
 * @param id If known, the network id or name.
 */
class NetworkLinkInfo(
    var status: String,
    var type: String,
    var id: String? = null
)

external class NetworkStatusNamespace {
    /**
     * Fired when the network connection state changes.
     *
     * @param details null */
    val onConnectionChanged: Event<(details: NetworkLinkInfo) -> Unit>

    /**
     * Returns the $(ref:NetworkLinkInfo} of the current network connection.
     */
    fun getLinkInfo(): Promise<Any>
}
