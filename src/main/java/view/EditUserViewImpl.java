package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import controller.EditUserController;
import model.User;
import model.UserModel;
import model.UserModelListener;

class EditUserViewImpl implements EditUserView{
  private JTextField userNameTF;
  private JTextField userLastNameTF;
  private JButton updateBtn;
  private JLabel lastUpdateLbl;
  protected JPanel content;
  private JProgressBar progressBar;

  private EditUserController editUserController;
  private UserModel userModel;

  EditUserViewImpl(EditUserController editUserController, UserModel userModel) {

    this.editUserController = editUserController;
    this.userModel = userModel;

    initListeners();
    updateUserFields();
  }

  @Override public void updateProgress(int progress) {
    progressBar.setValue(progress);
  }

  private void initListeners() {
    updateBtn.addActionListener(new ActionListener() {
      @Override public void actionPerformed(ActionEvent e) {
        editUserController
            .onEventUpdate(userNameTF.getText(), userLastNameTF.getText());
      }
    });
    userModel.setListener(new UserModelListener() {
      @Override public void didUpdateUser() {
        updateUserFields();
      }
    });
  }

  private void updateUserFields() {
    User user = userModel.getUser();
    userNameTF.setText(user.getName());
    userLastNameTF.setText(user.getLastName());
    lastUpdateLbl.setText(DateFormat.getTimeInstance().format(user.getLastUpdate()));
  }
}
