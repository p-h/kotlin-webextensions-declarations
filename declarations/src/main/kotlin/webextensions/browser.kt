package webextensions

import activityLog.ActivityLogNamespace
import alarms.AlarmsNamespace
import bookmarks.BookmarksNamespace
import browserAction.BrowserActionNamespace
import browserSettings.BrowserSettingsNamespace
import browsingData.BrowsingDataNamespace
import captivePortal.CaptivePortalNamespace
import clipboard.ClipboardNamespace
import commands.CommandsNamespace
import contentScripts.ContentScriptsNamespace
import contextMenus.ContextMenusNamespace
import contextualIdentities.ContextualIdentitiesNamespace
import cookies.CookiesNamespace
import devtools.DevtoolsNamespace
import dns.DnsNamespace
import downloads.DownloadsNamespace
import events.EventsNamespace
import experiments.ExperimentsNamespace
import extension.ExtensionNamespace
import extensionTypes.ExtensionTypesNamespace
import find.FindNamespace
import geckoProfiler.GeckoProfilerNamespace
import history.HistoryNamespace
import i18n.I18nNamespace
import identity.IdentityNamespace
import idle.IdleNamespace
import management.ManagementNamespace
import manifest.ManifestNamespace
import menus.MenusNamespace
import networkStatus.NetworkStatusNamespace
import normandyAddonStudy.NormandyAddonStudyNamespace
import notifications.NotificationsNamespace
import omnibox.OmniboxNamespace
import pageAction.PageActionNamespace
import permissions.PermissionsNamespace
import pkcs11.Pkcs11Namespace
import privacy.PrivacyNamespace
import proxy.ProxyNamespace
import runtime.RuntimeNamespace
import search.SearchNamespace
import sessions.SessionsNamespace
import sidebarAction.SidebarActionNamespace
import storage.StorageNamespace
import tabs.TabsNamespace
import telemetry.TelemetryNamespace
import test.TestNamespace
import theme.ThemeNamespace
import topSites.TopSitesNamespace
import types.TypesNamespace
import urlbar.UrlbarNamespace
import userScripts.UserScriptsNamespace
import webNavigation.WebNavigationNamespace
import webRequest.WebRequestNamespace
import windows.WindowsNamespace

external class Browser {
    val manifest: ManifestNamespace

    val bookmarks: BookmarksNamespace

    val commands: CommandsNamespace

    val devtools: DevtoolsNamespace

    val find: FindNamespace

    val history: HistoryNamespace

    val contextMenus: ContextMenusNamespace

    val menus: MenusNamespace

    val normandyAddonStudy: NormandyAddonStudyNamespace

    val omnibox: OmniboxNamespace

    val pkcs11: Pkcs11Namespace

    val search: SearchNamespace

    val sessions: SessionsNamespace

    val sidebarAction: SidebarActionNamespace

    val tabs: TabsNamespace

    val topSites: TopSitesNamespace

    val urlbar: UrlbarNamespace

    val windows: WindowsNamespace

    val activityLog: ActivityLogNamespace

    val alarms: AlarmsNamespace

    val browserAction: BrowserActionNamespace

    val browserSettings: BrowserSettingsNamespace

    val browsingData: BrowsingDataNamespace

    val captivePortal: CaptivePortalNamespace

    val clipboard: ClipboardNamespace

    val contentScripts: ContentScriptsNamespace

    val contextualIdentities: ContextualIdentitiesNamespace

    val cookies: CookiesNamespace

    val dns: DnsNamespace

    val downloads: DownloadsNamespace

    val events: EventsNamespace

    val experiments: ExperimentsNamespace

    val extension: ExtensionNamespace

    val extensionTypes: ExtensionTypesNamespace

    val geckoProfiler: GeckoProfilerNamespace

    val i18n: I18nNamespace

    val identity: IdentityNamespace

    val idle: IdleNamespace

    val management: ManagementNamespace

    val networkStatus: NetworkStatusNamespace

    val notifications: NotificationsNamespace

    val pageAction: PageActionNamespace

    val permissions: PermissionsNamespace

    val privacy: PrivacyNamespace

    val proxy: ProxyNamespace

    val runtime: RuntimeNamespace

    val storage: StorageNamespace

    val telemetry: TelemetryNamespace

    val test: TestNamespace

    val theme: ThemeNamespace

    val types: TypesNamespace

    val userScripts: UserScriptsNamespace

    val webNavigation: WebNavigationNamespace

    val webRequest: WebRequestNamespace
}

external class Event<in T> {
    fun addListener(listener: T)

    fun removeListener(listener: T)

    fun hasListener(listener: T): Boolean
}

external val browser: Browser
