/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Service.PacksService;
import com.sun.javafx.scene.control.skin.Utils;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import entities.Packs;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class MembershipController2 implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfdescription;
    @FXML
    private TextField tfduration;
    @FXML
    private TextField tfmontant;
    @FXML
    private Button btnAdd;
    @FXML
    private TextField tfnom2;
    @FXML
    private TextField tfdescription2;
    @FXML
    private TextField tfmontant2;
    @FXML
    private TextField tfduration2;
    @FXML
    private Button btnDelete2;
    @FXML
    private Button btnModify2;
    @FXML
    private TextField tfnom1;
    @FXML
    private TextField tfdescription1;
    @FXML
    private TextField tfmontant1;
    @FXML
    private TextField tfduration1;
    @FXML
    private Button btnDelete1;
    @FXML
    private Button btnmodify1;
    @FXML
    private ImageView btnForward;
    @FXML
    private ImageView btnBack2;
    @FXML
    private ImageView home2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addPack(ActionEvent event) {
        
            String pack_nom = tfnom.getText();
            String pack_description = tfdescription.getText();
            String pack_duration = tfduration.getText();
            String pack_Montant = tfmontant.getText();
            String pack_expiration_date = "";
            
            Packs p = new Packs (pack_nom, pack_Montant, pack_description, pack_duration, pack_expiration_date);
            
            
            PacksService ps = new PacksService();
            
            ps.ajouterPacks(p);
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("membership2_1.fxml"));
        try {
            Parent root = loader.load();
           MembershipController2_1 mc2_1 = loader.getController();
           mc2_1.setTextpack_nom(p.getPack_nom());
           mc2_1.setTextpack_description(p.getPack_description());
           mc2_1.setTextpack_Montant(p.getPack_Montant());
           mc2_1.setTextpack_duration(p.getPack_duration());
           
           tfnom.getScene().setRoot(root);
        } catch (IOException ex) {
           System.err.println(ex.getMessage());

        }
    }

    @FXML
    private void deletePack2(ActionEvent event) {
    }

    @FXML
    private void modifyPack2(ActionEvent event) {
    }

    @FXML
    private void deletePack1(ActionEvent event) {
    }

    @FXML
    private void modifyPack1(ActionEvent event) {
    }
 

    @FXML
    private void Forward(MouseEvent event) {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("membership2_1.fxml"));
        try {
            Parent root = loader.load();
           MembershipController2_1 mc2_1 = loader.getController();
           
           btnForward.getScene().setRoot(root);
        } 
        catch (IOException ex) {
           System.err.println(ex.getMessage());

        }
    }

    @FXML
    private void Back2(MouseEvent event) {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("membership.fxml"));
        try {
            Parent root = loader.load();
           MembershipController mc = loader.getController();
           
           btnBack2.getScene().setRoot(root);
        } 
        catch (IOException ex) {
           System.err.println(ex.getMessage());

        }
    }

    @FXML
    private void home2(MouseEvent event) throws IOException {
 
                home2.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("/javafx/Home_admin.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
}
