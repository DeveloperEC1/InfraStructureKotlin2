package elior.com.infrastructurekotlin.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import elior.com.infrastructurekotlin.R
import elior.com.infrastructurekotlin.data.room.EventsRoom
import elior.com.infrastructurekotlin.databinding.AdapterEventsFavoritesBinding
import elior.com.infrastructurekotlin.presentation.adapters.view_holders.EventsFavoritesViewHolder

class EventsFavoritesAdapter : RecyclerView.Adapter<EventsFavoritesViewHolder>() {

    private var eventsFavoritesArrayList: List<EventsRoom> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsFavoritesViewHolder {
        val binding: AdapterEventsFavoritesBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.adapter_events_favorites,
            parent,
            false
        )
        return EventsFavoritesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventsFavoritesViewHolder, position: Int) {
        val eventFavorites: EventsRoom = eventsFavoritesArrayList[position]

        holder.binding.eventFavorites = eventFavorites
    }

    override fun getItemCount() = eventsFavoritesArrayList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(eventsFavoritesArrayList: List<EventsRoom>) {
        this.eventsFavoritesArrayList = eventsFavoritesArrayList
        notifyDataSetChanged()
    }

}
