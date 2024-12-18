package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText angleInput;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация UI-элементов
        angleInput = findViewById(R.id.angleInput);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        // Установка слушателя на кнопку
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCosine();
            }
        });
    }

    // Метод для вычисления косинуса
    private void calculateCosine() {
        String angleText = angleInput.getText().toString();

        // Проверяем, не пустое ли поле ввода
        if (angleText.isEmpty()) {
            Toast.makeText(this, "Введите значение угла!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            // Преобразуем текст в число
            double angleDegrees = Double.parseDouble(angleText);

            // Преобразуем градусы в радианы
            double angleRadians = Math.toRadians(angleDegrees);

            // Вычисляем косинус
            double cosineValue = Math.cos(angleRadians);

            // Отображаем результат
            resultTextView.setText(String.format("cos(%.1f°) = %.5f", angleDegrees, cosineValue));
        } catch (NumberFormatException e) {
            // Обрабатываем ошибку ввода
            Toast.makeText(this, "Некорректный ввод!", Toast.LENGTH_SHORT).show();
        }
    }
}