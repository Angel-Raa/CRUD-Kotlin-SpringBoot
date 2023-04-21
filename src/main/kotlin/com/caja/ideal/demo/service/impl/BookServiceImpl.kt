package com.caja.ideal.demo.service.impl

import com.caja.ideal.demo.exceptions.ResourceNotFound
import com.caja.ideal.demo.models.BooksModels
import com.caja.ideal.demo.repository.IBooksRepository
import com.caja.ideal.demo.service.IBooksService
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * This class handles all CRUD (create, Read, Update, Delete Operations) service
 */
@Service
class BookServiceImpl (@Autowired var repository:IBooksRepository ): IBooksService  {


    @Transactional(readOnly = true)
    @ResponseStatus(HttpStatus.OK)
    override fun all(): List<BooksModels> {
        return repository.findAll()
    }

    @Transactional(readOnly = true)
    @ResponseStatus(HttpStatus.OK)
    override fun book(id: Long): BooksModels {
        return repository.findById(id).orElseThrow{ResourceNotFound("user not found ")}
    }

    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    override fun save(book: BooksModels) {
        repository.save(book)
    }

    @Transactional
    @ResponseStatus(HttpStatus.OK)
    override fun update(book: BooksModels, id: Long): BooksModels {
        var bookToUpdate = repository.findById(id).orElseThrow { ResourceNotFound("user not found ") }
        BeanUtils.copyProperties(book, bookToUpdate, "id")
        return repository.save(bookToUpdate)
    }
    @Transactional
    override fun delete(id: Long) {
        var book = repository.findById(id)
        if (book.isPresent){
            repository.deleteById(id)
        }
        throw ResourceNotFound("user not found ")
    }
}