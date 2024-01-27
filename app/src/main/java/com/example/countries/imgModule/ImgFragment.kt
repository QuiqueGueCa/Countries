package com.example.countries.imgModule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.countries.databinding.FragmentImgBinding
import com.example.countries.imgModule.viewModel.ImgViewModel
import com.example.countries.mainModule.MainActivity

class ImgFragment : Fragment() {

    private lateinit var binding: FragmentImgBinding
    private lateinit var mViewModel: ImgViewModel
    private var mActivity: MainActivity? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentImgBinding.inflate(inflater, container, false)
        mViewModel = ViewModelProvider(requireActivity())[ImgViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupViewModel()

        setupActionBar()
    }

    private fun setupActionBar() {
        mActivity = activity as? MainActivity
        mActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupViewModel() {
        mViewModel.getImg().observe(viewLifecycleOwner) {
            binding.imgCountry.setImageResource(it)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                requireActivity().onBackPressedDispatcher.onBackPressed()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}