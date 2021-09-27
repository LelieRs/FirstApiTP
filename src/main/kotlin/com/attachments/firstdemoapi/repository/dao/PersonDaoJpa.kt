package com.attachments.firstdemoapi.repository.dao

import com.attachments.firstdemoapi.model.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonDaoJpa: JpaRepository <Person, Int> {

}