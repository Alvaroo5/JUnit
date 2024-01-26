package com;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.Calculadora;

class CalculadoraTest {

	@Test
	@DisplayName("Probar resta de dos numeros")
	public void testResta() {
		double valorEsperado = 30;
		Calculadora calcu = new Calculadora(20, 10);
		int resultado = calcu.suma();
		assertEquals(valorEsperado, resultado, "La suma no es igual");
	}
	
	@Test
	@DisplayName("Probar suma de dos numeros")
	public void testSuma() {
		double valorEsperado = 30;
		Calculadora calcu = new Calculadora(20, 10);
		int resultado = calcu.suma();
		assertEquals(valorEsperado, resultado, "La suma no es igual");
	}
	
	@Test
	public void testDivide0() {
		String mensajeEsperado = "División por 0";
		Calculadora calcu = new Calculadora(20, 0);
		Exception exception = assertThrows(ArithmeticException.class, ()->calcu.divide0());
		assertEquals(mensajeEsperado, exception.getMessage());
	}
	
	@ParameterizedTest
	@CsvSource({"10, 2, 5",
		"30, -2, -15",
		"8, 4, 2"
	})
	void divide_parametros(int a, int b, int valor_esperado) {
		Calculadora calc = new Calculadora(a, b);
		assertEquals(valor_esperado, calc.divide(), "No es divisible");
	}
	
	@ParameterizedTest
	@CsvSource({"10, 2",
		"12, 3",
		"12, 1"
	})
	void suma_parametros(int a, int b, int valor_esperado) {
		Calculadora calc = new Calculadora(a, b);
		assertEquals(valor_esperado, calc.suma());
	}
	
}
