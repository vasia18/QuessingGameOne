package ru.vsebudet_top;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	private long backPressedTime; // Создаем переменную
	private Toast backToast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); //Подключаем activity_main к MainActivity.java
		Button button_start = findViewById(R.id.button_start); // Находим кнопку, которая при нажатии будет переходить на другое Activity
		button_start.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					// Прописываем с какого Activity на какое Activity будет переходить при нажатии на кнопку
					Intent intent = new Intent(MainActivity.this,
							GameLevelActivity.class);
					startActivity(intent);
					finish();
				} catch (Exception e) {
					e.printStackTrace();
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
	}
// Системная кнопка покинуть приоложение КОНЕЦ
}