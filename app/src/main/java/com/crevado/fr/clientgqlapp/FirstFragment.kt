package com.crevado.fr.clientgqlapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.apollographql.apollo3.exception.ApolloException
import com.crevado.fr.clientgqlapp.databinding.FragmentFirstBinding
import com.crevado.fr.clientgqlapp.util.AplClient

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textviewFirst.text = "Hello first fragment again!"

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        lifecycleScope.launchWhenResumed {
            binding.textviewFirst.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
            binding.error.visibility = View.GONE

            val response = try {
                AplClient().getmApolloClient()?.query(UsersQuery())
                    ?.execute()
            } catch (e: ApolloException) {
                binding.progressBar.visibility = View.GONE
                binding.error.text = "Oh no... A protocol error happened"
                binding.error.visibility = View.VISIBLE
                return@launchWhenResumed
            }

            val launch = response?.data?.users
            if (launch == null || response.hasErrors()) {
                binding.progressBar.visibility = View.GONE
                binding.error.text = response?.errors?.get(0)?.message
                binding.error.visibility = View.VISIBLE
                return@launchWhenResumed
            }

            binding.textviewFirst.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
            binding.error.visibility = View.GONE

            val rocket = launch[0]
            binding.textviewFirst.text = "🚀 ${rocket?.name} ${rocket?.age}"
            Log.d("test: ", rocket?.name.toString())

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}