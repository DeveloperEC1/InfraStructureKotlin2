package elior.com.infrastructurekotlin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import elior.com.infrastructurekotlin.MainGraphDirections
import elior.com.infrastructurekotlin.R
import elior.com.infrastructurekotlin.databinding.AdapterMoviesMainBinding
import elior.com.infrastructurekotlin.models.Results

class MoviesMainAdapter internal constructor(
    private val resultsArrayList: ArrayList<Results>
) :
    RecyclerView.Adapter<ViewHolderMain>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMain {
        val binding: AdapterMoviesMainBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.adapter_movies_main,
            parent,
            false
        )
        return ViewHolderMain(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderMain, position: Int) {
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

}
