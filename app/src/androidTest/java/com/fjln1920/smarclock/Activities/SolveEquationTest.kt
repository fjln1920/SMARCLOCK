package com.fjln1920.smarclock.Activities

import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

class SolveEquationTest {


    @get:Rule
    public var mActivityRule: ActivityTestRule<SolveEquation> =
        ActivityTestRule(SolveEquation::class.java)
    private var solveEquation: SolveEquation? = null

    @Before
    fun setUp() {
        solveEquation = mActivityRule.activity
    }

    @Test
    fun checkSolutionReturnsTrue() {
        assertTrue(solveEquation!!.checkSolution("2+2 = x ", 3))
    }

    @After
    fun tearDown() {
        solveEquation = null
    }


}