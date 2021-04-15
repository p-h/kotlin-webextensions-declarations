package proxy

import types.Setting
import webRequest.HttpHeaders
import webRequest.ResourceType
import webRequest.UrlClassification
import webextensions.Event

/**
 * An object which describes proxy settings.
 * @param proxyType The type of proxy to use.
 * @param http The address of the http proxy, can include a port.
 * @param httpProxyAll Use the http proxy server for all protocols.
 * @param ftp The address of the ftp proxy, can include a port.  Deprecated since Firefox 88.
 * @param ssl The address of the ssl proxy, can include a port.
 * @param socks The address of the socks proxy, can include a port.
 * @param socksVersion The version of the socks proxy.
 * @param passthrough A list of hosts which should not be proxied.
 * @param autoConfigUrl A URL to use to configure the proxy.
 * @param autoLogin Do not prompt for authentication if password is saved.
 * @param proxyDNS Proxy DNS when using SOCKS v5.
 * @param respectBeConservative  If true (the default value), do not use newer TLS protocol features
        that might have interoperability problems on the Internet. This is intended only for use
        with critical infrastructure like the updates, and is only available to privileged addons.
 */
class ProxyConfig(
    var proxyType: String? = null,
    var http: String? = null,
    var httpProxyAll: Boolean? = null,
    var ftp: String? = null,
    var ssl: String? = null,
    var socks: String? = null,
    var socksVersion: Int? = null,
    var passthrough: String? = null,
    var autoConfigUrl: String? = null,
    var autoLogin: Boolean? = null,
    var proxyDNS: Boolean? = null,
    var respectBeConservative: Boolean? = null
)

/**
 * @param requestId The ID of the request. Request IDs are unique within a browser session. As a
        result, they could be used to relate different events of the same request.
 * @param method Standard HTTP method.
 * @param frameId The value 0 indicates that the request happens in the main frame; a positive value
        indicates the ID of a subframe in which the request happens. If the document of a
        (sub-)frame is loaded (<code>type</code> is <code>main_frame</code> or
        <code>sub_frame</code>), <code>frameId</code> indicates the ID of this frame, not the ID of
        the outer frame. Frame IDs are unique within a tab.
 * @param parentFrameId ID of frame that wraps the frame which sent the request. Set to -1 if no
        parent frame exists.
 * @param incognito True for private browsing requests.
 * @param cookieStoreId The cookie store ID of the contextual identity.
 * @param originUrl URL of the resource that triggered this request.
 * @param documentUrl URL of the page into which the requested resource will be loaded.
 * @param tabId The ID of the tab in which the request takes place. Set to -1 if the request isn't
        related to a tab.
 * @param type How the requested resource will be used.
 * @param timeStamp The time when this signal is triggered, in milliseconds since the epoch.
 * @param fromCache Indicates if this response was fetched from disk cache.
 * @param requestHeaders The HTTP request headers that are going to be sent out with this request.
 * @param urlClassification Url classification if the request has been classified.
 * @param thirdParty Indicates if this request and its content window hierarchy is third party.
 */
class Details(
    var requestId: String,
    var url: String,
    var method: String,
    var frameId: Int,
    var parentFrameId: Int,
    var incognito: Boolean? = null,
    var cookieStoreId: String? = null,
    var originUrl: String? = null,
    var documentUrl: String? = null,
    var tabId: Int,
    var type: ResourceType,
    var timeStamp: Float,
    var fromCache: Boolean,
    var requestHeaders: HttpHeaders? = null,
    var urlClassification: UrlClassification,
    var thirdParty: Boolean
)

typealias Error = Any

external class ProxyNamespace {
    /**
     * Fired when proxy data is needed for a request.
     *
     * @param details null */
    val onRequest: Event<(details: Details) -> Unit>

    /**
     * Notifies about errors caused by the invalid use of the proxy API.
     *
     * @param error null */
    val onError: Event<(error: Error) -> Unit>

    /**
     * Configures proxy settings. This setting's value is an object of type ProxyConfig.
     */
    var settings: Setting
}
