/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piggywallet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Vivek Gupta
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField username;
    
    @FXML
    private PasswordField password;
    
    @FXML
    private Label header;
    
    @FXML
    private Button login;
    
    @FXML 
    private ImageView iv1;
    
    @FXML 
    private ImageView iv2;
    
    @FXML 
    private ImageView iv3;
    
    @FXML 
    private ImageView iv4;
    
    @FXML
    private Label pre;
    
    @FXML
    private Label initial;
    
    @FXML
    private Label currentbalance;
    
    @FXML
    private Label yrsspent;
    
    @FXML
    private Label mainname;
    
    @FXML
    private Label amtspenttot;
            
    String whoami;
    
    @FXML
    public void loginaction(ActionEvent ae) throws IOException{
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            conn=DriverManager.getConnection("jdbc:derby://localhost:1527/PaisaPaisa","Anishka","2010aarav");
            
        }
        catch(SQLException se){
            se.printStackTrace();
        }
        if(ae.getSource()==login){
            String name=username.getText();
            String pass=password.getText();
            try{
            ps=conn.prepareStatement("Insert into APP.Paisa values(?,?)");
                   ps.setString(1,name);
                   ps.setString(2,pass);
                   ps.execute();
          //  ps=conn.prepareStatement("select * from APP.Paisa where name=? and pass=?"); 
           // ps.setString(1,name);
           // ps.setString(2,pass);
           // rs=ps.executeQuery();
            if(rs.next()){
                   Stage stagex; 
                   Parent rootx;
                   stagex = (Stage)login.getScene().getWindow();
                   rootx=FXMLLoader.load(getClass().getResource("person.fxml"));
                   Scene scene = new Scene(rootx);
                   stagex.setScene(scene);
                   stagex.show();
                   whoami=name;
                   openUserProfile();
                }
                else{
                    pre.setText("Invalid Username/Password");
                }
              }
            catch(SQLException se){
                se.printStackTrace();
            }
        }
        
    }
   public void openUserProfile(){
       File f=new File(whoami+".txt");
     if(!f.exists()){
        try{
            f.createNewFile();
            FileOutputStream ff = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(ff);
            MoneyManager dummy = new MoneyManager();
            oos.writeObject(dummy);
        }
        catch(IOException io){
            System.out.println(io.getMessage());
        }
    }
        try(FileInputStream fis = new FileInputStream(f)){
            ObjectInputStream ois = new ObjectInputStream(fis);
            MoneyManager mm = (MoneyManager) ois.readObject();
            currentbalance.setText(mm.getCurrentBalance()+"");
            initial.setText(mm.initial.toString());
            yrsspent.setText(mm.yrsspent+" years");
            mainname.setText(whoami);
            amtspenttot.setText(mm.amtspenttot+"");
            
        }
        catch(ClassNotFoundException|IOException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            //code to show up a dialog box saying that user has deleted his/her data and needs to restart..
                }

       
       
   }
    @FXML
    public void ScaleIn1(MouseEvent me){
        Timeline t1 = new Timeline(new KeyFrame(Duration.millis(200),ab->iv1.setScaleX(1.1)));
        Timeline t2 = new Timeline(new KeyFrame(Duration.millis(200),ab->iv1.setScaleY(1.1)));
        t1.play();
        t2.play();
    }
    
    @FXML
    public void ScaleOut1(MouseEvent me){
        Timeline t1 = new Timeline(new KeyFrame(Duration.millis(200),ab->iv1.setScaleX(1)));
        Timeline t2 = new Timeline(new KeyFrame(Duration.millis(200),ab->iv1.setScaleY(1)));
        t1.play();
        t2.play();
    }
    @FXML
    public void ScaleIn2(MouseEvent me){
        Timeline t1 = new Timeline(new KeyFrame(Duration.millis(200),ab->iv2.setScaleX(1.1)));
        Timeline t2 = new Timeline(new KeyFrame(Duration.millis(200),ab->iv2.setScaleY(1.1)));
        t1.play();
        t2.play();
    }
    
    @FXML
    public void ScaleOut2(MouseEvent me){
        Timeline t1 = new Timeline(new KeyFrame(Duration.millis(200),ab->iv2.setScaleX(1)));
        Timeline t2 = new Timeline(new KeyFrame(Duration.millis(200),ab->iv2.setScaleY(1)));
        t1.play();
        t2.play();
    }
    
    @FXML
    public void ScaleIn3(MouseEvent me){
        Timeline t1 = new Timeline(new KeyFrame(Duration.millis(200),ab->iv3.setScaleX(1.1)));
        Timeline t2 = new Timeline(new KeyFrame(Duration.millis(200),ab->iv3.setScaleY(1.1)));
        t1.play();
        t2.play();
    }
    
    @FXML
    public void ScaleOut3(MouseEvent me){
        Timeline t1 = new Timeline(new KeyFrame(Duration.millis(200),ab->iv3.setScaleX(1)));
        Timeline t2 = new Timeline(new KeyFrame(Duration.millis(200),ab->iv3.setScaleY(1)));
        t1.play();
        t2.play();
    }
    
    @FXML
    public void ScaleIn4(MouseEvent me){
        Timeline t1 = new Timeline(new KeyFrame(Duration.millis(200),ab->iv4.setScaleX(1.1)));
        Timeline t2 = new Timeline(new KeyFrame(Duration.millis(200),ab->iv4.setScaleY(1.1)));
        t1.play();
        t2.play();
    }
    
    @FXML
    public void ScaleOut4(MouseEvent me){
        Timeline t1 = new Timeline(new KeyFrame(Duration.millis(200),ab->iv4.setScaleX(1)));
        Timeline t2 = new Timeline(new KeyFrame(Duration.millis(200),ab->iv4.setScaleY(1)));
        t1.play();
        t2.play();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
}

