package com.example.pizzeria.Kotlin

import com.example.pizzeria.ConexionBD.DBHelper
import com.example.pizzeria.Recursos.Kebab

class DAOKebab {
    private var dbHelper: DBHelper? = null
    fun setDbHelper(dbHelper: DBHelper?) {
        this.dbHelper = dbHelper
    }

    val lista: ArrayList<Kebab>?
        get() = Companion.lista

    fun getKebab(kebab: Kebab): Kebab? {
        return if (instance!!.lista!!.contains(kebab)) {
            kebab
        } else null
    }

    fun agregarKebab(kebab: Kebab, usuario: String?): Boolean {
        Companion.lista!!.add(kebab)
        dbHelper!!.insertarKebab(kebab, usuario)
        val idKebab = dbHelper!!.idKebab()
        for (ingrediente in kebab.ingredientes) {
            dbHelper!!.insertarIgrediente(ingrediente.ordinal, idKebab)
        }
        return true
    }

    fun eliminarultimoKebab(): Boolean {
        Companion.lista!!.removeAt(Companion.lista!!.size - 1)
        return true
    }

    val sizeLista: Int
        get() = Companion.lista!!.size

    fun eleminarFavorito(usuario: String?): Boolean {
        dbHelper!!.limpiarFavorito(usuario)
        for (ind in Companion.lista!!.indices) {
            Companion.lista!![ind].favorito = false
        }
        return true
    }

    companion object {
        private var lista: ArrayList<Kebab>? = null
        private var dao: DAOKebab? = null
        val instance: DAOKebab?
            get() {
                if (dao == null) dao = DAOKebab()
                if (lista == null) lista = ArrayList()
                return dao
            }
    }
}