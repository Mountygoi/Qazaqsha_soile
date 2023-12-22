package com.example.qazaqshasoile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.io.Serializable;
public class IntentBuilder {
    private Context context;
    private Class<?> targetActivity;
    private Bundle extras;
    public IntentBuilder(Context context) {
        this.context = context;
        this.extras = new Bundle();
    }
    public IntentBuilder setTargetActivity(Class<?> targetActivity) {
        this.targetActivity = targetActivity;
        return this;
    }
    public IntentBuilder putExtra(String key, Serializable value) {
        extras.putSerializable(key, value);
        return this;
    }
    public Intent build() {
        Intent intent = new Intent(context, targetActivity);
        intent.putExtras(extras);
        return intent;
    }
}