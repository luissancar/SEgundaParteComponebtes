package com.example.segundapartecomponebtes

data class CheckInfo(
    val titulo: String,
    var selected: Boolean = false,
    var onCheckedChange: (Boolean) -> Unit
)