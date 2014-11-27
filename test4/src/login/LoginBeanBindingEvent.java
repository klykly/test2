package login;
   public class LoginBeanBindingEvent {

      private LoginBean login = null;

      public LoginBeanBindingEvent(LoginBean login) {
         this.login = login;
      }
   
      public LoginBean getLoginBean() {
         return login;
      }
   }