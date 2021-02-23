package ru.vsebudet_top;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.concurrent.TimeUnit;

public class SplashScreen extends AppCompatActivity {

	Animation topAnim;  // прописываем

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		SystemClock.sleep(TimeUnit.SECONDS.toMillis(3));  // ставим таймер на Splash screen

		//анимация
		//topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);

		Intent intent = new Intent(this, MainActivity.class); //обьявляем намеренья перехода из тикущего окна (SplashScreen.java) в окно MainActivity.java
		startActivity(intent); //запускаем намеренья
		finish(); //закрыть
	}
}