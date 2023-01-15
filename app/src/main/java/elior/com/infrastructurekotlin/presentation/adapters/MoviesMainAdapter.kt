package elior.com.infrastructurekotlin.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import elior.com.infrastructurekotlin.MainGraphDirections
import elior.com.infrastructurekotlin.R
import elior.com.infrastructurekotlin.data.models.Results
import elior.com.infrastructurekotlin.databinding.AdapterMoviesMainBinding
import elior.com.infrastructurekotlin.presentation.adapters.viewholders.MoviesMainViewHolder

class MoviesMainAdapter : RecyclerView.Adapter<MoviesMainViewHolder>() {

    private lateinit var resultsArrayList: ArrayList<Results>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesMainViewHolder {
        val binding: AdapterMoviesMainBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.adapter_movies_main,
            parent,
            false
        )
        return MoviesMainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesMainViewHolder, position: Int) {
        val result: Results = resultsArrayList[position]

        holder.binding.result = result

        holder.itemView.setOnClickListener {
            findNavController(it).navigate(
                MainGraphDirections.actionNavigateToFavoritesFragment(result)
            )

//            val bundle = Bundle()
//            bundle.putSerializable("resultsData", result)
//            findNavController(it).navigate(R.id.action_navigate_to_favorites_fragment, bundle)
        }
    }

    override fun getItemCount() = resultsArrayList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(resultsArrayList: ArrayList<Results>) {
        this.resultsArrayList = resultsArrayList
        notifyDataSetChanged()
    }

}
