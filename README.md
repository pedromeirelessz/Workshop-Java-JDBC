# JavaFX Project with JDBC

## Main view 

### Checklist:
* Create FXML "MainView" (package "gui")
* Load FXML in Main
* Update Main.java

```Java
public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/View.fxml"));
			ScrollPane scroll = loader.load();

			scroll.setFitToHeight(true);
			scroll.setFitToWidth(true);

			mainScene = new Scene(scroll);
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("Sample JavaFX application");
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
```

## Main view design 
### Checklist: 
* Design MainView.fxml
* Customize menu items 
* Update Main.java


```fxml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Menu?>
<?import javafx.scene.control.MenuBar?>
<?import javafx.scene.control.MenuItem?>
<?import javafx.scene.control.ScrollPane?>
<?import javafx.scene.layout.VBox?>

<ScrollPane maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity"
prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/10.0.1"
xmlns:fx="http://javafx.com/fxml/1">
 <content>
  <VBox prefHeight="326.0" prefWidth="513.0">
   <children>
    <MenuBar>
     <menus>
      <Menu mnemonicParsing="false" text="Registration">
       <items>
        <MenuItem mnemonicParsing="false" text="Seller" />
        <MenuItem mnemonicParsing="false" text="Departments" />
       </items>
      </Menu>
      <Menu mnemonicParsing="false" text="Help">
       <items>
        <MenuItem mnemonicParsing="false" text="About" />
       </items>
      </Menu>
     </menus>
    </MenuBar>
   </children>
  </VBox>
 </content>
</ScrollPane>
```
## Main view controller 
### Checklist:
* Create controller
* In view, associate controller, ids, events

## About view
### Checklist:
* Include util classes to the project (Alerts.java, Constraints.java)
* Create About.fxml (VBox)
* In Main.java, expose mainScene reference
* In MainViewController.java, create loadView method 

## DepartmentList view design 
### Checklist:
* Create DepartmentList.fxml (VBox) 
* In MainViewController.java, load DepartmentList

```fxml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.geometry.Insets?>
<?import javafx.scene.control.Button?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.TableColumn?>
<?import javafx.scene.control.TableView?>
<?import javafx.scene.control.ToolBar?>
<?import javafx.scene.layout.VBox?>
<?import javafx.scene.text.Font?>

<VBox maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity"
prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/10.0.1"
xmlns:fx="http://javafx.com/fxml/1">
 <children>
  <Label text="Department Registration">
   <font>
    <Font name="System Bold" size="14.0" />
   </font>
   <padding>
    <Insets left="5.0" top="5.0" />
   </padding>
   </Label>
   <ToolBar prefHeight="40.0" prefWidth="200.0">
    <items>
     <Button fx:id="btNew" mnemonicParsing="false" text="New" />
    </items>
   </ToolBar>
   <TableView prefHeight="200.0" prefWidth="200.0">
    <columns>
     <TableColumn prefWidth="75.0" text="Id" />
     <TableColumn prefWidth="75.0" text="Name" />
    </columns>
   </TableView>
 </children>
</VBox>
``` 

## DepartmentList controller
### Checklist:
* Create model.entities.Department.java 
* Create DepartmentListController.java
* In view, associate controller, ids, events 
