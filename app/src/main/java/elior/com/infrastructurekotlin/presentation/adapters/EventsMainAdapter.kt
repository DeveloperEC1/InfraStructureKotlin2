package elior.com.infrastructurekotlin.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import elior.com.infrastructurekotlin.MainGraphDirections
import elior.com.infrastructurekotlin.R
import elior.com.infrastructurekotlin.data.models.Events
import elior.com.infrastructurekotlin.databinding.AdapterEventsMainBinding
import elior.com.infrastructurekotlin.presentation.adapters.viewholders.EventsMainViewHolder

class EventsMainAdapter : RecyclerView.Adapter<EventsMainViewHolder>() {

    private var eventsArrayList: ArrayList<Events> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsMainViewHolder {
        val binding: AdapterEventsMainBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.adapter_events_main,
            parent,
            false
        )
        return EventsMainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventsMainViewHolder, position: Int) {
        val event: Events = eventsArrayList[position]

        holder.binding.event = event

        holder.itemView.setOnClickListener {
            findNavController(it).navigate(
                MainGraphDirections.actionNavigateToFavoritesFragment(event)
            )

//            val bundle = Bundle()
//            bundle.putSerializable("eventsData", event)
//            findNavController(it).navigate(R.id.action_navigate_to_favorites_fragment, bundle)
        }
    }

    override fun getItemCount() = eventsArrayList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(eventsArrayList: ArrayList<Events>) {
        this.eventsArrayList = eventsArrayList
        notifyDataSetChanged()
    }

}
