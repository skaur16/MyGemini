package com.example.mygemini

data class ReceiveData(
    val candidates: List<Candidate>,
    val promptFeedback: PromptFeedback
)