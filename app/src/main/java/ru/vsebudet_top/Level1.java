package ru.vsebudet_top;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class Level1 extends AppCompatActivity {

	Dialog dialog;

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

		//Вызов диалогового окна в начале игры
		dialog = new Dialog(this); // сздаем новое диалоговое окно
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);  //  скрываем заголовок диалогового окна
		dialog.setContentView(R.layout.previewdialog);  // путь к макету диалогового окна
		dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон диалогового окна
		dialog.setCancelable(false);  // окно нельзя закрыть системной кнопкой назад

		// Кнопка которая закрывает диалоговое окно -начало
		TextView btnclose = (TextView) dialog.findViewById(R.id.btn_close);
		btnclose.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//обрабатываем нажатие кнопки - начало
				try {
					//Вернутся назад к выбору уровня - начало
					Intent intent = new Intent(Level1.this, GameLevelActivity.class); //создали намеренья для перехода
					startActivity(intent); //старт намеренья
					finish(); //закрыть этот класс
//Вернутся назад к выбору уровня - конец
				} catch (Exception e) {
					//Здесь кода небудет (команда из за которой програма зделала ошибку )
				}
				dialog.dismiss();//закрываем диалоговое окно
				//обрабатываем нажатие кнопки = конец
			}
		});
		// Кнопка которая закрывает диалоговое окно - конец

		//кнопка "Продолжить" - начало

		//кнопка "Продолжить" - конец


		dialog.show(); // показать диалоговое окно

	}
}