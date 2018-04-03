package model;

import java.util.Date;

class UserModelImpl implements UserModel{

  private User user;
  private UserModelListener listener;

  UserModelImpl() {
    user = new User();
    user.setName("Diana");
    user.setLastName("Prince");
    user.setLastUpdate(new Date());
  }

  @Override public void setListener(UserModelListener listener) {
    this.listener = listener;
  }

  @Override public User getUser() {
    return user;
  }

  @Override public void updateUser(String name, String lastName) {
    updateUserNow( name,  lastName);
    notifyListener();
  }

  private void updateUserNow(String name, String lastName) {
    user.setName(name);
    user.setLastName(lastName);
    user.setLastUpdate(new Date());
  }

  private void notifyListener() {
    if (listener != null) {
      listener.didUpdateUser();
    }
  }
}
