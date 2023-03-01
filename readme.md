# Junit and Mockito learnings

testing in units<br>
org.junit.Assert <br>
org.junit.Test <br>

Assert.assertEquals(exp,act);<br>

@Test to represent/signify that someting is a unit test and the method should only be **public and void** <br>

Assert.assertTrue(condition)<br>
Assert.assertFalse(con)<br>


## @Before and @After annotation

before- would be called before each method with @test in execution
after- would be called after each method with @test in execution

## @BeforeClass & @AfterClass

must be static

## Comparing Arrays in Test

assertArrayEquals

## Testing Exceptions

@Test(expected = NullPointerException.class)

## Performace Testing

@Test(timeout = 100)

## parameterised

@RunWith(Parameterized.class)

##Test Suite
@RunWith(Suite.class)
@Suite.SuiteClasses({all test classes with .class sep =','})

