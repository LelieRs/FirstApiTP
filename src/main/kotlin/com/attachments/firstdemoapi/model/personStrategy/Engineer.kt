package com.attachments.firstdemoapi.model.personStrategy

import com.attachments.firstdemoapi.model.JobsType
import com.attachments.firstdemoapi.model.Person
import javax.persistence.Entity

@Entity
class Engineer : JobsType() {

    override fun work(): Person {

    }

    override fun switchProfession(): Person {

    }


}
