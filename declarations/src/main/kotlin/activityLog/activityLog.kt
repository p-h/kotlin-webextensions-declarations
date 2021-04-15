package activityLog

import extensionTypes.Date
import webextensions.Event

/**
 * The result of the call. */
typealias Result = Any

/**
 * @param args A list of arguments passed to the call.
 * @param result The result of the call.
 * @param tabId The tab associated with this event if it is a tab or content script.
 * @param url If the type is content_script, this is the url of the script that was injected.
 */
class Data(
    var args: Array<dynamic>? = null,
    var result: Result? = null,
    var tabId: Int? = null,
    var url: String? = null
)

/**
 * @param timeStamp The date string when this call is triggered.
 * @param type The type of log entry.  api_call is a function call made by the extension and
        api_event is an event callback to the extension.  content_script is logged when a content
        script is injected.
 * @param viewType The type of view where the activity occurred.  Content scripts will not have a
        viewType.
 * @param name The name of the api call or event, or the script url if this is a content or user
        script event.
 */
class Details(
    var timeStamp: Date,
    var type: String,
    var viewType: String? = null,
    var name: String,
    var data: Data
)

external class ActivityLogNamespace {
    /**
     * Receives an activityItem for each logging event.
     *
     * @param details null */
    val onExtensionActivity: Event<(details: Details) -> Unit>
}
