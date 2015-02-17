package mockito;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.*;


public class MokitoTest2 {
	List<String>  mockedList = mock(List.class);
	
	@Mock
	List<String> mockList2 ;;
	@Mock
	TestClass testClass;
	
	
	@Before
	public void test() {
		MockitoAnnotations.initMocks(this);
	}
	   
	   
	@Test
	public void testList(){
		// mock 객체 사용
		
		mockedList.add("one");
		mockedList.add("two");

		// 검증 하기
		verify(mockedList).add("one");
		// stubbing
		when(mockedList.get(0)).thenReturn("first");
		when(mockedList.get(1)).thenThrow(new RuntimeException());
		 
		// 첫 번째 element를 출력한다.
//		System.out.println(mockedList.get(0));
		 
		// runtime exception이 발생한다.
//		System.out.println(mockedList.get(1));
		 
		// 999번째 element 얻어오는 부분은 stub되지 않았으므로 null이 출력
//		System.out.println(mockedList.get(999));
		  
		// stubbing 된 부분이 호출되는지 확인할 수 있긴 하지만 불필요한 일입니다.
		// 만일 코드에서 get(0)의 리턴값을 확인하려고 하면 테스트가 깨집니다.
		// 만일 코드에서 get(0)의 리턴값에 대해 관심이 없다면 stubbing 하면 안 됩니다. 더 많은 정보를 위해서는 여기를 읽어보세요.
//		verify(mockedList).get(0);
		
		
		// 내장된 argument matcher인 anyInt()를 이용한 stubbing
		when(mockedList.get(anyInt())).thenReturn("element");
		 
		// hamcrest를 이용한 stubbing (isValid()는 사용자가 정의한 hamcrest matcher이다.)
//		when(mockedList.contains(argThat(isValid()))).thenReturn("element");

		// 다음 코드는 "element"를 출력한다. 
//		System.out.println(mockedList.get(999));
		 
		// argument matcher를 이용해 검증할 수도 있다.
//		verify(mockedList).get(anyInt());
	}
	
	@Test
	public void testMock2(){
		
		// mock 설정
		mockedList.add("once");
		 
		mockedList.add("twice");
		mockedList.add("twice");
		 
		mockedList.add("three times");
		mockedList.add("three times");
		mockedList.add("three times");
		 
		// 아래의 두 가지 검증 방법은 동일하다. times(1)은 기본값이라 생략되도 상관없다.
		verify(mockedList).add("once");
		verify(mockedList, times(1)).add("once");

		// 정확히 지정된 횟수만큼만 호출되는지 검사한다.
		verify(mockedList, times(2)).add("twice");
		verify(mockedList, times(3)).add("three times");

		// never()를 이용하여 검증한다. never()는 times(0)과 같은 의미이다.
		verify(mockedList, never()).add("never happened");

		// atLeast()와 atMost()를 이용해 검증한다.
		verify(mockedList, atLeastOnce()).add("three times");
		verify(mockedList, atLeast(2)).add("three times");
		verify(mockedList, atMost(5)).add("three times");
	}
	
	@Test(expected = RuntimeException.class)
	public void ThrowTest(){
		doThrow(new RuntimeException()).when(mockedList).clear();
		// 다음 문장은 RuntimeException를 던진다.
		mockedList.clear();
	}
	
	@Test
	public void verifyNoMoreIntgreations(){
		// mock 설정
		mockedList.add("one");
		mockedList.add("two");
		 
		verify(mockedList).add("one");

		// 다음 구문은 실패한다.
//		verifyNoMoreInteractions(mockedList);
	}
	
	@Test
	public void annotaionMockTest(){
		mockList2.add("one");
		// 검증 하기
		verify(mockList2).add("one");
		// stubbing
		when(mockList2.get(0)).thenReturn("first");
		when(mockList2.get(1)).thenThrow(new RuntimeException());
		

	}

	@Test
	public void callStrubingTest(){
		when(mockList2.get(1))
//		.thenThrow(new RuntimeException())
		.thenReturn("foo1", "foo2")
		.thenReturn("foo3");

		assertThat(mockList2.get(1), is("foo1"));
		assertThat(mockList2.get(1), is("foo2"));
		assertThat(mockList2.get(1), is("foo3"));

	}
	
	@Test
	public void callBackStrbing(){
		Answer<String> answer = new Answer<String>() {
			@Override
			public String answer(InvocationOnMock invocation) throws Throwable {
				return "test123";
			}
		};
		when(mockList2.get(anyInt())).thenAnswer(answer);
			 
			// 다음의 문장은 "called with arguments: foo"를 출력합니다.
		assertThat( mockList2.get(1), is("test123"));
	}
	
	@Test
	public void spyTest(){
		@SuppressWarnings("unchecked")
		List list = new LinkedList();
		List spy = spy(list);
		// 특정 메소드만 stub 하는 것이 가능하다.
		when(spy.size()).thenReturn(100);
		 
		// 스파이를 이용해 real method를 호출하기
		spy.add("one");
		spy.add("two");
		 
		// 리스트의 첫 번째 element인 "one"을 출력해라
//		System.out.println(spy.get(0));
		 
		// size() 가 stub 되었으므로 100이 출력된다.
//		System.out.println(spy.size());
		 
		// 검증도 가능
		verify(spy).add("one");
		verify(spy).add("two");
	}
	
	

	@Test
	public void doubleTest(){
//		assertTrue(testClass.getDouble(2) == 4);
		TestClass  testclass2 = mock(TestClass.class);
		when(testclass2.getDouble(anyInt())).thenReturn(4);
		when(testclass2.getDoubleDouble(anyInt())).thenReturn(8);
//		System.out.println(testclass2.getDouble(2));
		assertTrue(testclass2.getDouble(2) == 4);
//		assertTrue(testclass2.getDoubleDouble(2) == 8);
//		System.out.println(testclass2.getDoubleDouble(2));
		assertTrue(testclass2.getDoubleDouble(4) == 8);
	}
	
	
	@Test
	public void stirngTest2(){
		TestString  temp = mock(TestString.class);
		when(temp.getString()).thenReturn("Test3");
		assertThat(temp.getString(), is("Test3"));
	}
	
	
	@Test
	public void stirngTest(){
		TestString  temp = new TestString();
		assertThat(temp.getString(), is("Test1"));
		
		TestString spy = spy(temp);
		when(spy.getString()).thenReturn("Test3");
		assertThat(spy.getString(), is("Test3"));
		
		assertThat(spy.getString2(), is( spy.getString() + "getString2"));

//		when(temp.getString()).thenReturn("Test2");
//		System.out.println(temp.getString());

		
	}
	
	
	@Test
	public void argCaptureTest(){
//		TestClass  temp = mock(TestClass.class);
//		ArgumentCaptor<TestClass> argument = ArgumentCaptor.forClass(TestClass.class);
//		verify(temp).getDoubleDoubleDouble(argument.capture(), 2);
//
//		assertEquals("john", argument.getValue().getName());

		PersonTest mock = mock(PersonTest.class);
		
		
		ArgumentCaptor<Person> argument = ArgumentCaptor.forClass(Person.class);
		mock.personTest(new Person());
		verify(mock).personTest(argument.capture());
		System.out.println(argument.getValue().getName() + "-test-");
		assertEquals("John", argument.getValue().getName());
		
		
		 
	}
	
	class PersonTest{
		
		public void personTest(Person person){
			
		}
		
	}
	class Person{
		
		public String getName(){
			return "John";
		}
	}
	class TestString{
		
		public String getString(){
			return "Test1";
		}
		
		public String getString2(){
			return this.getString()+"getString2";
		}
		
		
	}
}

