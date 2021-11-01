package com.attachments.firstdemoapi.model

import com.attachments.firstdemoapi.model.personStrategy.Doctor
import com.attachments.firstdemoapi.model.personStrategy.Engineer
import com.attachments.firstdemoapi.model.personStrategy.PoliceOfficer

class JobsTypeStrategy {

    val strategies = mapOf(
        ProfessionTypeEnum.DOCTOR to Doctor(),
        ProfessionTypeEnum.ENGINEER to Engineer(),
        ProfessionTypeEnum.POLICE_OFFICER to PoliceOfficer()
    )

    fun work(profession: ProfessionTypeEnum): Person{
        return strategies[profession]!!.work()
    }

   /* fun switchProfession(newProfession: ProfessionTypeEnum): Person{
        return strategies[newProfession]!!.switchProfession()
    }*/
}

abstract class JobsType {

    abstract fun switchProfession(): Person
    abstract fun work(): Person
}