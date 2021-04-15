package normandyAddonStudy

import extensionTypes.Date
import kotlin.js.Promise
import webextensions.Event

/**
 * @param recipeId The ID of the recipe for the study.
 * @param slug A slug to identify the study.
 * @param userFacingName The name presented on about:studies.
 * @param userFacingDescription The description presented on about:studies.
 * @param branch The study branch in which the user is enrolled.
 * @param active The state of the study.
 * @param addonId The ID of the extension installed by the study.
 * @param addonUrl The URL of the XPI that was downloaded and installed by the study.
 * @param addonVersion The version of the extension installed by the study.
 * @param studyStartDate The start date for the study.
 * @param studyEndDate The end date for the study.
 * @param extensionApiId The record ID for the extension in Normandy server's database.
 * @param extensionHash A hash of the extension XPI file.
 * @param extensionHashAlgorithm The algorithm used to hash the extension XPI file.
 */
class Study(
    var recipeId: Int,
    var slug: String,
    var userFacingName: String,
    var userFacingDescription: String,
    var branch: String,
    var active: Boolean,
    var addonId: String,
    var addonUrl: String,
    var addonVersion: String,
    var studyStartDate: Date,
    var studyEndDate: Date,
    var extensionApiId: Int,
    var extensionHash: String,
    var extensionHashAlgorithm: String
)

external class NormandyAddonStudyNamespace {
    /**
     * Fired when a user unenrolls from a study but before the addon is uninstalled.
     *
     * @param reason The reason why the study is ending. */
    val onUnenroll: Event<(reason: String) -> Unit>

    /**
     * Returns a study object for the current study.
     */
    fun getStudy(): Promise<Any>

    /**
     * Marks the study as ended and then uninstalls the addon.
     */
    fun endStudy(reason: String): Promise<Any>

    /**
     * Returns an object with metadata about the client which may be required for constructing
            survey URLs.
     */
    fun getClientMetadata(): Promise<Any>
}
