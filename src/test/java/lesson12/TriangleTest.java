package lesson12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static lesson12.Triangle.areaTriangle;
import static lesson12.Triangle.isTriangle;
import static org.junit.jupiter.api.Assertions.*;


public class TriangleTest {
    int a = 4;
    int b = 7;
    int c = 8;
    double areaABC = 13.997767679169419;

    static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @Test
    @DisplayName("Тест возможности образования треугольника")
    void myIsTriangleABCTest() {
        logger.info("Тест возможности образования треугольника");
        assertTrue(!isTriangle(a, b, c), "Стороны не образуют треугольник.");
    }

    @ParameterizedTest
    @DisplayName("Тест возможности образования треугольника")
    @CsvSource({"2, 3, 1", "4, 5, 6", "7, 7, 7"})
    void myIsTriangleTrueTest(int first, int second, int third) {
        logger.info("Тест возможности образования треугольника");
        assertTrue(!isTriangle(first, second, third), "Треугольник с заданными сторонами возможен.");
    }

    @ParameterizedTest
    @DisplayName("Тест на не возможность образования треугольника")
    @CsvSource({"2, 2, 10", "-1, 0, 5", "-1, 100, 5"})
    void myIsTriangleFalseTest(int first, int second, int third) {
        logger.info("Тест на не возможность образования треугольника");
        assertFalse(!isTriangle(first, second, third), "Стороны не образуют треугольник.");
    }

    @Test
    @DisplayName("Тест вычисления площади равностороннего треугольника по 3 сторонам")
    public void equalArealTriangleABCTest() {
        logger.info("Тест вычисления площади равностороннего треугольника по 3 сторона");
        assertEquals(areaABC, areaTriangle(a, b, c), "Ошибка вычисления площади!");
    }

    @ParameterizedTest
    @DisplayName("Тест вычисления площади")
    @CsvSource({"4, 7, 8, 13.997767679169419", "2, 3, 2, 1.984313483298443", "7, 7, 7, 21.21762239271875"})
    public void equalArealTriangleTest(int first, int second, int third, double area) {
        logger.info("Тест вычисления");
        assertEquals(area, areaTriangle(first, second, third), "Ошибка вычисления площади!");

    }

    @ParameterizedTest
    @DisplayName("Тест исключения")
    @CsvSource({"-1, 1, 1", "3, 0, 5", "1, 5, -5"})
    void testException(int first, int second, int third) {
        logger.info("Тест исключения");
        Assertions.assertThrows(Triangle.checkNumbersException.class, () -> Triangle.checkNumbers(first, second, third), "Нет исключения");
    }
}
