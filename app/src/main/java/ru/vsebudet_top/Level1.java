package ru.vsebudet_top;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class Level1 extends AppCompatActivity {

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.universal);

		// Определяем в коде img_left_rec что бы потом книму обратится
		final ImageView img_left_rec = findViewById(R.id.img_left_rec);
		// код который скругляет углы Левой картинки
		img_left_rec.setClipToOutline(true);


		// Определяем в коде img_right_rec что бы потом книму обратится
		final ImageView img_right_rec = findViewById(R.id.img_right_rec);
		// Код который скругляет углы правой картинки
		img_right_rec.setClipToOutline(true);


		// Разверуть игру на весь экран - НАЧАЛО
		Window w = getWindow();
		w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
		// развернуть игру на весь экран - КОНЕЦ
	}
}