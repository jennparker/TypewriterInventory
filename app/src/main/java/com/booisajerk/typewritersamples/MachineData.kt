package com.booisajerk.typewritersamples

object MachineData {

    var machineNameArray = arrayOf("Kolibri Groma","Olivetti Lettera 22", "Royal Aristocrat"
            , "Royal Aristocrat 2", "Royal KMG", "Royal Quiet de Luxe", "Underwood Universal")

    fun machineList(): ArrayList<Machine> {
        val list = ArrayList<Machine>()
        for (i in machineNameArray.indices) {
            var isFav = false
            if (i == 2 || i == 5) {
                isFav = true
            }
            val machine = Machine(machineNameArray[i], machineNameArray[i].replace("\\s+".toRegex(), "").toLowerCase(), isFav)
            list.add(machine)
        }
        return list
    }
}