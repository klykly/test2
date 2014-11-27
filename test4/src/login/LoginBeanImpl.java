package login;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
public class LoginBeanImpl implements LoginBean, HttpSessionBindingListener {
    
    private LoginBeanBindingListener listener = null;
    private String id = null;
    private HttpSession session = null;
    
    public LoginBeanImpl(String id, LoginBeanBindingListener listener) {
       this.id = id;
       this.listener = listener;
    }
    
    public String getId() {
       return id;
    }
 
    public HttpSession getSession() {
       return session;
    }
 
    public void valueBound(HttpSessionBindingEvent event) {
       session = event.getSession();
       if (listener != null) 
          listener.loginPerformed(new LoginBeanBindingEvent(this));
    }
 
    public void valueUnbound(HttpSessionBindingEvent event) {
       session = null;
       if (listener != null) 
          listener.logoutPerformed(new LoginBeanBindingEvent(this));
    }
 }