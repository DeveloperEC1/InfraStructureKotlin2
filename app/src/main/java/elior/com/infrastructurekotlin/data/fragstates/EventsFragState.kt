package elior.com.infrastructurekotlin.data.fragstates

data class EventsFragState(
    var showWait: Boolean = false,
    var isOk: Boolean = false,
    var errorMsg: String? = null,
    var stateErrorCode: Int = 0,
    var isHasBeenViewed: Boolean = false,
    var state: String? = null,
)