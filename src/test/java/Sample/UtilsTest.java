/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Sample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 * @author RafaelRocha, ViníciusAmaral, TallesCardoso
 * Classe de testes contendo os métodos testes feitos.
 */

public class UtilsTest {
    
    public UtilsTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }


    @Test
    @DisplayName("Teste para sequência normal de nucleotídeos")
    public void testeCasoNormal(){
        Utils utils = new Utils();
        int[] resultado = null;
        try{
            resultado = utils.calculaNucleotideos("AATCABGCTTCGCAGC");
        } catch (Exception e){
            fail("Exceção inesperada: " + e.getMessage());
        }
        int[] esperado = {4,5,3,3,1};
        assertArrayEquals(esperado, resultado);
    }
    
    
    @Test
    @DisplayName("Teste para verificar se os valores inválidos são superiores a 10% da sequência")
    public void testeSequenciaInvalida10() {
        Utils utils = new Utils();
        int[] resultado = null;
        try{
            resultado = utils.calculaNucleotideos("ASDUIN");
        } catch (Exception e){
            fail("Exceção inesperada: " + e.getMessage());
        }
        assertNull(resultado, "Esperado resultado null por conter mais de 10% de caracteres inválidos");
    }
    
    @Test
    @DisplayName("Teste para execução do método com string vazia")
    public void testeSequenciaVazia() {
        Utils utils = new Utils();
        try {
            utils.calculaNucleotideos("");
            fail("Era esperada uma exceção ao passar uma string vazia");
        } catch (Exception e) {
            assertEquals("String vazia!", e.getMessage());
        }
    }
    
    @Test
    @DisplayName("Teste com exatamente 10% dos caracteres inválidos")
    public void testeSequenciaValida10(){
        Utils utils = new Utils();
        int[] resultado = null;
        try {
            resultado = utils.calculaNucleotideos("ACGTGTCACAL");
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
        int esperado[] = {3,3,2,2,1};
        assertArrayEquals(esperado, resultado);
    }
    
    @Test
    @DisplayName("Teste com todos os caracteres inválidos")
    public void testeTodosInvalid(){
        Utils utils = new Utils();
        int[] resultado = null;
        try {
            resultado = utils.calculaNucleotideos("MKLPOIJU");
        } catch(Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
        assertNull(resultado);
    }
    
    @Test
    @DisplayName("Teste com letras minúsculas")
    public void testeMinusculas(){
        Utils utils = new Utils();
        int[] resultado = null;
        try{
             resultado = utils.calculaNucleotideos("agtcacgat");
        }catch(Exception e){
            fail("Exceção inesperada: " + e.getMessage());
        }
        int[] esperado = {3,2,2,2,0};
        assertArrayEquals(esperado, resultado);
    }
}
