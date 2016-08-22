package com.example.tacademy.sampleappwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.example.tacademy.sampleappwidget.R;

/**
 * Implementation of App Widget functionality.
 */
public class my_app_widget extends AppWidgetProvider {
    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.my_app_widget);
                                                //(패키지명, 레이아웃아이디)
        views.setTextViewText(R.id.text_title, "MyAppWidget");
        // Instruct the widget manager to update the widget
        views.setImageViewResource(R.id.image_icon, R.drawable.btnleft); //이미지 설정

        PendingIntent pi = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
        views.setOnClickPendingIntent(R.id.image_icon, pi);



        appWidgetManager.updateAppWidget(appWidgetId, views);
    }


    @Override // 새로 앱 위젯 배치할 때마다 구동 한다.
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) { //각 아이디에서 대해서 업데이트
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }


    @Override
    public void onEnabled(Context context) { // 앱 위젯 프로바이더를 구동 한다.
        // Enter relevant functionality for when the first widget is created
    }

    @Override //앱 위젯 다 삭제 한 경우 구동 한다.
    public void onDisabled(Context context) { //앱 위젯 프로바이더를 구동 안 한다.
        // Enter relevant functionality for when the last widget is disabled
    }

    @Override //앱 위젯 삭제 할 경우 구동 한다.
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
    }


}

