package com.example.weather.lib.binding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

abstract class BindingFragment<VB : ViewBinding> : Fragment() {

	private var _binding: VB? = null
	val binding
		get() = _binding ?: throw NullPointerException("Binding can't be null")

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = binding(inflater, container, savedInstanceState)
		otherSetups()
		return _binding?.root
	}

	protected open fun otherSetups() {}

	protected abstract fun binding(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): VB

	override fun onPause() {
		super.onPause()
	}

	override fun onDestroyView() {
		_binding = null
		super.onDestroyView()
	}
}


fun <T> Flow<T>.launchWhenResumed(scope: LifecycleCoroutineScope): Job =
	scope.launchWhenResumed {
		collect()
	}