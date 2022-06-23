package deepshikha.jangidyahoo.retrofit_poc.View

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import deepshikha.jangidyahoo.retrofit_poc.R
import deepshikha.jangidyahoo.retrofit_poc.model.item
import java.util.ArrayList


class ItemAdapter(private val context: Context, private val mDetails: List<item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemCLick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rowitem, parent, false)
        return ViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        holder.link?.text = "Profile Link : " + mDetails[position].link
        Picasso.get().load(mDetails[position].profile_image).into(holder.profile_image)
        holder.name?.text = "Name : " + mDetails[position].display_name

    }

    override fun getItemCount(): Int {
        return mDetails.size
    }

    class ViewHolder(val ItemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(ItemView) {
        val profile_image: ImageView = ItemView.findViewById(R.id.image)
        val link: TextView = ItemView.findViewById(R.id.link)
        val name: TextView = ItemView.findViewById(R.id.name)
        init {
            itemView.setOnClickListener {
                listener.onItemCLick(adapterPosition)
            }
        }


    }

}