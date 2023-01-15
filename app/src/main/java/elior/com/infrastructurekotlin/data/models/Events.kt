package elior.com.infrastructurekotlin.data.models

import java.io.Serializable

data class Events(
    var activity: String? = "",
    var type: String? = "",
    var participants: String? = "",
    var price: String? = "",
    var link: String? = "",
    var key: String? = "",
    var accessibility: String? = "",
) : Serializable