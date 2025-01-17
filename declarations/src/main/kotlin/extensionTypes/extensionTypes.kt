package extensionTypes

/**
 * The format of an image. */
typealias ImageFormat = String

/**
 * Details about the format, quality, area and scale of the capture.
 * @param format The format of the resulting image.  Default is <code>"jpeg"</code>.
 * @param quality When format is <code>"jpeg"</code>, controls the quality of the resulting image. 
        This value is ignored for PNG images.  As quality is decreased, the resulting image will
        have more visual artifacts, and the number of bytes needed to store it will decrease.
 * @param rect The area of the document to capture, in CSS pixels, relative to the page.  If
        omitted, capture the visible viewport.
 * @param scale The scale of the resulting image.  Defaults to <code>devicePixelRatio</code>.
 */
class ImageDetails(
    var format: ImageFormat? = null,
    var quality: Int? = null,
    var rect: Rect? = null,
    var scale: Float? = null
)

/**
 * The soonest that the JavaScript or CSS will be injected into the tab. */
typealias RunAt = String

/**
 * The origin of the CSS to inject, this affects the cascading order (priority) of the stylesheet.
        */
typealias CSSOrigin = String

/**
 * Details of the script or CSS to inject. Either the code or the file property must be set, but
        both may not be set at the same time.
 * @param code JavaScript or CSS code to inject.<br><br><b>Warning:</b><br>Be careful using the
        <code>code</code> parameter. Incorrect use of it may open your extension to <a
        href="https://en.wikipedia.org/wiki/Cross-site_scripting">cross site scripting</a> attacks.
 * @param file JavaScript or CSS file to inject.
 * @param allFrames If allFrames is <code>true</code>, implies that the JavaScript or CSS should be
        injected into all frames of current page. By default, it's <code>false</code> and is only
        injected into the top frame.
 * @param matchAboutBlank If matchAboutBlank is true, then the code is also injected in about:blank
        and about:srcdoc frames if your extension has access to its parent document. Code cannot be
        inserted in top-level about:-frames. By default it is <code>false</code>.
 * @param frameId The ID of the frame to inject the script into. This may not be used in combination
        with <code>allFrames</code>.
 * @param runAt The soonest that the JavaScript or CSS will be injected into the tab. Defaults to
        "document_idle".
 * @param cssOrigin The css origin of the stylesheet to inject. Defaults to "author".
 */
class InjectDetails(
    var code: String? = null,
    var file: String? = null,
    var allFrames: Boolean? = null,
    var matchAboutBlank: Boolean? = null,
    var frameId: Int? = null,
    var runAt: RunAt? = null,
    var cssOrigin: CSSOrigin? = null
)

typealias Date = Any

typealias ExtensionFileOrCode = Any

/**
 * A plain JSON value */
typealias PlainJSONValue = Any

/**
 * The area of the document to capture, in CSS pixels, relative to the page.  If omitted, capture
        the visible viewport.
 */
class Rect(
    var x: Float,
    var y: Float,
    var width: Float,
    var height: Float
)

external class ExtensionTypesNamespace
