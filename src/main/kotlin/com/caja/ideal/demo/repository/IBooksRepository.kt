package com.caja.ideal.demo.repository

import com.caja.ideal.demo.models.BooksModels
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IBooksRepository : JpaRepository<BooksModels, Long>