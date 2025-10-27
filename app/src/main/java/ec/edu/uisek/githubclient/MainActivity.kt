package ec.edu.uisek.githubclient

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ec.edu.uisek.githubclient.fragments.RepoListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Mostrar la lista de repositorios al inicio
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, RepoListFragment.newInstance())
                .commit()
        }
    }
}
