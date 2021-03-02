package ru.vsebudet_top;

import android.content.Intent;
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

		ImageButton button_back = findViewById(R.id.button_back);
		button_back.setOnClickListener(new View.OnClickListener() {  // Вешаем слушатель на кнопку.
			@Override
			public void onClick(View v) {
				// Здесь будет команда для кнопки.
				// Начало конструкции
				try {
					Intent intent = new Intent(GameLevelActivity.this, MainActivity.class);
					startActivity(intent);
					finish();
				} catch (Exception e) {
					e.printStackTrace();
				}
				Log.i(TAG, "Сработала кнопка назад с GameLevelActivity на MainActivity");
			}
		});
		//Кнопка для перехода на 1 уровень НАЧАЛО
		TextView textView1 = findViewById(R.id.textView1);
		textView1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
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
