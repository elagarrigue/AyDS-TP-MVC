package view;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import controller.EditUserController;
import model.UserModelModule;

public class UserViewModule {

  private static UserViewModule instance;

  private UserViewModule() { }

  public static UserViewModule getInstance() {
    if (instance == null) {
      instance = new UserViewModule();
    }
    return instance;
  }

  public EditUserView openEditUserWindow(EditUserController editUserController) {
    EditUserViewImpl editUserView =
        new EditUserViewImpl(editUserController,
                             UserModelModule.getInstance().getUserModel());

    JFrame frame = new JFrame("Update User");
    frame.setContentPane(editUserView.content);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);

    return editUserView;
  }
}
