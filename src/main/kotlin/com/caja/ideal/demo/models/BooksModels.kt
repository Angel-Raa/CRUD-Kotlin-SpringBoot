package com.caja.ideal.demo.models

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.io.Serializable

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
data class BooksModels(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id:Long,
                       var title:String,  var description: String,
                       var author: String, var genders: String   ) : Serializable