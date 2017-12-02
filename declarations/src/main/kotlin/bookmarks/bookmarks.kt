package bookmarks

import browser.Event
import kotlin.js.Promise

/**
 * Indicates the reason why this node is unmodifiable. The <var>managed</var> value indicates that this node was configured by the system administrator or by the custodian of a supervised user. Omitted if the node can be modified by the user and the extension (default). */
typealias BookmarkTreeNodeUnmodifiable = String

/**
 * Indicates the type of a BookmarkTreeNode, which can be one of bookmark, folder or separator. */
typealias BookmarkTreeNodeType = String

/**
 * A node (either a bookmark or a folder) in the bookmark tree.  Child nodes are ordered within their parent folder.
 */
class BookmarkTreeNode(
        /**
         * The unique identifier for the node. IDs are unique within the current profile, and they remain valid even after the browser is restarted.
         */
        var id: String,
        /**
         * The <code>id</code> of the parent folder.  Omitted for the root node.
         */
        var parentId: String? = null,
        /**
         * The 0-based position of this node within its parent folder.
         */
        var index: Int? = null,
        /**
         * The URL navigated to when a user clicks the bookmark. Omitted for folders.
         */
        var url: String? = null,
        /**
         * The text displayed for the node.
         */
        var title: String,
        /**
         * When this node was created, in milliseconds since the epoch (<code>new Date(dateAdded)</code>).
         */
        var dateAdded: Int? = null,
        /**
         * When the contents of this folder last changed, in milliseconds since the epoch.
         */
        var dateGroupModified: Int? = null,
        /**
         * Indicates the reason why this node is unmodifiable. The <var>managed</var> value indicates that this node was configured by the system administrator or by the custodian of a supervised user. Omitted if the node can be modified by the user and the extension (default).
         */
        var unmodifiable: BookmarkTreeNodeUnmodifiable? = null,
        /**
         * Indicates the type of the BookmarkTreeNode, which can be one of bookmark, folder or separator.
         */
        var type: BookmarkTreeNodeType? = null,
        /**
         * An ordered list of children of this node.
         */
        var children: Array<BookmarkTreeNode>? = null
)

/**
 * Object passed to the create() function.
 */
class CreateDetails(
        /**
         * Defaults to the Other Bookmarks folder.
         */
        var parentId: String? = null,
        var index: Int? = null,
        var title: String? = null,
        var url: String? = null,
        /**
         * Indicates the type of BookmarkTreeNode to create, which can be one of bookmark, folder or separator.
         */
        var type: BookmarkTreeNodeType? = null
)

/**
 * A single string-valued id, or an array of string-valued ids */
typealias IdOrIdList = Any

/**
 * An object specifying properties and values to match when searching. Produces bookmarks matching all properties.
 */
class Query(
        /**
         * A string of words and quoted phrases that are matched against bookmark URLs and titles.
         */
        var query: String? = null,
        /**
         * The URL of the bookmark; matches verbatim. Note that folders have no URL.
         */
        var url: String? = null,
        /**
         * The title of the bookmark; matches verbatim.
         */
        var title: String? = null
)

/**
 * Either a string of words and quoted phrases that are matched against bookmark URLs and titles, or an object. If an object, the properties <code>query</code>, <code>url</code>, and <code>title</code> may be specified and bookmarks matching all specified properties will be produced. */
typealias Query2 = Any

class Destination(var parentId: String? = null, var index: Int? = null)

class Changes(var title: String? = null, var url: String? = null)

class RemoveInfo(
        var parentId: String,
        var index: Int,
        var node: BookmarkTreeNode
)

class ChangeInfo(var title: String, var url: String? = null)

class MoveInfo(
        var parentId: String,
        var index: Int,
        var oldParentId: String,
        var oldIndex: Int
)

class ReorderInfo(var childIds: Array<String>)

external class BookmarksNamespace {
    val onCreated: Event<(id: String, bookmark: BookmarkTreeNode) -> Unit>

    val onRemoved: Event<(id: String, removeInfo: RemoveInfo) -> Unit>

    val onChanged: Event<(id: String, changeInfo: ChangeInfo) -> Unit>

    val onMoved: Event<(id: String, moveInfo: MoveInfo) -> Unit>

    /**
     * Retrieves the specified BookmarkTreeNode(s).
     */
    fun get(idOrIdList: String): Promise<Array<BookmarkTreeNode>>

    /**
     * Retrieves the specified BookmarkTreeNode(s).
     */
    fun get(idOrIdList: Array<String>): Promise<Array<BookmarkTreeNode>>

    /**
     * Retrieves the children of the specified BookmarkTreeNode id.
     */
    fun getChildren(id: String): Promise<Array<BookmarkTreeNode>>

    /**
     * Retrieves the recently added bookmarks.
     */
    fun getRecent(numberOfItems: Int): Promise<Array<BookmarkTreeNode>>

    /**
     * Retrieves the entire Bookmarks hierarchy.
     */
    fun getTree(): Promise<Array<BookmarkTreeNode>>

    /**
     * Retrieves part of the Bookmarks hierarchy, starting at the specified node.
     */
    fun getSubTree(id: String): Promise<Array<BookmarkTreeNode>>

    /**
     * Searches for BookmarkTreeNodes matching the given query. Queries specified with an object produce BookmarkTreeNodes matching all specified properties.
     */
    fun search(query: String): Promise<Array<BookmarkTreeNode>>

    /**
     * Searches for BookmarkTreeNodes matching the given query. Queries specified with an object produce BookmarkTreeNodes matching all specified properties.
     */
    fun search(query: Query): Promise<Array<BookmarkTreeNode>>

    /**
     * Creates a bookmark or folder under the specified parentId.  If url is NULL or missing, it will be a folder.
     */
    fun create(bookmark: CreateDetails): Promise<BookmarkTreeNode>

    /**
     * Moves the specified BookmarkTreeNode to the provided location.
     */
    fun move(id: String, destination: Destination): Promise<BookmarkTreeNode>

    /**
     * Updates the properties of a bookmark or folder. Specify only the properties that you want to change; unspecified properties will be left unchanged.  <b>Note:</b> Currently, only 'title' and 'url' are supported.
     */
    fun update(id: String, changes: Changes): Promise<BookmarkTreeNode>

    /**
     * Removes a bookmark or an empty bookmark folder.
     */
    fun remove(id: String): Promise<Any>

    /**
     * Recursively removes a bookmark folder.
     */
    fun removeTree(id: String): Promise<Any>
}
