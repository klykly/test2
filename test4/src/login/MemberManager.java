package login;

import java.util.Iterator;

import javax.servlet.http.HttpSession;

import login.Exception.InvalidPasswordException;
import login.Exception.NoSuchMemberException;
import login.Exception.ServiceNotActiveException;
public class MemberManager implements LoginBeanBindingListener {
	private static final String LOGIN_BEAN = "JavacanLoginBean";
	private static MemberManager instance = null;

	private LoginUserList users = null;
	
	protected MemberManager() {
		  users = new LoginUserList();
	}

	public static MemberManager getInstance() {
		if (instance == null) {
			instance = new MemberManager();
		}
		return instance;
	}

	public void loginPerformed(LoginBeanBindingEvent event) {
		// 여기에 로그인과 관련되어 부가적으로 처리할 코드들이 들어간다.
		users.addLoginUser(event.getLoginBean());
	}

	public void logoutPerformed(LoginBeanBindingEvent event) {
		// 여기에 로그아웃과 관련되어 부가적으로 처리할 코드들이 들어간다.
		users.removeLoginUser(event.getLoginBean());
	}

	public Iterator getLoginUserIterator() {
		return users.iterator();
	}

	public boolean isLoginUser(String id) {
		return users.isLoginUser(id);
	}
		   
	public void login(HttpSession session, String id, String password)
			throws NoSuchMemberException,
			InvalidPasswordException,
			ServiceNotActiveException {
		//    accessor.checkPassword(id, password);
		// 다중 접속을 막기 위해 추가된 if 문장 
		if (isLoginUser(id)) {
			LoginBean lb = users.getLoginBean(id);
			lb.getSession().removeAttribute(LOGIN_BEAN);
		}
		LoginBean login = new LoginBeanImpl(id, this);
		session.setAttribute(LOGIN_BEAN, login);
 }
}