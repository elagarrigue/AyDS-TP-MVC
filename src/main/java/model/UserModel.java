package model;

public interface UserModel {

  User getUser();
  void updateUser(String name, String lastName);
  void setListener(UserModelListener listener);
}
