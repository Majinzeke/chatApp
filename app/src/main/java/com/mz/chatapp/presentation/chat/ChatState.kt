package com.mz.chatapp.presentation.chat

import com.mz.chatapp.domain.model.Message

data class ChatState(
    val messages: List<Message> = emptyList(),
    val isLoading: Boolean = false
)
