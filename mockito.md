# Mockito

JUnit is a framework that helps with writing and running your unit tests.<br>

Mockito (or any other mocking tool) is a framework that you specifically use to efficiently write certain kind of tests. At its core, any mocking framework allows you to omit instantiating "real" objects of production classes, instead the mocking framework creates a stub for you.<br>

What is mocking?
mocking is creating objects that simulate the behavior of real objects. <br>
Unlike stubs, mocks can be dynamically created from code - at runtime.<br>
Mocks offer more functionality than stubbing.<br>
you can verify method calls and a lot of other things.<br>


## Ways we can stub
### 1
#### Mockito.mock(ClassToMock.class) <br>
#### Mockito.stub(mockedClass.method("params")).return(desired output) <br>

### 2
**when** is used to stub the method
#### Mockito.mock(ClassToMock.class) <br>
#### Mockito.when(mockedClass.method("pra")).thenReturn(output);<br>

# Basics Of Mockito

when().thenReturn().thenReturn()... n times
as many times you invoke the next return will be the result
<br>

**org.Mockito.Matchers-->** anyInt(),anyString()...<br>

**when().thenThrow()

# BDD Style

behaviour driven development<br>

given - setup<br>

when - actual method call<br>

then - assert<br>


## verify call
to verify if specific method is called
verify(mock).method

verify(mock,times()).method<br>
verify(mock,atLeast()).method<br>
verify(mock,never()).method<br>

The other way more readable way is <br>
then().should().method<br>
then().should(never()).method<br>



## capturing arguments passed to mock
to know what are the arguements passed to the method<br>

 assertThat(stringArgumentCaptor.getAllValues().size(),is(2));
<br><br>


# Annotations

**@Mock** annotation

The @Mock annotation is used to create mock objects that can be used to replace dependencies in a test class. <br>
to inject Services,repositories ...<br>
@Mock<br>
TodoService todoService;

@RunWith(MockitoJUnitRunner.class)

<br>

**@InjectMocks** 
The @InjectMocks annotation is used to create an instance of a class and inject the mock objects into it, allowing you to test the behavior of the class.
<br>

**@Captor**
    ArgumentCaptor<String> captor;


# Mockito/ Junit rules

**@Rule**
MockitoRule mockitoRule = MockitoJunit.rule();

<br>
must be public


# Mockito SPY
spy is partially mocking case where if you want to use you can use functions and want to stub ,can stub.<br>


# Why Mockito doesn't allow stubbing private and final methods

to allow good design , can mock only public classes and interfaces
### what you cannot mock
1. static methods
2. private methods

**That's where PowerMockito comes in**

# PowerMockito

@RunWith(PowerMockRunner.class)
@PrepareTest({static clasess})


PowerMockito.mockStatic(staticClass)
when(mockstiaticMethod)


**Verify**
PowerMockito.verifyStatic();

StaticClass.method()