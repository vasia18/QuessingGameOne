package ru.vsebudet_top;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevelActvity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gamelevels);

		//Убрать строку состояния на телефоне
		Window w = getWindow();
		w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		Button button_back = (Button) findViewById(R.id.button_back);
		button_back.setOnClickListener(new View.OnClickListener() {// Вешаем слушатель на кнопку.
			@Override
			public void onClick(View v) {
				// Здесь будет команда для кнопки.
				// Начало конструкции
				try {
					Intent intent = new Intent(GameLevelActvity.this, MainActivity.class);
					startActivity(intent);
					finish();
				} catch (Exception e) {
				}
			}


		});
	}

	// Системная кнопка НАЧАЛО

	@Override
	public void onBackPressed() {
		// Начало конструкции try{
		try {
			Intent intent = new Intent(GameLevelActvity.this, MainActivity.class);
			startActivity(intent);
			finish();
		} catch (Exception e) {
		}
		//Конец конструкции }catch
		super.onBackPressed();
	}

	// Системная кнопка КОНЕЦ
}