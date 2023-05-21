package ru.viknist.aston_dz_5.model

data class Contact(
    var phone: String,
    var name: String,
    var lastName: String,
    var age: Int
) : java.io.Serializable
