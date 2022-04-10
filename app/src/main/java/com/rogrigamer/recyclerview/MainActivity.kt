package com.rogrigamer.recyclerview

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rogrigamer.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Passo1: Criar Classe MainViewModel estendendo do Android ViewModel
    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    //para utilizar o adapter na nossa classe main inteira colocamos em uma variável
    private val adapter = MusicAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservables()
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        viewModel.getItems()
    }

    //inicializar o adapter
    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL,
            false
        )
        with(binding) {
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = adapter
        }
    }

    private fun setupObservables() {
        //Passo4: Observar lista de items e atualizar o adapter
        viewModel.items.observe(this) { musicList ->
            adapter.updateList(musicList)
        }
    }
}
