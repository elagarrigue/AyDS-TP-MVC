package controller;

import model.UserModel;
import view.EditUserView;

class EditUserControllerImpl implements EditUserController {

  private UserModel userModel;
  private EditUserView editUserView;

  EditUserControllerImpl(UserModel userModel) {
    this.userModel = userModel;
  }

  @Override public void onEventUpdate(String name, String lastName) {
    editUserView.updateProgress(0);

    new Thread(new Runnable() {
      @Override public void run() {
        for (int i = 0; i<=100; i++) {
          try {
            Thread.sleep(25);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          editUserView.updateProgress(i);
        }
        userModel.updateUser(name, lastName);
      }
    }).start();

  }

  @Override public void setEditUserView(EditUserView editUserView) {
    this.editUserView = editUserView;
  }
}
