module CPSC233Project {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires junit;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
}
