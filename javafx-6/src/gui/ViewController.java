package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.entities.Person;

public class ViewController implements Initializable {
	@FXML
	private ComboBox<Person> comboBoxPessoa;

	// TIPO DE LISTA QUE FICA OBSERVAVEL AO COMPONENTE VISUAL
	@FXML
	public void onComboBoxPersonAction() {
		Person person = comboBoxPessoa.getSelectionModel().getSelectedItem();
		System.out.println(person);
		
	}
	@FXML
	private Button btTudo;

	@FXML
	public void onBtTudo() {
		for(Person pessoa : comboBoxPessoa.getItems()) {
			System.out.println(pessoa);
			
		}
	}
	
	private ObservableList<Person> obsList;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// executar quando compilador for criado
		// iniciar a lista
		Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
			@Override
			protected void updateItem(Person item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getName());
			}
		};
		comboBoxPessoa.setCellFactory(factory);
		comboBoxPessoa.setButtonCell(factory.call(null));
		List<Person> list = new ArrayList<>();
		list.add(new Person(1, "Maria", "maria@gmail.com"));
		list.add(new Person(1, "joao", "3emaria@gmail.com"));
		list.add(new Person(1, "er", "3emaria@gmail.com"));
		list.add(new Person(1, "c", "2maria@gmail.com"));
		obsList = FXCollections.observableArrayList(list);
		comboBoxPessoa.setItems(obsList);
	}
}