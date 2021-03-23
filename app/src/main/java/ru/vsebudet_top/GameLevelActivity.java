package ru.vsebudet_top;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevelActivity extends AppCompatActivity {

	private static final String TAG = "MyApp";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gamelevels);

		//Убрать строку состояния на телефоне
		Window w = getWindow();
		w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		//находим кнопку по ссылке
		ImageButton button_back = findViewById(R.id.button_back);
		// Вешаем слушатель на кнопку.
		button_back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Здесь будет команда для кнопки.
				// Начало конструкции
				try {
					Context context;
					//подключаем звук на кнопку
					MediaPlayer md_2 = MediaPlayer.create(GameLevelActivity.this, R.raw.press_button);
					md_2.start();

					Intent intent = new Intent(GameLevelActivity.this, MainActivity.class);
					startActivity(intent);
					finish();
				} catch (Exception e) {
					Log.i(TAG, "Сработала кнопка назад с GameLevelActivity на MainActivity");
					e.printStackTrace();
				}
			}
		});
		//Кнопка для перехода на 1 уровень НАЧАЛО
		//Находим кнопку по ссылке
		TextView textView1 = findViewById(R.id.textView1);
		//Вешаем на кнопку слушатель
		textView1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					Context context;
					//Прописываем звук на кнопку
					MediaPlayer md3 = MediaPlayer.create(GameLevelActivity.this, R.raw.press_button);
					md3.start();
					//Прописываем намерение перейти на другое Activity
					Intent intent = new Intent(GameLevelActivity.this, Level1.class);
					startActivity(intent);
					finish();
				} catch (Exception e) {
					e.printStackTrace(); //помогает понять, где возникла фактическая проблема
				}
			}
		});  // Кнопка для перехода на 1 уровень КОНЕЦ
		Log.i(TAG, "Кнопка перехода на 1 уровень");
	}

	// Системная кнопка "Назад" начало
	@Override
	public void onBackPressed() {
		// Начало конструкции try{
		try {
			Intent intent = new Intent(GameLevelActivity.this, MainActivity.class);
			startActivity(intent);
			finish();
		} catch (Exception e) {
			e.printStackTrace(); //помогает понять, где возникла фактическая проблема

		}
		//Конец конструкции }catch
		super.onBackPressed();
		Log.i(TAG, "Сработала системная кнопка назад");
	}
	// Системная кнопка "Назад" конец
}
