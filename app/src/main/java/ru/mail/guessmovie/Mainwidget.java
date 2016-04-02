package ru.mail.guessmovie;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RemoteViews;

public class Mainwidget extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        for(int i=0;i<appWidgetIds.length;i++){
            int appWidgeId=appWidgetIds[i];

            Intent intent= new Intent(context, MainActivity.class);
            PendingIntent pending = PendingIntent.getActivity(context, 0 , intent, 0);
            RemoteViews views= new RemoteViews(context.getPackageName(),R.layout.activity_mainwidget);
            views.setOnClickPendingIntent(R.id.imageButton123,pending);
            appWidgetManager.updateAppWidget(appWidgeId,views);
        }
    }
}
