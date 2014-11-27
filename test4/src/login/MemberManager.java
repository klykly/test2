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
		// ���⿡ �α��ΰ� ���õǾ� �ΰ������� ó���� �ڵ���� ����.
		users.addLoginUser(event.getLoginBean());
	}

	public void logoutPerformed(LoginBeanBindingEvent event) {
		// ���⿡ �α׾ƿ��� ���õǾ� �ΰ������� ó���� �ڵ���� ����.
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
		// ���� ������ ���� ���� �߰��� if ���� 
		if (isLoginUser(id)) {
			LoginBean lb = users.getLoginBean(id);
			lb.getSession().removeAttribute(LOGIN_BEAN);
		}
		LoginBean login = new LoginBeanImpl(id, this);
		session.setAttribute(LOGIN_BEAN, login);
 }
}