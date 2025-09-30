package maquinaDeCafe

fun main() {
    println("\n--- Encendiendo la máquina ---")
    CoffeeMachine.makeCoffee()

    println("\n--- Intentando hacer café de nuevo ---")
    CoffeeMachine.makeCoffee()

    println("\n--- Limpiando la máquina ---")
    CoffeeMachine.clean()

    println("\n--- Y ahora, otro café ---")
    CoffeeMachine.makeCoffee()

    println("\n--- ERROR ---")
    CoffeeMachine.brokenCoffee()

    println("\n--- Procesando ---")
    CoffeeMachine.brokenCoffee()

    println("\n--- Resultado ---")
    CoffeeMachine.resultado()
}
