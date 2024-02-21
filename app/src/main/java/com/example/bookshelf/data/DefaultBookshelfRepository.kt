package com.example.bookshelf.data

import com.example.bookshelf.model.Book
import com.example.bookshelf.network.BookshelfApiService

class DefaultBookshelfRepository(private val bookshelfApiService: BookshelfApiService) : BookshelfRepository {
    override suspend fun getBooks(query: String): List<Book>? {
        return try {
            val response = bookshelfApiService.getBooks(query)
            if (response.isSuccessful) {
                response.body()?.items ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }


    override suspend fun getBook(id: String): Book? {
        return try {
            val response = bookshelfApiService.getBook(id)
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}