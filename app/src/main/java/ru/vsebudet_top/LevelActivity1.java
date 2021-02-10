package ru.vsebudet_top;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

class LevelActivity1 extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Подключаем LevelActivity.java к universal.xml.java
		setContentView(R.layout.universal);


		// Развернуть игру на весь экран - НАЧАЛО
		Window w = getWindow();
		w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
		// развернуть игру на вечь экран - КОНЕЦ
	}
}
