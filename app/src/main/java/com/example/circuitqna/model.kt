package com.example.circuitqna

data class model(
        val question: String,
        val answer: List<answer_list>
)

data class answer_list(
        val keywords: String
)