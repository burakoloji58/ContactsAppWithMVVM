package com.example.kisileruygulamasimvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.kisileruygulamasimvvm.R
import com.example.kisileruygulamasimvvm.databinding.FragmentKisiDetayBinding
import com.example.kisileruygulamasimvvm.ui.viewmodel.AnasayfaViewModel
import com.example.kisileruygulamasimvvm.ui.viewmodel.KisiDetayViewModel
import com.example.kisileruygulamasimvvm.ui.viewmodel.KisiKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiDetayFragment : Fragment() {
    private lateinit var ulas : FragmentKisiDetayBinding
    private lateinit var viewModel: KisiDetayViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        ulas = FragmentKisiDetayBinding.inflate(inflater, container, false)
        ulas.kisiDetayFragment = this
        ulas.kisiDetayToolBarBaslik = "Kişi Detay"

        val bundle : KisiDetayFragmentArgs by navArgs()
        val gelenKisi = bundle.kisi

        ulas.kisiNesnesi = gelenKisi


        return ulas.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val tempViewModel : KisiDetayViewModel by viewModels()
        viewModel = tempViewModel
        super.onCreate(savedInstanceState)
    }


    fun buttonGuncelle(kisiId:Int,kisiAd:String,kisiTel:String){
        viewModel.Guncelle(kisiId,kisiAd,kisiTel)
    }

}