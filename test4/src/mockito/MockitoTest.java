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
	 * verify 테스트
	 * <pre>
	 */
	@Test
	public void verifyTest() {
		@SuppressWarnings("unchecked")
		List<String> testMock = mock(ArrayList.class);
		testMock.add("1");
		testMock.add("2");
		testMock.add("3");
 
		// add()가 최소한 1번 이상 호출되었는지 검증
		verify(testMock, atLeastOnce()).add(anyString());
 
		// add()가 최소한 3번 이상 호출되었는지 검증
		verify(testMock, atLeast(3)).add(anyString());
 
		// add()가 최대한 3번 이하 호출되었는지 검증
		verify(testMock, atMost(3)).add(anyString());
 
		// add()가 3번 호출되었는지 검증
		verify(testMock, times(3)).add(anyString());
 
		verify(testMock, times(1)).add("1"); // add("1")가 1번 호출되었는지 검증
		verify(testMock, times(1)).add("2"); // add("2")가 1번 호출되었는지 검증
		verify(testMock, times(1)).add("3"); // add("3")가 1번 호출되었는지 검증
 
		// add("4")가 수행되지 않았는지를 검증
		verify(testMock, never()).add("4");
	}
 
	/**
	 * <pre>
	 * whenThenTest
	 * when절에 해당하는 함수를 호출할 경우 then절에 정의된 내역을 반환
	 * <pre>
	 */
	@Test
	public void whenThenTest() {
		@SuppressWarnings("unchecked")
		Map<String, String> testMock = mock(Map.class);
 
		// 만약 testMock.get("name1")를 호출하면 kyu1 이라는 값을 return한다는 의미로써
		// testMock.put("name1", "kyu1")을 한 것과 같은 의미로 생각하면 된다.
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
 
		// get("name4")를 호출하면 RuntimeException 발생
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
				user.setName("남규");
				user.setAge(32);
				return user;
			}
		});
 
		User user = userDAO.getUser("kyuId");
		assertThat("kyuId", is(user.getUserId()));
		assertThat("남규", is(user.getName()));
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