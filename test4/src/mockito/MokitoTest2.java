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
		// mock ��ü ���
		
		mockedList.add("one");
		mockedList.add("two");

		// ���� �ϱ�
		verify(mockedList).add("one");
		// stubbing
		when(mockedList.get(0)).thenReturn("first");
		when(mockedList.get(1)).thenThrow(new RuntimeException());
		 
		// ù ��° element�� ����Ѵ�.
//		System.out.println(mockedList.get(0));
		 
		// runtime exception�� �߻��Ѵ�.
//		System.out.println(mockedList.get(1));
		 
		// 999��° element ������ �κ��� stub���� �ʾ����Ƿ� null�� ���
//		System.out.println(mockedList.get(999));
		  
		// stubbing �� �κ��� ȣ��Ǵ��� Ȯ���� �� �ֱ� ������ ���ʿ��� ���Դϴ�.
		// ���� �ڵ忡�� get(0)�� ���ϰ��� Ȯ���Ϸ��� �ϸ� �׽�Ʈ�� �����ϴ�.
		// ���� �ڵ忡�� get(0)�� ���ϰ��� ���� ������ ���ٸ� stubbing �ϸ� �� �˴ϴ�. �� ���� ������ ���ؼ��� ���⸦ �о����.
//		verify(mockedList).get(0);
		
		
		// ����� argument matcher�� anyInt()�� �̿��� stubbing
		when(mockedList.get(anyInt())).thenReturn("element");
		 
		// hamcrest�� �̿��� stubbing (isValid()�� ����ڰ� ������ hamcrest matcher�̴�.)
//		when(mockedList.contains(argThat(isValid()))).thenReturn("element");

		// ���� �ڵ�� "element"�� ����Ѵ�. 
//		System.out.println(mockedList.get(999));
		 
		// argument matcher�� �̿��� ������ ���� �ִ�.
//		verify(mockedList).get(anyInt());
	}
	
	@Test
	public void testMock2(){
		
		// mock ����
		mockedList.add("once");
		 
		mockedList.add("twice");
		mockedList.add("twice");
		 
		mockedList.add("three times");
		mockedList.add("three times");
		mockedList.add("three times");
		 
		// �Ʒ��� �� ���� ���� ����� �����ϴ�. times(1)�� �⺻���̶� �����ǵ� �������.
		verify(mockedList).add("once");
		verify(mockedList, times(1)).add("once");

		// ��Ȯ�� ������ Ƚ����ŭ�� ȣ��Ǵ��� �˻��Ѵ�.
		verify(mockedList, times(2)).add("twice");
		verify(mockedList, times(3)).add("three times");

		// never()�� �̿��Ͽ� �����Ѵ�. never()�� times(0)�� ���� �ǹ��̴�.
		verify(mockedList, never()).add("never happened");

		// atLeast()�� atMost()�� �̿��� �����Ѵ�.
		verify(mockedList, atLeastOnce()).add("three times");
		verify(mockedList, atLeast(2)).add("three times");
		verify(mockedList, atMost(5)).add("three times");
	}
	
	@Test(expected = RuntimeException.class)
	public void ThrowTest(){
		doThrow(new RuntimeException()).when(mockedList).clear();
		// ���� ������ RuntimeException�� ������.
		mockedList.clear();
	}
	
	@Test
	public void verifyNoMoreIntgreations(){
		// mock ����
		mockedList.add("one");
		mockedList.add("two");
		 
		verify(mockedList).add("one");

		// ���� ������ �����Ѵ�.
//		verifyNoMoreInteractions(mockedList);
	}
	
	@Test
	public void annotaionMockTest(){
		mockList2.add("one");
		// ���� �ϱ�
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
			 
			// ������ ������ "called with arguments: foo"�� ����մϴ�.
		assertThat( mockList2.get(1), is("test123"));
	}
	
	@Test
	public void spyTest(){
		@SuppressWarnings("unchecked")
		List list = new LinkedList();
		List spy = spy(list);
		// Ư�� �޼ҵ常 stub �ϴ� ���� �����ϴ�.
		when(spy.size()).thenReturn(100);
		 
		// �����̸� �̿��� real method�� ȣ���ϱ�
		spy.add("one");
		spy.add("two");
		 
		// ����Ʈ�� ù ��° element�� "one"�� ����ض�
//		System.out.println(spy.get(0));
		 
		// size() �� stub �Ǿ����Ƿ� 100�� ��µȴ�.
//		System.out.println(spy.size());
		 
		// ������ ����
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

