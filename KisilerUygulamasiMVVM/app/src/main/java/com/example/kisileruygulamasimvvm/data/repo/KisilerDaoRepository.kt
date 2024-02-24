package com.example.kisileruygulamasimvvm.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kisileruygulamasimvvm.data.entity.Kisiler
import com.example.kisileruygulamasimvvm.room.KisilerDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KisilerDaoRepository(var kdao : KisilerDao) {

    var kisilerlistesi : MutableLiveData<List<Kisiler>>

    init {
        kisilerlistesi = MutableLiveData()
    }

    fun kisilerGetir() : MutableLiveData<List<Kisiler>>{
        return kisilerlistesi
    }

    fun KisiKaydet(kisiAd:String,kisiTel:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val yeniKisi = Kisiler(0,kisiAd,kisiTel)
            kdao.kisiEkle(yeniKisi)
        }
    }

    fun KisiGuncelle(kisiId:Int,kisiAd:String,kisiTel:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val yeniKisi = Kisiler(kisiId,kisiAd,kisiTel)
            kdao.kisiGuncelle(yeniKisi)
        }
    }

    fun KisiAra(aramaKelimesi:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            kisilerlistesi.value = kdao.kisiArama(aramaKelimesi)
        }
    }

    fun KisiSil(kisiId: Int){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinenKisi = Kisiler(kisiId,"","")
            kdao.kisiSil(silinenKisi)
            TumKisileriAl()
        }
    }

    fun TumKisileriAl(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            kisilerlistesi.value = kdao.tumKisiler()
        }
    }


}