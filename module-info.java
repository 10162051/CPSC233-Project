module CPSC233Project {
	requires javafx.controls;
	requires javafx.fxml;
	requires junit;
	requires java.desktop;
	requires javafx.base;
	requires javafx.graphics;
	requires jdk.compiler;
	
	opens application to javafx.graphics, javafx.fxml;
}
