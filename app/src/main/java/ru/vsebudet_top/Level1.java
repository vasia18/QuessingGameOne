package ru.vsebudet_top;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.Logger;

public class Level1 extends AppCompatActivity {

	public static final String TAG = "MyApp";
	Dialog dialog;

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.universal);

		//создаем переменную text_levels
		TextView text_levels = findViewById(R.id.text_levels);
		text_levels.setText(R.string.level1); //установили текст

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
		Log.i(TAG, "развернуть игру на весь экран для записи в журнале");
		// развернуть игру на весь экран - КОНЕЦ

		//Вызов диалогового окна в начале игры
		dialog = new Dialog(this); // сздаем новое диалоговое окно
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);  //  скрываем заголовок диалогового окна
		dialog.setContentView(R.layout.previewdialog);  // путь к макету диалогового окна
		dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон диалогового окна
		dialog.setCancelable(false);  // окно нельзя закрыть системной кнопкой назад

		// Кнопка которая закрывает диалоговое окно -начало
		TextView btn_close = (TextView) dialog.findViewById(R.id.btn_close);
		btn_close.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//обрабатываем нажатие кнопки - начало
				try {
					//Вернутся назад к выбору уровня - начало
					Intent intent = new Intent(Level1.this, GameLevelActivity.class); //создали намеренья для перехода
					startActivity(intent); //старт намеренья
					finish(); //закрыть этот класс
//Вернутся назад к выбору уровня - конец
					Log.i(TAG, "Сработала кнопка вернутся к выбору уровня");
				} catch (Exception e) {
					e.printStackTrace();
					Log.e(TAG, "получено исключение", e);
					//Здесь будет команда команда (будет всплывать сообщение из за которой програма зделала ошибку) - начало
					Toast.makeText(Level1.this, "Тестовое сообщение окнопка сработала", Toast.LENGTH_SHORT).show();
					//Здесь будет команда команда (будет всплывать сообщение из за которой програма зделала ошибку) - конец
				}
				dialog.dismiss();//закрываем диалоговое окно
				//обрабатываем нажатие кнопки = конец
			}
		});
		// Кнопка которая закрывает диалоговое окно - конец

		//кнопка "Продолжить" - начало
		Button btn_continue = (Button) dialog.findViewById(R.id.btn_continue);
		btn_continue.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.dismiss(); //когда нажимают на кнопку продолжить, окно закрывается
			}
		});
		//кнопка "Продолжить" - конец
		dialog.show(); // показать диалоговое окно

		//кнопка "назад" - начало
		Button button_back_1 = (Button) findViewById(R.id.button_back_1);
		button_back_1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//обрабатываем нажатие кнопки - начало
				try {
					//вернутся назад к выбору уровня - начало
					Intent intent = new Intent(Level1.this, GameLevelActivity.class); //создали намерение для перехода на другой уровень
					startActivity(intent); //старт намерения
					finish(); //закрыть этот класс
					//вернутся назад к выбору уровня - конец
					//обрабатываем нажатие кнопки - конец
				} catch (Exception e) {
					e.printStackTrace(); //помогает понять, где возникла фактическая проблема
					// код на случай если кнопка не будет работать - начало
					Log.e(TAG, "Получено исключение", e);
					// код на случай если кнопка не будет работать - конец
				}
			}
		});
		//кнопка "назад" - конец
	}
	//системная кнопка "назад" - начало

	@Override
	public void onBackPressed() {
		//Ctrl+O
		super.onBackPressed();
		try {
			//вернутся назад к выбору уровня - начало
			Intent intent = new Intent(Level1.this, GameLevelActivity.class); //создали намерение для перехода на другой уровень
			startActivity(intent); //старт намерения
			finish(); //закрыть этот класс
			//вернутся назад к выбору уровня - конец
			//обрабатываем нажатие кнопки - конец
		} catch (Exception e) {
			e.printStackTrace(); //помогает понять, где возникла фактическая проблема
			// код на случай если кнопка не будет работать - начало
			Log.e(TAG, "Получено исключение", e);
			// код на случай если кнопка не будет работать - конец

			//системная кнопка "назад" - назад
		}
	}
}