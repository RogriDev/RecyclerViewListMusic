package com.rogrigamer.recyclerview

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    //Passo1: Criar Classe MainViewModel estendendo do Android ViewModel
    private val viewModel: MainViewModel by viewModels()
    private val adapter = MusicAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupObservables()
        setupRecyclerView()

    }

    override fun onStart() {
        super.onStart()
        viewModel.getItems()
    }

    private fun setupRecyclerView() {
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL,
            false
        )
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    private fun setupObservables() {
        //Passo4: Observar lista de items e atualizar o adapter
        viewModel.items.observe(this) { musicList ->
            adapter.updateList(musicList)
        }
    }
}
