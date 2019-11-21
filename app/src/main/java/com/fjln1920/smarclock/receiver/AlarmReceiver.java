package com.fjln1920.smarclock.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

//import com.example.leanh.service.AlarmService;
//import com.example.leanh.ultil.Constants;
import com.fjln1920.Settings;
import com.fjln1920.smarclock.Activities.StartAGame;
import com.fjln1920.smarclock.Utils.Constants;
import com.fjln1920.smarclock.service.AlarmService;

import java.util.Set;

import static android.widget.Toast.*;

public class AlarmReceiver extends BroadcastReceiver {
    // this hold pendingIntend id if one pendingIntend trigger. The PendingIntent'id is alarm'id
    public static int pendingId;


    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving

        if (intent != null) {


            try {
                // getting intent key "intentType"

                String intentType = intent.getExtras().getString("intentType");
                Log.e("reciver", intentType);
                Intent StartAGAmeIntent = new Intent(context, StartAGame.class);
                if (intentType.equals(Constants.ADD_INTENT)){
                    pendingId = intent.getExtras().getInt("PendingId");
                    StartAGAmeIntent.putExtra("ON_OFF", Constants.ADD_INTENT);
                    StartAGAmeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(StartAGAmeIntent);

                }

                /*else if(intentType.equals(Constants.OFF_INTENT)){
                    int alarmId = intent.getExtras().getInt("AlarmId");
                    StartAGAmeIntent.putExtra("ON_OFF", Constants.OFF_INTENT);
                    StartAGAmeIntent.putExtra("AlarmId", alarmId);
                }*/


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}