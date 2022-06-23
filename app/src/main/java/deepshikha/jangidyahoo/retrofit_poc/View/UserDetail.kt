package deepshikha.jangidyahoo.retrofit_poc.View

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import deepshikha.jangidyahoo.retrofit_poc.R
import deepshikha.jangidyahoo.retrofit_poc.model.item
import org.w3c.dom.Text

class UserDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_detail)

        val name : TextView = findViewById(R.id.name)
        val accountID : TextView = findViewById(R.id.accountID)
        val reputation : TextView = findViewById(R.id.reputation)
        val link : TextView = findViewById(R.id.profile_link)
        val location : TextView = findViewById(R.id.location)
        val Image : ImageView = findViewById(R.id.user_image)


        val bundle: Bundle?= intent.extras
        name.text = "Name : " + bundle!!.getString("display_name")
        accountID.text =  "Account ID : " + bundle!!.getString("accountId")
        reputation.text =  "Reputation : " +  bundle!!.getString("reputation")
        link.text =  "Link : " + bundle!!.getString("link")
        location.text = "Location : " +  bundle!!.getString("location")
        Picasso.get().load(bundle!!.getString("profile_image")).into(Image)


    }
}
