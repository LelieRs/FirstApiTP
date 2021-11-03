package com.attachments.firstdemoapi.model.personStrategy

import com.attachments.firstdemoapi.model.JobsType
import com.attachments.firstdemoapi.model.Person
import com.attachments.firstdemoapi.model.ProfessionTypeEnum

class Doctor : JobsType {

    override fun work(person: Person) {
        person.money += 1000
    }

    override fun switchProfession(person: Person, newProfession: ProfessionTypeEnum) {
        person.professionType = newProfession
    }

}