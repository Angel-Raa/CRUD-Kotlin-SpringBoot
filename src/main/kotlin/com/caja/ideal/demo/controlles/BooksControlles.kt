package com.caja.ideal.demo.controlles

import com.caja.ideal.demo.apis.Responde
import com.caja.ideal.demo.models.BooksModels
import com.caja.ideal.demo.service.IBooksService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BooksControlles(@Autowired var service:IBooksService) {


    @GetMapping("/all")
    fun all():ResponseEntity<List<BooksModels>>{
        return ResponseEntity(service.all(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun book(@PathVariable id:Long):ResponseEntity<BooksModels>{
        return ResponseEntity.ok(service.book(id))
    }

    @PostMapping("/all")
    fun postBook(@RequestBody books:BooksModels):ResponseEntity<Responde>{
        service.save(books)
        val responde  = Responde("message", "successfully saved")
        return ResponseEntity(responde, HttpStatus.CREATED)
    }

    @PutMapping("/update/{id}")
    fun update(@RequestBody books:BooksModels, @PathVariable id:Long):ResponseEntity<BooksModels>{
        return ResponseEntity.ok(service.update(books, id))
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id:Long):ResponseEntity<Responde>{
        service.delete(id)
        val responde  = Responde("message", "successfully removed ")
        return ResponseEntity.ok(responde)
    }
}