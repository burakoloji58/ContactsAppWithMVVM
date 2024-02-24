package com.example.kisileruygulamasimvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.kisileruygulamasimvvm.R
import com.example.kisileruygulamasimvvm.databinding.FragmentKisiKayitBinding
import com.example.kisileruygulamasimvvm.ui.viewmodel.AnasayfaViewModel
import com.example.kisileruygulamasimvvm.ui.viewmodel.KisiKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiKayitFragment : Fragment() {
    private lateinit var ulas : FragmentKisiKayitBinding
    private lateinit var viewModel: KisiKayitViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        ulas = DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_kayit, container, false)
        ulas.kisiKayitFragment=this
        ulas.kisiKayitToolBarBaslik = "Kişi Kayıt"


        return ulas.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val tempViewModel : KisiKayitViewModel by viewModels()
        viewModel = tempViewModel
        super.onCreate(savedInstanceState)
    }

    fun buttonKaydet(kisiAd:String,kisiTel:String){
        viewModel.kayit(kisiAd,kisiTel)
    }

}