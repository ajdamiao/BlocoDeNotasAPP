package com.example.blocodenotas

import android.content.Context
import android.content.SharedPreferences

class PreferenciaAnotacao(private val context: Context) {

    private val ARQUIVO = "anotacao.preferencia"
    private val CHAVE = "nome"
    private val preferences: SharedPreferences
    private val editor: SharedPreferences.Editor


    fun salvarAnotacao(anotacao: String?)
    {
        editor.putString(CHAVE,anotacao)
        editor.commit()
    }

    fun recuperarAnotacao(): String?
    {
        return preferences.getString(CHAVE,"")
    }

    init {
        preferences = context.getSharedPreferences(ARQUIVO,0)
        editor = preferences.edit()
    }

}