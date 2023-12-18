package com.example.exameninterfaces;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable {

    @FXML
    private DatePicker dpEntrada;
    @FXML
    private TextField txtMatricula;
    @FXML
    private ComboBox comboModelo;
    @FXML
    private ComboBox<Cliente> comboCliente;
    @FXML
    private DatePicker dpSalida;
    @FXML
    private TableColumn<Coche,String> cMatricula;
    @FXML
    private TableColumn<Coche,String> cModelo;
    @FXML
    private TableColumn<Coche, Date> cEntrega;
    @FXML
    private TableColumn<Coche,Date> cSalida;
    @FXML
    private TableColumn<Coche,Cliente> cCliente;
    @FXML
    private TableColumn<Coche,Integer> cTarifa;
    @FXML
    private TableColumn<Coche,Integer> cCoste;


    @FXML
    private Button btnAñadir;
    @FXML
    private Button btnSalir;
    @FXML
    private Label info;
    @FXML
    private Label lblCoste;
    @FXML
    private RadioButton rbStandard;
    @FXML
    private RadioButton rbOferta;
    @FXML
    private RadioButton rbLarga;
    private final ToggleGroup toggleGroup = new ToggleGroup();
    @FXML
    private TableView<Coche> tabla;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<Cliente> clientes = FXCollections.observableArrayList();
        clientes.add(new Cliente(1L,"Carmen","carmen@gmail.com"));
        clientes.add(new Cliente(2L,"Jorge","jorge@gmail.com"));
        clientes.add(new Cliente(3L,"Pepe","pepe@gmail.com"));


        ObservableList<String> modelos = FXCollections.observableArrayList();
        modelos.addAll("BMW","Mercedes","Ferrari");
        comboModelo.setItems(modelos);

        comboCliente.setItems(clientes);
cMatricula.setCellValueFactory((fila)->{
        return new SimpleStringProperty(fila.getValue().getMatricula());
    });
        tabla.getSelectionModel().selectedItemProperty();
    }


    @FXML
    public void añadirCoche(ActionEvent actionEvent) {


        if(!txtMatricula.getText().isEmpty()&& comboModelo.getValue() != null &&
                comboCliente.getValue() !=null && dpEntrada.getValue() !=null && dpSalida.getValue() !=null){
            Coche c=new Coche();
            c.setMatricula( txtMatricula.getText() );
            c.setModelo( comboModelo.getValue()+"" );
            c.setCliente(comboCliente.getValue());
            c.setFEntrada(dpEntrada.getValue());
            c.setFSalida(dpSalida.getValue());
             var fechaEntrada= dpEntrada.getValue();
             var fechaSalida=dpSalida.getValue();
            RadioButton seleccion = (RadioButton) toggleGroup.getSelectedToggle();
            Period periodo = Period.between(fechaEntrada, fechaSalida);
            var numeroPeriodo=periodo.getDays();
            if (seleccion != null) {
                if (seleccion == rbStandard) {
                    var total= numeroPeriodo*8;
                    cCoste.setText(String.valueOf(total));
                }
                if (seleccion == rbOferta) {
                    var total2 = numeroPeriodo * 6;
                    cCoste.setText(String.valueOf(total2));
                }
                if (seleccion == rbLarga){
                    var total3=numeroPeriodo*2;
                    cCoste.setText(String.valueOf(total3));
                }
                }

            tabla.getItems().add(c);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No puede haber ningun campo vacio.");
            alert.showAndWait();
        }


    }

    @FXML
    public void salir(ActionEvent actionEvent) {
        System.exit(0);
    }


    @FXML
    public void clickInfo(Event event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información del alumno");
        alert.setContentText("Carmen Garcia Robles "+"\n"+ "2ºDAM");
        alert.showAndWait();
    }
}