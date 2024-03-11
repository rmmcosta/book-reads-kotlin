package com.rmmcosta.bookreadskotlin.book

import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : CassandraRepository<Book, String>