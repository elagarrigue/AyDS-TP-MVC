package controller;

import view.EditUserView;

public interface EditUserController {

  void onEventUpdate(String name, String lastName);
  void setEditUserView(EditUserView editUserView);

}
