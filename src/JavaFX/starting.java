//package JavaFX;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Group;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;
//
//import java.util.Objects;
//
//import static java.util.Objects.requireNonNull;
//import static javafx.fxml.FXMLLoader.load;
//
//
//public class starting extends Application {
//    @Override
//    public void start(Stage stage) throws Exception {
//        try {
////            Parent root = load(requireNonNull(getClass().getResource("Starting.fxml")));
//            Parent root = load(requireNonNull(getClass().getResource("Starting.fxml")));
//            Parent loader = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(".fxml")));
//            Scene sc = new Scene(root);
//            stage.setScene(sc);
//            stage.show();
//        }catch (NullPointerException e ){
//            System.out.println("Ok Got it.");
//            e.printStackTrace();
//        }
////        stage.setResizable(true);
//////        stage.setX(10);
//////        stage.setY(5);
////        stage.setFullScreen(false);
//////        stage.setFullScreenExitHint("Exit plz ");
////        stage.setFullScreenExitKeyCombination(new KeyCodeCombination(KeyCode.T, KeyCombination.CONTROL_ANY));
//////        stage.setHeight(600);
//////        stage.setWidth(600);
////        Text text = new Text("Hey its a Texty text ");
////        text.setX(60);
////        text.setY(60);
////        text.setFont(Font.font("calibri",20));
////        text.setFill(Color.FORESTGREEN);
////
////        Line line = new Line();
////        line.setStartX(200);
////        line.setStartY(200);
////        line.setEndX(500);
////        line.setEndY(200);
////        line.setOpacity(10);
////        line.setStroke(Color.YELLOWGREEN);
////        line.setStrokeWidth(7);
////        line.setFill(Color.BLACK);
//////        System.out.println(line.rotateProperty());
////        line.setRotate(50);
////
////        Rectangle rec = new Rectangle();
////        rec.setY(70);
////        rec.setX(70);
////        rec.setWidth(100);
////        rec.setHeight(100);
//////        rec.setArcHeight(50);
//////        rec.setArcWidth(50);
////        rec.setFill(Color.YELLOWGREEN);
////        rec.setStrokeWidth(3);
////        rec.setStroke(Color.BLACK);
////
////        Polygon tri = new Polygon();
////        tri.getPoints().setAll(
////                100.0,100.0,
////                200.0,300.0,
////                300.0,200.0,
////                100.0,100.0
//////                50.0,50.0,
//////                60.0,60.0
////        );
////        tri.setFill(Color.BLUE);
////        tri.setStrokeWidth(6);
////        tri.setStroke(Color.BLACK);
////
////        Circle cr = new Circle();
////        cr.setCenterX(400);
////        cr.setCenterY(400);
////        cr.setRadius(40);
////        cr.setFill(Color.DEEPPINK);
////        cr.setStroke(Color.HOTPINK);
////        cr.setStrokeWidth(5);
////
////        Image img = new Image("img.png");
////        ImageView iv = new ImageView(img);
////        iv.setX(400);
////        iv.setY(300);
////
//////        RectangleHelper rh = new RectangleHelper();
////
////        Group root = new Group();
////        root.getChildren().add(text);
////        root.getChildren().add(line);
////        root.getChildren().add(rec);
////        root.getChildren().add(tri);
////        root.getChildren().add(cr);
////        root.getChildren().add(iv);
////
////
////        Scene scene = new Scene(root,600,500, Color.LIGHTGREY);
////        Image TestPIC = new Image("image.jpg");
////        stage.getIcons().add(TestPIC);
////        stage.setTitle("Horny Panel");
////        stage.setScene(scene);
////        stage.show();
//        //////////////////////////////////////////
//        Stage newpanel = new Stage();
//        newpanel.setResizable(false);
//        newpanel.setX(780);
//        newpanel.setY(5);
//        newpanel.setTitle("New Horny Panel");
//        Group newGRoup = new Group();
//        Scene newscene = new Scene(newGRoup,550,550,Color.LAVENDER);
//
//        newpanel.setTitle("New Panel");
//        newpanel.setScene(newscene);
////        newpanel.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
