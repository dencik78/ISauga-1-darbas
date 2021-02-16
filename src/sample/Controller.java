package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextArea textArea_text;

    @FXML
    private TextArea textArea_cryptText;

    @FXML
    private Button buttonCrypt;

    @FXML
    private TextField textField_keyWord;

    @FXML
    private CheckBox checkbox_encrypt;

    @FXML
    private CheckBox checkbox_decrypt;

    @FXML
    void buttonCryptClick(ActionEvent event) {
        crypt crypt = new crypt();
        if(checkbox_encrypt.isSelected()) {
            String cryptText = crypt.encrypt(textArea_text.getText(), textField_keyWord.getText());
            textArea_cryptText.setText(cryptText);

           // textArea_text.setText(null);
        }else if(checkbox_decrypt.isSelected()){
            String cryptText = crypt.decrypt(textArea_text.getText(), textField_keyWord.getText());
            textArea_cryptText.setText(cryptText);

           // textArea_text.setText(null);
        }
    }

    @FXML
    void decryptCheckBox(ActionEvent event) {
        checkbox_encrypt.setSelected(false);
        checkbox_decrypt.setSelected(true);
    }

    @FXML
    void encryptChekBox(ActionEvent event) {
        checkbox_encrypt.setSelected(true);
        checkbox_decrypt.setSelected(false);
    }

}
