package ec.edu.uisek.githubclient.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ec.edu.uisek.githubclient.R
import ec.edu.uisek.githubclient.models.Repo

class RepoAdapter(
    private val items: List<Repo>,
    private val onItemClick: (Repo) -> Unit
) : RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    inner class RepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgAvatar: ImageView = view.findViewById(R.id.imgAvatar)
        val tvName: TextView = view.findViewById(R.id.txtName)
        val tvDesc: TextView = view.findViewById(R.id.txtDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false)
        return RepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repo = items[position]
        holder.tvName.text = repo.name
        holder.tvDesc.text = repo.description
        holder.imgAvatar.setImageResource(repo.avatar)

        holder.itemView.setOnClickListener {
            onItemClick(repo)
        }
    }

    override fun getItemCount(): Int = items.size
}
