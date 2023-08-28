package com.nicolaspanteleev.tpintegrador

data class Comparador(val textOne: String,val textTwo: String){

    fun compare(): Boolean{
        return textOne.equals(textTwo)
    }
}