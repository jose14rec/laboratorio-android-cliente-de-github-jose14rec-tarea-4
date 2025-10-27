package ec.edu.uisek.githubclient.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ec.edu.uisek.githubclient.R

private const val ARG_NAME = "arg_name"
private const val ARG_DESC = "arg_desc"

class RepoDetailFragment : Fragment() {

    private var repoName: String? = null
    private var repoDesc: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            repoName = it.getString(ARG_NAME)
            repoDesc = it.getString(ARG_DESC)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_repo_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tvName = view.findViewById<TextView>(R.id.tvDetailName)
        val tvDesc = view.findViewById<TextView>(R.id.tvDetailDesc)

        tvName.text = repoName
        tvDesc.text = repoDesc
    }

    companion object {
        fun newInstance(name: String, desc: String) = RepoDetailFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_NAME, name)
                putString(ARG_DESC, desc)
            }
        }
    }
}

