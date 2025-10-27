package ec.edu.uisek.githubclient.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import ec.edu.uisek.githubclient.R

class ProjectFormFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_project_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val etName = view.findViewById<EditText>(R.id.etProjectName)
        val etDesc = view.findViewById<EditText>(R.id.etProjectDesc)
        val btnSubmit = view.findViewById<Button>(R.id.btnSubmitProject)

        btnSubmit.setOnClickListener {
            val name = etName.text.toString()
            val desc = etDesc.text.toString()
            Toast.makeText(requireContext(), "Proyecto: $name\n$desc", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        fun newInstance() = ProjectFormFragment()
    }
}
