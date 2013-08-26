package com.icg.bluetoothmessenger;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.MailTo;

/**
 * Class to display notifications
 * @author Chamila 
 *
 */
public class ReceiverNotificationService {

	private static final int NOTIFICATION_ID = 0;

	/**
	 * show notification
	 * @param cntx application context
	 * @param msg message to be desplayed
	 * @param sender sender's identification
	 */
	public static void showNotification(Context cntx , String msg, String sender) {
		
		Context context = cntx;//getApplicationContext();

		String ns = Context.NOTIFICATION_SERVICE;
		NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(ns);

		int icon = R.drawable.notification_icon;
		CharSequence tickerText = context.getString(R.string.notification_bar_text);
		long when = System.currentTimeMillis();
				CharSequence contentTitle = context.getString(R.string.notification_content_title) +
						sender;
		CharSequence contentText = msg;

		// when the notification is clicked, following Activity starts
		Intent notificationIntent = new Intent(context,
				ReceiverActivity.class);
		notificationIntent.putExtra("sender", sender);
		notificationIntent.putExtra("message", msg);
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
				notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);

		Notification notification = new Notification(icon, tickerText, when);
		notification.setLatestEventInfo(context, contentTitle, contentText,
				contentIntent);
		notification.defaults = Notification.DEFAULT_SOUND;
		notification.flags = Notification.FLAG_AUTO_CANCEL;
		mNotificationManager.notify(NOTIFICATION_ID, notification);
		// mNotificationManager.cancel(NOTIFICATION_ID);
	}
}
