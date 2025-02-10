package com.example.tabs_demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class WeatherFragment : Fragment() {

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): WeatherFragment {
            return WeatherFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_weather, container, false)
        val sectionNumber = arguments?.getInt(ARG_SECTION_NUMBER) ?: 0

        val cityNameTextView: TextView = rootView.findViewById(R.id.cityNameTextView)
        val weatherInfoTextView: TextView = rootView.findViewById(R.id.weatherInfoTextView)

        val cities = resources.getStringArray(R.array.cities)
        val weatherData = resources.getStringArray(R.array.weather_data)

        cityNameTextView.text = cities[sectionNumber]
        weatherInfoTextView.text = weatherData[sectionNumber]

        return rootView
    }
}
