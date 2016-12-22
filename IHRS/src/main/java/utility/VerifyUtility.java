package utility;

import com.github.plushaze.traynotification.animations.Animations;
import com.github.plushaze.traynotification.notification.Notification;
import com.github.plushaze.traynotification.notification.Notifications;
import com.github.plushaze.traynotification.notification.TrayNotification;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Duration;

public class VerifyUtility {

	public static void showWarning(String title, String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
	
	public static void showSuccessMessage(String title, String message) {
		Notification notification = Notifications.SUCCESS;
		TrayNotification tray = new TrayNotification();
		tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotification(notification);
        tray.setAnimation(Animations.POPUP);
        tray.showAndDismiss(Duration.seconds(2));
	}
}
