package login;

import java.util.Hashtable;
import java.util.Iterator;
   public class LoginUserList {
      
      private Hashtable users = null;
   
      public LoginUserList() {
         users = new Hashtable();
      }
   
      public boolean isLoginUser(String id) {
         return users.get(id) != null;
      }   
   
      public Iterator iterator() {
         return users.values().iterator();
      }
   
      public void addLoginUser(LoginBean login) {
         users.put(login.getId(), login);
      }
      
      public void removeLoginUser (LoginBean login) {
         users.remove(login.getId());
      }
      
      public LoginBean getLoginBean(String id) {
          try {
             return (LoginBean)users.get(id);
          } catch (Exception ex) {
             return null;
          }
       }
   }