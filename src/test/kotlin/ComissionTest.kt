import org.junit.Test
import kotlin.test.assertEquals

class ComissionTest {
    @Test
    fun masterCardComission() {
        val typeCard = Type_Card
        val transfer = 100_000
        val previos = 0

        val result = comissionMC(typeCard, transfer, previos)
        assertEquals(170.0, result, 0.01)
    }

    @Test
    fun masterCardComissionPrevios() {
        val typeCard = Type_Card
        val transfer = 100_000
        val previos = 100_000

        val result = comissionMC(typeCard, transfer, previos)
        assertEquals(620.0, result, 0.01)
    }

    @Test
    fun masterCardComissionMaxTrasfer() {
        val typeCard = Type_Card
        val transfer = 200_000
        val previos = 0

        val result = comissionMC(typeCard, transfer, previos)
        assertEquals(Error_Limit_Exceeded, result, 0.01)
    }

    @Test
    fun masterCardComissionMaxPrevios() {
        val typeCard = Type_Card
        val transfer = 100_000
        val previos = 555_000

        val result = comissionMC(typeCard, transfer, previos)
        assertEquals(Error_Limit_Exceeded, result, 0.01)
    }

    @Test
    fun wrongTypeMC() {
        val typeCard = "UnionPay"
        val transfer = 10_000
        val previos = 0

        val result = comissionMC(typeCard, transfer, previos)
        assertEquals(Error_Wrong_Type, result, 0.01)
    }

    @Test
    fun masterCardZeroComission() {
        val typeCard = Type_Card
        val transfer = 10_000
        val previos = 0

        val result = comissionMC(typeCard, transfer, previos)
        assertEquals(0.0, result, 0.01)
    }

    @Test
    fun masterCardComboComission() {
        val typeCard = Type_Card
        val transfer = 20_000
        val previos = 60_000

        val result = comissionMC(typeCard, transfer, previos)
        assertEquals(50.0, result, 0.01)
    }

    @Test
    fun comissionAllVKLimit() {
        val typeCard = Type_Card
        val transfer = 100_000
        val previos = 0

        val result = comissionAll(transfer, previos, typeCard)
        assertEquals(Error_Limit_Exceeded, result, 0.01)
    }

    @Test
    fun comissionAllZeroVK() {
        val typeCard = Type_Card
        val transfer = 10_000
        val previos = 0

        val result = comissionVK(typeCard, transfer, previos)
        assertEquals(0.0, result, 0.01)
    }

    @Test
    fun comissionAllWrongTypeVK() {
        val typeCard = "Kial"
        val transfer = 10_000
        val previos = 0

        val result = comissionVK(typeCard, transfer, previos)
        assertEquals(Error_Wrong_Type, result, 0.01)
    }

    @Test
    fun comissionAllComboVKLimit() {
        val typeCard = Type_Card
        val transfer = 10_000
        val previos = 33_000

        val result = comissionVK(typeCard, transfer, previos)
        assertEquals(Error_Limit_Exceeded, result, 0.01)
    }

    @Test
    fun visaComission() {
        val typeCard = Type_Card
        val transfer = 100_000
        val previos = 0

        val result = comissionVisa(typeCard, transfer, previos)
        assertEquals(750.0, result, 0.01)
    }

    @Test
    fun visaLowComission() {
        val typeCard = Type_Card
        val transfer = 1_000
        val previos = 0

        val result = comissionVisa(typeCard, transfer, previos)
        assertEquals(35.0, result, 0.01)
    }

    @Test
    fun visaUnderTransfer() {
        val typeCard = Type_Card
        val transfer = 166_000
        val previos = 0

        val result = comissionVisa(typeCard, transfer, previos)
        assertEquals(Error_Limit_Exceeded, result, 0.01)
    }

    @Test
    fun visaComboUnderTransfer() {
        val typeCard = Type_Card
        val transfer = 106_000
        val previos = 555_000

        val result = comissionVisa(typeCard, transfer, previos)
        assertEquals(Error_Limit_Exceeded, result, 0.01)
    }

    @Test
    fun visaWrongType() {
        val typeCard = "Type_Card"
        val transfer = 1_000
        val previos = 0

        val result = comissionVisa(typeCard, transfer, previos)
        assertEquals(Error_Wrong_Type, result, 0.01)
    }

}