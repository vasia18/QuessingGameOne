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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


/*
 * Мое первое детское приложение "ВИКТОРИНА"
 * @author avi26
 * @author avi26@mail.ru
 * @version 1.0
 */

public class MainActivity extends AppCompatActivity {

	private static final String TAG = "MyApp";

	private long backPressedTime; // Создаем переменную
	private Toast backToast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Подключаем activity_main к MainActivity.java
		setContentView(R.layout.activity_main);
		// Находим кнопку, которая при нажатии будет переходить на другое Activity
		Button button_start = findViewById(R.id.button_start);
		button_start.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					Context context;
					//подключаем звук на кнопку
					MediaPlayer md_1 = MediaPlayer.create(MainActivity.this,R.raw.press_button );
					md_1.start();

					// Прописываем с какого Activity на какое Activity будет переходить при нажатии на кнопку
					Intent intent = new Intent(MainActivity.this, GameLevelActivity.class);
					startActivity(intent);
					finish();
				} catch (Exception e) {
					e.printStackTrace(); //помогает понять, где возникла фактическая проблема
				} // Конец конструкции
			}
		});

		//Убрать строку состояния на телефоне
		Window w = getWindow();
		w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	}

	// Системная кнопка покинуть приложение НАЧАЛО
	// Ctrl+O
	@Override
	public void onBackPressed() {
		if (backPressedTime + 2000 > System.currentTimeMillis()) {
			backToast.cancel();
			// То выполнится этот код
			super.onBackPressed(); //Эта команда закрывает игру
			return;
		} else { // ИНАЧЕ выполнится другой код
			backToast = Toast.makeText(getBaseContext(), "Нажмите еще раз чтобы выйти", Toast.LENGTH_SHORT);
			backToast.show();
		}
		backPressedTime = System.currentTimeMillis(); // Здесь мы используем переменную которую написал выше.
		Log.i(TAG, "Программа закончила работу");
	}
// Системная кнопка покинуть приоложение КОНЕЦ
}