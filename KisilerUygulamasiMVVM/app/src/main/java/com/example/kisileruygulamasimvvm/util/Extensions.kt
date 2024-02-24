package com.example.kisileruygulamasimvvm.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation


fun Navigation.gecisYap(it:View,Id:Int){
    findNavController(it).navigate(Id)
}

fun Navigation.gecisYap(it:View,Id:NavDirections){
    findNavController(it).navigate(Id)
}