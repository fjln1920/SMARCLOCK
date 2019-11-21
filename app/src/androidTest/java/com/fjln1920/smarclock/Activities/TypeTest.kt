package com.fjln1920.smarclock.Activities

import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

class TypeTest {


    @get:Rule
    public var mActivityRule: ActivityTestRule<Type> =
        ActivityTestRule(Type::class.java)
    private var type: Type? = null

    @Before
    fun setUp() {
        type =  mActivityRule.activity
    }

    @After
    fun tearDown() {
        type = null
    }

    @Test
    fun checkSolutionRetursTrue() {
        assertTrue(type!!.checkSolution("HAhguyJ", "HAhguyJ"))

    }
}