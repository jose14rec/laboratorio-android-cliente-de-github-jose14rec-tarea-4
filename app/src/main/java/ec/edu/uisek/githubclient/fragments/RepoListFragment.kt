package ec.edu.uisek.githubclient.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ec.edu.uisek.githubclient.R
import ec.edu.uisek.githubclient.adapters.RepoAdapter
import ec.edu.uisek.githubclient.models.Repo

class RepoListFragment : Fragment() {

    private val repos = listOf(
        Repo("MiPrimerRepo", "Descripción del repo número 1.", R.mipmap.ic_launcher_round),
        Repo("ClienteAndroid", "Proyecto de ejemplo para el laboratorio del curso.", R.mipmap.ic_launcher_round),
        Repo("Utils", "Librería de utilidades y helpers.", R.mipmap.ic_launcher_round),
        Repo("DemoUI", "Layouts y componentes materiales para practicar.", R.mipmap.ic_launcher_round)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_repo_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerRepos)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = RepoAdapter(repos) { repo ->
            // Acción al tocar un repo: abrir fragment de detalle
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, RepoDetailFragment.newInstance(repo.name, repo.description))
                .addToBackStack(null)
                .commit()
        }

        // Botón para abrir formulario de proyecto
        val btnAddProject = view.findViewById<Button>(R.id.btnAddProject)
        btnAddProject.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ProjectFormFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }

    companion object {
        fun newInstance() = RepoListFragment()
    }
}