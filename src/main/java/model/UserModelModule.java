package model;

public class UserModelModule {
  private static UserModelModule instance;
  private UserModel userModel;

  private UserModelModule() {
    userModel =  new UserModelImpl();
  }

  public static UserModelModule getInstance() {
    if(instance == null) {
      instance =  new UserModelModule();
    }
    return instance;
  }

  public UserModel getUserModel() {
    return userModel;
  }
}
