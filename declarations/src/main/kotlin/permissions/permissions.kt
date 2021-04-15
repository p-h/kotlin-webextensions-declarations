package permissions

import kotlin.js.Promise
import manifest.MatchPattern
import manifest.OptionalPermission
import manifest.Permission
import webextensions.Event

class Permissions(var permissions: Array<OptionalPermission>? = null, var origins:
        Array<MatchPattern>? = null)

class AnyPermissions(var permissions: Array<Permission>? = null, var origins: Array<MatchPattern>? =
        null)

external class PermissionsNamespace {
    /**
     * Fired when the extension acquires new permissions.
     *
     * @param permissions null */
    val onAdded: Event<(permissions: Permissions) -> Unit>

    /**
     * Fired when permissions are removed from the extension.
     *
     * @param permissions null */
    val onRemoved: Event<(permissions: Permissions) -> Unit>

    /**
     * Get a list of all the extension's permissions.
     */
    fun getAll(): Promise<AnyPermissions>

    /**
     * Check if the extension has the given permissions.
     */
    fun contains(permissions: AnyPermissions): Promise<Boolean>

    /**
     * Request the given permissions.
     */
    fun request(permissions: Permissions): Promise<Boolean>

    /**
     * Relinquish the given permissions.
     */
    fun remove(permissions: Permissions): Promise<Any>
}
