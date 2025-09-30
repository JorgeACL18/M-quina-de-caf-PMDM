package maquinaDeCafe

sealed class CoffeeMachineBroken {
    object Broken : CoffeeMachineBroken()
    object Processing : CoffeeMachineBroken()
    data class Process(val state: String) : CoffeeMachineBroken()
}