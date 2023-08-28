import java.lang.Error

const val Type_Card = "" // Варианты карт: MC = Master Card, Mir, Visa, Maestro
const val Error_Wrong_Type = -1.0
const val Error_Limit_Exceeded = -2.0
const val transfer = 10_000
const val previos = 0
fun main() {
    println(comissionAll(transfer))

}

fun comissionAll(transfer: Int, previous: Int = 0, typeCard: String = "VK"): Double {
    when {
        Type_Card === "MC" -> return comissionMC(Type_Card, transfer, previos)
        Type_Card === "Maestro" -> return comissionMC(Type_Card, transfer, previos)
        Type_Card === "Mir" -> return comissionVisa(Type_Card, transfer, previos)
        Type_Card === "Visa" -> return comissionVisa(Type_Card, transfer, previos)
        else -> return comissionVK(Type_Card, transfer, previos)
    }

}

fun comissionOnMC(transfer: Int, previos: Int): Double {
    var difference = (previos + transfer) - 75_000
    return when {
        previos > 75_000 -> (transfer * 0.006) + 20
        transfer + previos > 75_000 -> (difference * 0.006) + 20
        else -> 0.0
    }
}

fun comissionMC(typeCard: String, transfer: Int, previos: Int): Double {
    return when (typeCard) {
        Type_Card -> if (transfer > 150_000 || transfer + previos > 600_000) {
            Error_Limit_Exceeded
        } else {
            comissionOnMC(transfer, previos)
        }

        else -> Error_Wrong_Type
    }
}

fun comissionVisa(typeCard: String, transfer: Int, previos: Int): Double {
    var comission = transfer / 100 * 0.75
    return when (typeCard) {
        Type_Card -> if (transfer > 150_000 || transfer + previos > 600_000) {
            Error_Limit_Exceeded
        } else {
            if (comission < 35) 35.0 else comission
        }

        else -> Error_Wrong_Type
    }
}

fun comissionVK(typeCard: String, transfer: Int, previos: Int): Double {
    return when (typeCard) {
        Type_Card -> if (transfer > 15_000 || transfer + previos > 40_000) {
            Error_Limit_Exceeded
        } else {
            0.0
        }

        else -> Error_Wrong_Type
    }
}