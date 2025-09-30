package maquinaDeCafe

import maquinaDeCafe.CoffeeMachine.brokenState
import maquinaDeCafe.CoffeeMachine.currentState

object CoffeeMachine {
    var currentState: CoffeeMachineState = CoffeeMachineState.Idle
    var brokenState: CoffeeMachineBroken = CoffeeMachineBroken.Broken

    fun makeCoffee() {
        println("Estado actual: $currentState")

        when (currentState) {
            is CoffeeMachineState.Idle -> {
                println("Máquina encendida. Empezando a hacer café...")
                currentState = CoffeeMachineState.MakingCoffee
                Thread.sleep(2000)
                // Simula un proceso de preparación
                currentState = CoffeeMachineState.ServingCoffee("Nescafé")
                println("¡Café listo! Estado: $currentState")

            }

            is CoffeeMachineState.MakingCoffee -> {
                println("¡Espera! La máquina ya está haciendo café.")
            }

            is CoffeeMachineState.ServingCoffee -> {
                println("Ya hay café servido. Por favor, toma tu café.")
            }

            is CoffeeMachineState.Error -> {
                println("La máquina tiene un error: ${(currentState as CoffeeMachineState.Error).message}")
            }
        }
    }

    fun clean() {
        println("Limpiando la máquina...")
        currentState = CoffeeMachineState.Idle
        println("Máquina limpia. Estado: $currentState")
    }

    fun brokenCoffee() {
        when (brokenState) {
            is CoffeeMachineBroken.Broken -> {
                brokenState = CoffeeMachineBroken.Processing
                println("¡La máquina se ha roto!")
                brokenState = CoffeeMachineBroken.Process("Resolviendo problema...")
                println("$brokenState")
                Thread.sleep(2000)
                println("Problema solucionado")
                brokenState = CoffeeMachineBroken.Process("Llamando la consola")
                println("$brokenState")
                brokenState = CoffeeMachineBroken.Processing
                println("Reiniciando máquina")
            }
            is CoffeeMachineBroken.Processing ->{
                println("Terminando reinicio")
            }
            is CoffeeMachineBroken.Process ->{
                println("El problema se está solucionando")
            }

        }
    }
    fun resultado() {
        brokenState = CoffeeMachineBroken.Processing
        println("Máquina lista")
        println("¡Bienvenido de nuevo!")
    }
}
