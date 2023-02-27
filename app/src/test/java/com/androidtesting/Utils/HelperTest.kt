package com.androidtesting.Utils

import org.junit.Assert.assertEquals
import org.junit.Test

class HelperTest {

    @Test
    fun isPalindrome() {

        //Arrange
        val helper = Helper()
        //Act
        val result = helper.isPalindrome("hello")
        //Assert

        assertEquals(false, result)
    }

    @Test
    fun isPalindrome_inputString_level_expectedTrue() {

        //Arrange
        val helper = Helper()
        //Act
        val result = helper.isPalindrome("level")
        //Assert

        assertEquals(true, result)
    }
}