package com.attachments.firstdemoapi.model

import com.attachments.firstdemoapi.model.personStrategy.Doctor
import com.attachments.firstdemoapi.model.personStrategy.Engineer
import com.attachments.firstdemoapi.model.personStrategy.PoliceOfficer
import org.springframework.stereotype.Component

@Component
class JobsTypeStrategy {

    var strategies = mapOf(
        ProfessionTypeEnum.DOCTOR to Doctor(),
        ProfessionTypeEnum.ENGINEER to Engineer(),
        ProfessionTypeEnum.POLICE_OFFICER to PoliceOfficer()
    )
}

@Component
interface JobsType {
    fun work(person: Person)
    fun switchProfession(person: Person, newProfession: ProfessionTypeEnum)
}
