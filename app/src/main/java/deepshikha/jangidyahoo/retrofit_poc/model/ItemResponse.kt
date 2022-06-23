package deepshikha.jangidyahoo.retrofit_poc.model

import com.google.gson.annotations.SerializedName

class ItemResponse
    (@SerializedName("items") val items : List<item>)

class item (
    val link: String,
    val profile_image: String,
    val display_name: String,
    val reputation: String,
    val location: String,
    val account_id: String
)





