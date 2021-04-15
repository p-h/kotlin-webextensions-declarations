package captivePortal

import kotlin.js.Promise
import types.Setting
import webextensions.Event

/**
 * @param state The current captive portal state.
 */
class Details(
    var state: String
)

external class CaptivePortalNamespace {
    /**
     * Fired when the captive portal state changes.
     *
     * @param details null */
    val onStateChanged: Event<(details: Details) -> Unit>

    /**
     * This notification will be emitted when the captive portal service has determined that we can
            connect to the internet. The service will pass either `captive` if there is an unlocked
            captive portal present, or `clear` if no captive portal was detected.
     *
     * @param status null */
    val onConnectivityAvailable: Event<(status: String) -> Unit>

    /**
     * Return the canonical captive-portal detection URL. Read-only.
     */
    var canonicalURL: Setting

    /**
     * Returns the current portal state, one of `unknown`, `not_captive`, `unlocked_portal`,
            `locked_portal`.
     */
    fun getState(): Promise<Any>

    /**
     * Returns the time difference between NOW and the last time a request was completed in
            milliseconds.
     */
    fun getLastChecked(): Promise<Any>
}
