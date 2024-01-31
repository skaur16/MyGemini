package com.example.mygemini.model

data class ReceiveData(
    val candidates: List<Candidate>,
    val promptFeedback: PromptFeedback
)