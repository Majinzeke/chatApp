package com.mz.chatapp.data.remote

import com.mz.chatapp.data.remote.dto.MessageDto
import com.mz.chatapp.domain.model.Message
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import java.lang.Exception

class MessageServiceImpl(
    private val client: HttpClient
) : MessageService {


    override suspend fun getAllMessages(): List<Message> {
        return try {
            client.get<List<MessageDto>>(MessageService.Endpoints.GetAllMessages.url)
                .map { it.toMessage() }
        } catch (e: Exception){
            emptyList()
        }
    }
}