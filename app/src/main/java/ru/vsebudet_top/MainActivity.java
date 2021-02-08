package ru.vsebudet_top;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

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
							GameLevelActvity.class);
					startActivity(intent);
					finish();
				} catch (Exception e) {
				} // Конец конструкции
			}
		});


		//Убрать строку состояния на телефоне
		Window w = getWindow();
		w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

	}

}