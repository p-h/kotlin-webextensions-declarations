package urlbar

import kotlin.js.Promise
import types.Setting
import webextensions.Event

/**
 * The state of an engagement made with the urlbar by the user. <code>start</code>: The user has
        started an engagement. <code>engagement</code>: The user has completed an engagement by
        picking a result. <code>abandonment</code>: The user has abandoned their engagement, for
        example by blurring the urlbar. <code>discard</code>: The engagement ended in a way that
        should be ignored by listeners. */
typealias EngagementState = String

/**
 * A query performed in the urlbar.
 * @param isPrivate Whether the query's browser context is private.
 * @param maxResults The maximum number of results shown to the user.
 * @param searchString The query's search string.
 * @param sources List of acceptable source types to return.
 */
class Query(
    var isPrivate: Boolean,
    var maxResults: Int,
    var searchString: String,
    var sources: Array<SourceType>
)

/**
 * A result of a query. Queries can have many results. Each result is created by a provider.
 * @param payload An object with arbitrary properties depending on the result's type.
 * @param source The result's source.
 * @param type The result's type.
 * @param suggestedIndex Suggest a preferred position for this result within the result set.
 */
class Result(
    var payload: Payload,
    var source: SourceType,
    var type: ResultType,
    var suggestedIndex: Int? = null
)

/**
 * Possible types of results. <code>dynamic</code>: A result whose view and payload are specified by
        the extension. <code>remote_tab</code>: A synced tab from another device.
        <code>search</code>: A search suggestion from a search engine. <code>tab</code>: An open tab
        in the browser. <code>tip</code>: An actionable message to help the user with their query.
        <code>url</code>: A URL that's not one of the other types. */
typealias ResultType = String

/**
 * Options to the <code>search</code> function.
 * @param focus Whether to focus the input field and select its contents.
 */
class SearchOptions(
    var focus: Boolean? = null
)

/**
 * Possible sources of results. <code>bookmarks</code>: The result comes from the user's bookmarks.
        <code>history</code>: The result comes from the user's history. <code>local</code>: The
        result comes from some local source not covered by another source type.
        <code>network</code>: The result comes from some network source not covered by another
        source type. <code>search</code>: The result comes from a search engine. <code>tabs</code>:
        The result is an open tab in the browser or a synced tab from another device. */
typealias SourceType = String

/**
 * An object with arbitrary properties depending on the result's type. */
typealias Payload = Any

/**
 * The payload of the result that was picked. */
typealias Payload2 = Any

external class UrlbarNamespace {
    /**
     * Before a query starts, this event is fired for the given provider. Its purpose is to request
            the provider's behavior for the query. The listener should return a behavior in
            response. By default, providers are inactive, so if your provider should always be
            inactive, you don't need to listen for this event.
     *
     * @param query The query for which the behavior is requested. */
    val onBehaviorRequested: Event<(query: Query) -> Unit>

    /**
     * This event is fired when the user starts and ends an engagement with the urlbar.
     *
     * @param state The state of the engagement. */
    val onEngagement: Event<(state: EngagementState) -> Unit>

    /**
     * This event is fired for the given provider when a query is canceled. The listener should stop
            any ongoing fetch or creation of results and clean up its resources.
     *
     * @param query The query that was canceled. */
    val onQueryCanceled: Event<(query: Query) -> Unit>

    /**
     * When a query starts, this event is fired for the given provider if the provider is active for
            the query and there are no other providers that are restricting. Its purpose is to
            request the provider's results for the query. The listener should return a list of
            results in response.
     *
     * @param query The query for which results are requested. */
    val onResultsRequested: Event<(query: Query) -> Unit>

    /**
     * Typically, a provider includes a <code>url</code> property in its results' payloads. When the
            user picks a result with a URL, Firefox automatically loads the URL. URLs don't make
            sense for every result type, however. When the user picks a result without a URL, this
            event is fired. The provider should take an appropriate action in response. Currently
            the only applicable <code>ResultTypes</code> are <code>dynamic</code> and
            <code>tip</code>.
     *
     * @param payload The payload of the result that was picked.
     * @param elementName If the result is a dynamic type, this is the name of the element in the
            result view that was picked. If the result is not a dynamic type, this is an empty
            string. */
    val onResultPicked: Event<(payload: Payload2, elementName: String) -> Unit>

    /**
     * Enables or disables the engagement telemetry.
     */
    var engagementTelemetry: Setting

    /**
     * Closes the urlbar view in the current window.
     */
    fun closeView(): Promise<Any>

    /**
     * Focuses the urlbar in the current window.
     */
    fun focus(select: Boolean? = definedExternally): Promise<Any>

    /**
     * Starts a search in the urlbar in the current window.
     */
    fun search(searchString: String, options: SearchOptions? = definedExternally): Promise<Any>
}
