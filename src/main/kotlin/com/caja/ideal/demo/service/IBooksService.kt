package com.caja.ideal.demo.service

import com.caja.ideal.demo.models.BooksModels
import org.springframework.stereotype.Service

@Service
interface IBooksService {
    fun all():List<BooksModels>
    fun book(id:Long):BooksModels
    fun save(book:BooksModels)
    fun update(book:BooksModels, id:Long):BooksModels
    fun delete(id:Long)
}
