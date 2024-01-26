package com;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CuentaBancariaTest {
                                          
	@Test
    @DisplayName("Saldo inicial negativo")
    public void testConstructorSaldoInicialNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new CuentaBancaria(-100));
    }

    @Test
    @DisplayName("Saldo inicial positivo")
    public void testConstructorSaldoInicialPositivo() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        assertEquals(100, cuenta.getSaldo(), 0.001);
    }

    @Test
    @DisplayName("Depositar cantidad válida")
    public void testDepositarCantidadValida() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        double nuevoSaldo = cuenta.depositar(50);
        assertEquals(150, nuevoSaldo, 0.001);
    }

    @Test
    @DisplayName("Depositar cantidad negativa")
    public void testDepositarCantidadNegativa() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        assertThrows(IllegalArgumentException.class, () -> cuenta.depositar(-50));
    }

    @Test
    @DisplayName("Depositar cantidad cero")
    public void testDepositarCantidadCero() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        assertThrows(IllegalArgumentException.class, () -> cuenta.depositar(0));
    }

    @Test
    @DisplayName("Retirar cantidad válida")
    public void testRetirarCantidadValida() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        double nuevoSaldo = cuenta.retirar(50);
        assertEquals(50, nuevoSaldo, 0.001);
    }

    @Test
    @DisplayName("Retirar cantidad negativa")
    public void testRetirarCantidadNegativa() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        assertThrows(IllegalArgumentException.class, () -> cuenta.retirar(-50));
    }

    @Test
    @DisplayName("Retirar cantidad cero")
    public void testRetirarCantidadCero() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        assertThrows(IllegalArgumentException.class, () -> cuenta.retirar(0));
    }

    @Test
    @DisplayName("Retirar fondos insuficientes")
    public void testRetirarFondosInsuficientes() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        assertThrows(IllegalArgumentException.class, () -> cuenta.retirar(150));
    }

    @Test
    @DisplayName("GetSaldo")
    public void testGetSaldoDespuesDeOperaciones() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        cuenta.depositar(50);
        cuenta.retirar(30);
        assertEquals(120, cuenta.getSaldo(), 0.001);
    }
}