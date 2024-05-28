package com.formationkilo.javafxjdbcmaven.tools;

import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;



public class Notification {
    private static final String title="title";
    private static final String message="text context";
    public static void NotifSuccess(){
        Notifications type=Notifications.create()
                .title(title)
                .text(message)
                .graphic(null)
                .hideAfter(Duration.seconds(5))
                .position(Pos.TOP_RIGHT);

        type.showConfirm();


    }

    public static void NotifError(){
        Notifications type=Notifications.create()
                .title(title)
                .text(message)
                .graphic(null)
                .hideAfter(Duration.seconds(5))
                .position(Pos.BOTTOM_RIGHT);

        type.showError();


    }
}
