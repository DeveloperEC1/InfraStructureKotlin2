package elior.com.infrastructurekotlin.models

import java.io.Serializable

data class Results(
    var title: String? = "",
    var overview: String? = "",
    var poster_path: String? = ""
) : Serializable
