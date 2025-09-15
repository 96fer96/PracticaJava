import promptSync from "prompt-sync";

const prompt = promptSync();
let opcion = 0;

do {
    console.log("Menu calculadora: Ingresar la opcion deseada");
    console.log("1. Sumar");
    console.log("2. Restar");
    console.log("3. Multiplicar");
    console.log("4. Dividir");
    console.log("5. Salir");

    opcion = Number(prompt("Ingrese la opcion: "));

    if (opcion >= 1 && opcion <= 4) {
        const num1 = Number(prompt("Ingrese el primer número: "));
        const num2 = Number(prompt("Ingrese el segundo número: "));
        let resultado;

        switch (opcion) {
            case 1:
                resultado = num1 + num2;
                console.log(`La suma es: ${resultado}`);
                break;
            case 2:
                resultado = num1 - num2;
                console.log(`La resta es: ${resultado}`);
                break;
            case 3:
                resultado = num1 * num2;
                console.log(`La multiplicación es: ${resultado}`);
                break;
            case 4:
                if (num2 !== 0) {
                    resultado = num1 / num2;
                    console.log(`La división es: ${resultado}`);
                } else {
                    console.log("Error: No se puede dividir por cero.");
                }
                break;
        }
    } else if (opcion === 5) {
        console.log("Saliendo de la calculadora. ¡Hasta luego!");
    } else {
        console.log("Opción no válida. Por favor, intente de nuevo.");
    }
} while (opcion!==5);

