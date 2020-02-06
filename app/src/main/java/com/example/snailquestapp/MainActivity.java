package com.example.snailquestapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Situation start_story;
    Situation current_situation;
    TextView output;
    Button[] b = new Button[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start_story = new Situation(
                "ЖИЛЬЕ",
                "Вы можете выбрать место проживания\n"
                        + "(1)уползете от всех в сельскую местность\n"
                        + "(2)будете тусить в центре города\n"
                        + "(3)поселитесь в спальном районе",
                3, 0, 0, 0);

        start_story.direction[0] = new Situation(
                "СМЕРТУШКА",
                "Неудачное начало, вас скушала пролетающая птичка!",
                0, -100, -100, -100);

        start_story.direction[1] = new Situation(
                "ЦЕНТР ГОРОДА",
                "Ну что, с жильем определились,"
                        + "теперь нужно подумать о работе\n"
                        + "(1)погуглить вакансии\n"
                        + "(2)дать объявление в газете\n"
                        + "(3)попытаться раскрутить свою страничку в Улиткограме",
                3, 0, 0, 0);

        start_story.direction[1].direction[0] = new Situation(
                "ПОИСК РАБОТЫ",
                "Вам повезло, теперь вы успешный фрилансер\n"
                        +"Чем вы займетесь сегодня вечером? \n"
                        + "(1)пойдете на выставку авангардистов\n"
                        + "(2)поспите дома\n"
                        + "(3)погуляете по вечернему городу",
                3, 50, 20, 30);
        current_situation = start_story;

        start_story.direction[1].direction[0].direction[0] = new Situation(
                "ДОСУГ",
                "Вы определенно ценитель искусства!\n"
                        +"Вы вышли из галереи, увидели красиво украшенный к Новому году город.\n"
                        +"И теперь вам осталось решить? \n"
                        + "(1)погулять по центру\n"
                        + "(2)поехать домой\n"
                        + "(3)посидеть в кафе"
                ,3, 0, 0, 0);
        current_situation = start_story;

        start_story.direction[1].direction[0].direction[0].direction[0] = new Situation(
                "ПОСЛЕ ВЫСТАВКИ",
                "Это было неудачное решение.\n"
                        +"Вас растоптала толпа иностранных улиток-туристов.",
                0, -150, -120, -130);
        current_situation = start_story;

        start_story.direction[1].direction[0].direction[0].direction[1] = new Situation(
                "ПОСЛЕ ВЫСТАВКИ",
                "Вы благополучно доехали до дома.\n"
                        +"Зашли в свое жилище и...\n"
                        + "Но это уже совсем другая история...",
                0, 0, 10, 0);
        current_situation = start_story;

        start_story.direction[1].direction[0].direction[0].direction[2] = new Situation(
                "ПОСЛЕ ВЫСТАВКИ",
                "Вы сидите в уютной кафешке.\n"
                        +"И вдруг заходит он/она (улитки гермафродиты, к слову).\n"
                        + "Продолжение следует...",
                0, 0, 10, 20);
        current_situation = start_story;

        start_story.direction[1].direction[0].direction[1] = new Situation(
                "ДОСУГ",
                "Соседи решили начать делать ремонт.\n"
                        +"Вам так и не удалось уснуть, вы решили посмотреть фильмец."
                        +"Что будете смотреть? \n"
                        + "(1)Хатико\n"
                        + "(2)Рик и Морти\n"
                        + "(3)Жмурки",
                3, 0, 10, 0);
        current_situation = start_story;

        start_story.direction[1].direction[0].direction[1].direction[0] = new Situation(
                "ПРОСМОТР",
                "Вы оказались очень сентиментальной душенькой.\n"
                        +"Улитки очень легко захлебываются, особенно в собственных слезах...",
                0, -100, -110, -100);
        current_situation = start_story;

        start_story.direction[1].direction[0].direction[1].direction[1] = new Situation(
                "ПРОСМОТР",
                "Вы классно проводили время.\n"
                        +"Но тут просмор прервал телефонный звонок.\n"
                        + "Вы подняли трубку и...",
                0, 0, 10, 0);
        current_situation = start_story;

        start_story.direction[1].direction[0].direction[1].direction[2] = new Situation(
                "ПРОСМОТР",
                "Соседи наали совсем ожесточенно что-то сверлить.\n"
                        +"Вы решили пойти разобраться.\n"
                        + "Вы пожалели об этом...",
                0, 0, -20, 0);
        current_situation = start_story;

        start_story.direction[1].direction[0].direction[2] = new Situation(
                "ДОСУГ",
                "Весь центр украшен к нововгодним праздникам,\n"
                        +"Вам удалось выжить в толпах туристов, однако\n"
                        +"прогулка вас не очень порадовала,\n и вы в скором времени"
                        +"вернулись к себе домой.\n"
                        + "Чем займетесь теперь?"
                        +"(1)Заварите чай и позвоните другу.\n"
                        +"(2)Устроите мелкую уборку.\n"
                        +"(3)Ляжете спать пораньше.",
                3, 0, -10, 0);
        current_situation = start_story;

        start_story.direction[1].direction[0].direction[1].direction[0] = new Situation(
                "ДОМА",
                "Заварив, душистый, пряный чай, вы жмете на вызов."
                        +"Друг поднимает трубку, вы с первых секунд разговора понимаете,\n"
                        + "что что-то проиозошло...",
                0, 0, -10, 0);
        current_situation = start_story;

        start_story.direction[1].direction[0].direction[1].direction[1] = new Situation(
                "ДОМА",
                "Вы увлеклись процессом."
                        +"Неожиданно для себя вы находите коробочку,\n"
                        + "открываете ее.\n"
                        + "Содержимое вас поразило...",
                0, 0, 10, 10);
        current_situation = start_story;

        start_story.direction[1].direction[0].direction[1].direction[2] = new Situation(
                "ДОМА",
                "Этой ночью случилось невообразимое...\n"
                        +"Продолжение следует...",
                0, 0, -10, -10);
        current_situation = start_story;

        start_story.direction[1].direction[1] = new Situation(
                "ПОИСК РАБОТЫ",
                "Увы, ваше развитие отстает даже за улитками\n"
                        +"Вы опустились на дно и спились",
                0, -100, -100, -100);
        current_situation = start_story;

        start_story.direction[1].direction[2] = new Situation(
                "ПОИСК РАБОТЫ",
                "Вы зарегались, но теперь пришло время решить,\n"
                        + "о чем же будет ваш контент\n"
                        +"(1)Вы хорошо рисуете, будете делиться своим творчеством\n"
                        +"(2)Будете снимать бесконеные сторис, определенно наполненые очень глубоким смыслом\n"
                        +"(3)Кулинарный блог, why not?",
                3, 0, 10, 5);
        current_situation = start_story;

        start_story.direction[1].direction[2].direction[0] = new Situation(
                "КОНТЕНТ",
                "Вам удалось добиться успеха, улиткам нравится то, что вы делаете."
                        + "Вы рисуете на заказ, получая от этого удовольствие"
                ,0, 30, 10, 30);
        current_situation = start_story;

        start_story.direction[1].direction[2].direction[1] = new Situation(
                "КОНТЕНТ",
                "Никто не оценил ваших стараний"
                        + "Нужно напрячь свое скопление ганглиев и прудумать"
                        + "что-то еще"
                ,0, -50, -70, -40);
        current_situation = start_story;

        start_story.direction[1].direction[2].direction[2] = new Situation(
                "КОНТЕНТ",
                "Вы регулярно заливаете рецептики, покупаете рекламу и идете к успеху."
                        + "Даже продаете свои инфопродукты"
                ,0, 20, 20, 30);
        current_situation = start_story;

        start_story.direction[2] = new Situation(
                "СПАЛЬНЫЙ РАЙОН",
                "Ну что, с жильем определились,"
                        + "теперь нужно подумать о работе\n"
                        + "(1)погуглить вакансии\n"
                        + "(2)дать объявление в газете\n"
                        + "(3)попытаться раскрутить свою страничку в Улиткограме",
                3, 0, 50, 0);
        current_situation = start_story;
        start_story.direction[2].direction[0] = new Situation(
                "ПОИСК РАБОТЫ",
                "Теперь вы стали уликой - офисным планктоном"
                        +"Чем вы хотите заняться после тяжелого рабочего дня\n"
                        + "(1)пойти в зал\n"
                        + "(2)смотреть дома сериальчики, обрастая жирком\n"
                        + "(3)зачем вообще уходить с работы?",
                3, 0, 0, 0);
        current_situation = start_story;

        start_story.direction[2].direction[0].direction[0] = new Situation(
                "ПОСЛЕ ЗАЛА",
                "Вы сбросили накопившееся напряжение, пришли домой.\n"
                        +"Настроение на высоте.\n"
                        + "Чем займетесь теперь?\n"
                        +"(1)Заварите чай и позвоните другу.\n"
                        +"(2)Устроите мелкую уборку.\n"
                        +"(3)Ляжете спать пораньше."
                ,3, 0, 40, 0);
        current_situation = start_story;

        start_story.direction[2].direction[0].direction[0].direction[0] = new Situation(
                "ДОМА",
                "Заварив, душистый, пряный чай, вы жмете на вызов."
                        +"Друг поднимает трубку, вы с первых секунд разговора понимаете,\n"
                        + "что что-то проиозошло...",
                0, 0, -10, 0);
        current_situation = start_story;

        start_story.direction[2].direction[0].direction[0].direction[1] = new Situation(
                "ДОМА",
                "Вы увлеклись процессом.\n"
                        +"Неожиданно для себя вы находите коробочку,\n"
                        + "открываете ее.\n"
                        + "Содержимое вас поразило...",
                0, 0, 10, 20);
        current_situation = start_story;

        start_story.direction[2].direction[0].direction[0].direction[2] = new Situation(
                "ДОМА",
                "Этой ночью случилось невообразимое...\n"
                        +"Продолжение следует...",
                0, 0, 10, 0);
        current_situation = start_story;

        start_story.direction[2].direction[0].direction[1] = new Situation(
                "ДОСУГ",
                "Однаковы вы крепко заснули.\n"
                        +"Вам приснился очень любопытный сон",
                0, 10, 10, 10);
        current_situation = start_story;

        start_story.direction[2].direction[0].direction[2] = new Situation(
                "ДОСУГ",
                "Ваш организм не выдржал этой безумной идеи.\n"
                        +"Он пал смертью храбрых!",
                0, -100, -100, -100);

        current_situation = start_story;
        start_story.direction[2].direction[1] = new Situation(
                "ПОИСК РАБОТЫ",
                "Увы, ваше развитие отстает даже за улитками\n"
                        +"Вы опустились на дно и спились",
                0, -100, -100, -100);
        current_situation = start_story;

        start_story.direction[2].direction[2] = new Situation(
                "ПОИСК РАБОТЫ",
                "Вам повезло, теперь вы успешный блогер",
                0, 50, 50, 50);
        current_situation = start_story;
        output = findViewById(R.id.output);
        current_situation = start_story;
        b[0] = findViewById(R.id.button1);
        b[1] = findViewById(R.id.button2);
        b[2] = findViewById(R.id.button3);
        b[0].setOnClickListener(new QuestListner(this, 0));
        b[1].setOnClickListener(new QuestListner(this, 1));
        b[2].setOnClickListener(new QuestListner(this, 2));
        output.setText(start_story.subject+ "\n" + current_situation.text );
    }
    public void go(int num) {
        if (num <= current_situation.direction.length)
            current_situation = current_situation.direction[num - 1];
        else
            System.out.println("Вы можете выбирать из "
                    + current_situation.direction.length + " вариантов");
    }

    public boolean isEnd() {
        return current_situation.direction.length == 0;
    }

    public void answer(int num) {
        current_situation = current_situation.direction[num];
        output.setText(current_situation.subject + "\n" + current_situation.text);
    }
}
