package java8.test;
public interface Person {
 
  public abstract String getFirstName();
  public abstract String getLastName();
 
  public default String getDisplayableFullName() {
    return getLastName() + ", " + getFirstName();
  }
 
  public abstract boolean isStudent();
 
  public default boolean isNotStudent() {
    return !isStudent();
  }
 
}