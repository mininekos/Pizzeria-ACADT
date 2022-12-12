package com.example.pizzeria.Kotlin

import com.example.pizzeria.ConexionBD.DBHelper
import com.example.pizzeria.Recursos.Usuario


class DAOUsuario {
    private var dbHelper: DBHelper? = null
    fun setDbHelper(dbHelper: DBHelper?) {
        this.dbHelper = dbHelper
    }

    val lista: ArrayList<Usuario>?
        get() {
            if (Companion.lista!!.size == 0) {
                Companion.lista!!.add(Usuario("admin", "admin", "correo1"))
                Companion.lista!!.add(Usuario("Manu", "1234", "correo2"))
            }
            return Companion.lista
        }

    fun getUsuario(usuario: Usuario): Usuario? {
        return if (instance!!.lista!!.contains(usuario)) {
            usuario
        } else null
    }

    fun agregarUsuario(usuario: Usuario): Boolean {
        dbHelper!!.insertarUsuario(usuario)
        if (instance!!.getUsuario(usuario) == null) {
            Companion.lista!!.add(usuario)
            return true
        }
        return false
    }

    companion object {
        private var lista: ArrayList<Usuario>? = null
        private var dao: DAOUsuario? = null
        val instance: DAOUsuario?
            get() {
                if (dao == null) dao = DAOUsuario()
                if (lista == null) lista = ArrayList()
                return dao
            }
    }
}
