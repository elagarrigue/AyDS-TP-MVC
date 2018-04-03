package controller;

import model.UserModelModule;
import view.EditUserView;
import view.UserViewModule;

public class UserControllerModule {

  private static UserControllerModule instance;

  private UserControllerModule() { }

  public static UserControllerModule getInstance() {
    if (instance == null) {
      instance = new UserControllerModule();
    }
    return instance;
  }

  void startApplication() {
    EditUserController controller = getEditUserController();

    EditUserView view = openEditUserWindowAndGetView(controller);

    controller.setEditUserView(view);
  }

  private EditUserController getEditUserController() {
    return new EditUserControllerImpl(UserModelModule.getInstance().getUserModel());
  }

  private EditUserView openEditUserWindowAndGetView(EditUserController editUserController) {
    return UserViewModule.getInstance().openEditUserWindow(editUserController);
  }
}
