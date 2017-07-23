package com.codingblocks.mywidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import java.util.Random;

/**
 * Implementation of App Widget functionality.
 */
public class MyWidget extends AppWidgetProvider {
    int i;

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {


    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            // Construct the RemoteViews object

            int i = new Random().nextInt(100);
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.my_widget);
            views.setTextViewText(R.id.appwidget_text, String.valueOf(i));

            Intent intent = new Intent(context,MainActivity.class);

            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS,appWidgetIds);

            intent.putExtra("VALUE",i);

            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            PendingIntent pi = PendingIntent.getActivity(context,appWidgetId,intent,PendingIntent.FLAG_UPDATE_CURRENT);

            views.setOnClickPendingIntent(R.id.appwidget_text,pi);

            // Instruct the widget manager to update the widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }

    @Override
    public void onEnabled(Context context) {
        i=0;
        // Enter relevant functionality for when the first widget is created
    }


    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

