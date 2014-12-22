package mockito;
 
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
 
 





import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
 
public class MockitoTest {
 
  /**
	 * <pre>
	 * verifyTest
	 * verify �׽�Ʈ
	 * <pre>
	 */
	@Test
	public void verifyTest() {
		@SuppressWarnings("unchecked")
		List<String> testMock = mock(ArrayList.class);
		testMock.add("1");
		testMock.add("2");
		testMock.add("3");
 
		// add()�� �ּ��� 1�� �̻� ȣ��Ǿ����� ����
		verify(testMock, atLeastOnce()).add(anyString());
 
		// add()�� �ּ��� 3�� �̻� ȣ��Ǿ����� ����
		verify(testMock, atLeast(3)).add(anyString());
 
		// add()�� �ִ��� 3�� ���� ȣ��Ǿ����� ����
		verify(testMock, atMost(3)).add(anyString());
 
		// add()�� 3�� ȣ��Ǿ����� ����
		verify(testMock, times(3)).add(anyString());
 
		verify(testMock, times(1)).add("1"); // add("1")�� 1�� ȣ��Ǿ����� ����
		verify(testMock, times(1)).add("2"); // add("2")�� 1�� ȣ��Ǿ����� ����
		verify(testMock, times(1)).add("3"); // add("3")�� 1�� ȣ��Ǿ����� ����
 
		// add("4")�� ������� �ʾҴ����� ����
		verify(testMock, never()).add("4");
	}
 
	/**
	 * <pre>
	 * whenThenTest
	 * when���� �ش��ϴ� �Լ��� ȣ���� ��� then���� ���ǵ� ������ ��ȯ
	 * <pre>
	 */
	@Test
	public void whenThenTest() {
		@SuppressWarnings("unchecked")
		Map<String, String> testMock = mock(Map.class);
 
		// ���� testMock.get("name1")�� ȣ���ϸ� kyu1 �̶�� ���� return�Ѵٴ� �ǹ̷ν�
		// testMock.put("name1", "kyu1")�� �� �Ͱ� ���� �ǹ̷� �����ϸ� �ȴ�.
		when(testMock.get("name1")).thenReturn("kyu1");
		when(testMock.get("name2")).thenReturn("kyu2");
		when(testMock.get("name3")).thenReturn("kyu3");
 
		assertThat("kyu1", is(testMock.get("name1")));
		assertThat("kyu2", is(testMock.get("name2")));
		assertThat("kyu3", is(testMock.get("name3")));
	}
 
	/**
	 * <pre>
	 * whenThenthrowtest
	 *
	 * <pre>
	 */
	@Test(expected = RuntimeException.class)
	public void whenThenthrowtest() {
		@SuppressWarnings("unchecked")
		Map<String, String> testMock = mock(Map.class);
 
		// get("name4")�� ȣ���ϸ� RuntimeException �߻�
		when(testMock.get("name4")).thenThrow(new RuntimeException());
		assertThat(testMock.get("name4"), is(RuntimeException.class));
	}
 
	/**
	 * <pre>
	 * whenThenAnswerTest
	 *
	 * <pre>
	 */
	@Test
	public void whenThenAnswerTest() {
		UserDAO userDAO = mock(UserDAO.class);
 
		when(userDAO.getUser("kyuId")).thenAnswer(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User();
				user.setUserId("kyuId");
				user.setName("����");
				user.setAge(32);
				return user;
			}
		});
 
		User user = userDAO.getUser("kyuId");
		assertThat("kyuId", is(user.getUserId()));
		assertThat("����", is(user.getName()));
		assertThat(32, is(user.getAge()));
	}
 
}
 
class UserDAO {
	public User getUser(String userId) {
		return new User();
	}
}
 
class User {
	private String userId;
	private String name;
	private int age;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}