package com.rogoz208.nasapicture.ui.screens.notes

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.*
import androidx.recyclerview.widget.*
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rogoz208.nasapicture.R
import com.rogoz208.nasapicture.data.app
import com.rogoz208.nasapicture.databinding.FragmentNotesBinding
import com.rogoz208.nasapicture.domain.entities.NoteEntity
import com.rogoz208.nasapicture.ui.screens.notes.recycler.*

class NotesFragment : Fragment(R.layout.fragment_notes) {

    private val binding by viewBinding(FragmentNotesBinding::bind)

    private val viewModel: NotesViewModel by viewModels {
        NotesViewModelFactory(requireContext().app.notesRepo)
    }

    private val adapter by lazy { NotesAdapter(onNoteClickListener = { note -> viewModel.onNoteClick(note) }) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        val noteDragCallback = NoteDragTouchHelperCallback(
            onItemMove = { from, to ->
            viewModel.onNoteMoved(from, to)
        },
            onItemSwiped = { position ->
            viewModel.onNoteSwiped(position)
        })
        val touchHelper = ItemTouchHelper(noteDragCallback)
        touchHelper.attachToRecyclerView(binding.recyclerView)
    }

    private fun initViewModel() {
        viewModel.notesListLiveData.observe(viewLifecycleOwner) { notes ->
            fillRecyclerView(notes)
        }
        viewModel.toastMessageLiveData.observe(viewLifecycleOwner) { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
        viewModel.updateNotes()
    }

    private fun fillRecyclerView(notes: List<NoteEntity>) {
        val notesDiffCallback = NotesDiffCallback(oldList = adapter.data, newList = notes)
        val result = DiffUtil.calculateDiff(notesDiffCallback)
        adapter.data = notes
        result.dispatchUpdatesTo(adapter)
    }
}