package com.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClckThreads50 {

    private static int GlobalCount;
    private static int count;
    private static LocalDateTime l = LocalDateTime.now();
    private static final char[] symbols = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
    private static String date = l.getYear() + "-" + l.getMonthValue() + "-" + l.getDayOfMonth();
    private static BufferedWriter f;

    static {
        try {
            f = new BufferedWriter(new FileWriter(new File("E:/CLCKS.RU/" + date + ".txt"), true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static long start = 0;
    // YQ5V4  //   YYcQi
//0-0 1-1 2-2 3-3 4-4 5-5 6-6 7-7 8-8 9-9 A-10
//B-11 C-12 D-13 E-14 F-15 G-16 H-17 I-18 J-19 K-20 L-21 M-22 N-23 O-24 P-25 Q-26 R-27 S-28 T-29 U-30 V-31 W-32 X-33 Y-34 Z-35
//a-36 b-37 c-38 d-39 e-40 f-41 g-42 h-43 i-44 j-45 k-46 l-47 m-48 n-49 o-50 p-51 q-52 r-53 s-54 t-55 u-56 v-57 w-58 x-59 y-60 z-61

    private static boolean skryvat(String s) {
        return !s.equals("Google Документы ‒ бесплатно создавайте и редактируйте документы в Интернете.") && !s.contains("PDisk")
                && !s.equals("Facebook") && !s.equals("РСТ МЕТРОЛОГИЯ") && !s.contains("Ivermectin") && !s.equals("EXPIRENZA")
                && !s.equals("Google Таблицы ‒ бесплатно создавайте и редактируйте таблицы в Интернете.") && !s.contains("Карточка записи")
                && !s.equals("KAТАЛOГ МЕБЕЛИ") && !s.equals("КAТAЛOГ МEБEЛИ") && !s.contains("18+") && !s.toLowerCase().equals("вход") && !s.equals("302 Found")
                && !s.contains("Яндекс.Карты") && !s.equals("Пройди тест на денежное мышление") && !s.contains("گ") && !s.contains("ا")
                && !s.contains("Опрос ИМ- Testograf.ru") && !s.equals("Figma") && !s.contains("Timeweb") && !s.equals("Video") && !s.equals("Подождите секундочку")
                && !s.equals("МТС-Банк") && !s.equals("Index - MerchantNew") && !s.contains("Скажите, доктор…") && !s.contains("Яндекс.Видео")
                && !s.contains("РУСХИТ") && !s.equals(" Google Карты ") && !s.equals("Яндекс.Картинки") && !s.equals("Google Карты")
                && !s.equals("Срочноденьги Заявка") && !s.equals("Best dating worldwide") && !s.contains("Перевод №15322856R82")
                && !s.equals("Яндекс") && !s.equals("МВД РОССИИ: УВЕДОМЛЕНИЕ О ШТРАФЕ") && !s.contains("Один Диск для всех файлов")
                && !s.equals("Страница оплаты") && !s.contains("html") && !s.equals("New phoenix") && !s.contains("Одноклассники")
                && !s.equals("Корзина") && !s.equals("Ru_kitchent at Taplink") && !s.equals("Самолет") && !s.contains("Установка натяжных потолков")
                && !s.contains("Авито") && !s.equals("Оценка курьера") && !s.equals("Добро пожаловать!") && !s.contains("БАРЬЕР")
                && !s.contains("PeoplePass") && !s.equals("axilog.ru - служба доставки") && !s.contains("бесплатно создавайте и редактируйте")
                && !s.equals("QIWI") && !s.equals("Расчёт стоимости полиса ОСАГО онлайн") && !s.contains("потрахаться") && !s.equals("Участие в розыгрыше")
                && !s.equals("Ваш заказ | Вилгуд") && !s.equals("TikTok") && !s.equals("Альфа-Банк") && !s.equals("Loading SGG1")
                && !s.contains("mistery") && !s.equals("Как самозанятым получать бесплатные смены  — Яндекс.Про") && !s.equals("Login • Instagram")
                && !s.contains("xvideo") && !s.contains("ЮMoney") && !s.equals("Оплата") && !s.contains("Оцените уровень сервиса Bungly boo!")
                && !s.equals("") && !s.contains("Линзмастер") && !s.contains("На чём ты спишь?") && !s.contains("Search") && !s.contains("Вход ")
                && !s.equals("Mail.ru: почта, поиск в интернете, новости, игры") &&!s.matches("MOW[A-F0-9]* – Google Диск")
                && !s.matches(".*ideo.*\\.zip - Google Диск") &&!s.equals("Новые отзывы") &&!s.equals("Рассылки")
                && !s.equals("Яндекс — поиск по видео") && !s.equals("Оставьте ваш отзыв")
                && !s.contains("Telegraph") && !s.equals("Короткий URL для всех!") && !s.equals("301 Moved Permanently") && !s.contains("Интим")
                && !s.contains("Ташкент") && !s.equals(" ") && !s.contains("Redirecting...") && !s.contains("Telegram:") && !s.contains("Sign In")
                && !s.equals("Get Laid Tonight") && !s.equals("Ой!") && !s.equals("КэшДрайв") && !s.equals("Faberlic") && !s.equals("Orange data")
                && !s.equals("Google Таблицы ‒ бесплатно создавайте и редактируйте таблицы в Интернете.") && !s.equals("Ru7divany at Taplink")
                && !s.equals("PravSistem.Club") && !s.equals("Warning! | There might be a problem with the requested link") && !s.contains("Untitled")
                && !s.contains("Квартиры свободные") && !s.equals("Статус заказа") && !s.equals("Закрытый мужской клуб") && !s.equals("Google")
                && !s.toLowerCase().matches(".*порн.*") &&!s.endsWith(" - Please Wait...") && !s.equals("Page 9255")
                && !s.matches("MOW.* – Google Диск") && !s.toLowerCase().matches("sex.*") && !s.toLowerCase().matches(".*секс.*")
                && !s.toLowerCase().matches(".*porn.*") && !s.toLowerCase().matches(".*xxx.*") && !s.toLowerCase().matches(".*[0-9]* likes")
                && !s.toLowerCase().matches(".*[0-9]* views") && !s.toLowerCase().matches(".*free video.*") && !s.toLowerCase().matches(".*adult.*")
                && !s.toLowerCase().matches(".*tits.*") && !s.toLowerCase().matches(".*orgasm.*") && !s.equals("Яндекс.Учебник")
                && !s.contains("href.li") && !s.equals("Авторизация") && !s.contains("Бронирование круиза") && !s.contains("Как бухгалтеру начать работать на себя")
                && !s.contains("вход в систему") && !s.contains("expresspay.by") && !s.equals("Заезд бригады") && !s.equals("Запись не найдена") && !s.contains("1st-Original.RU")
                && !s.contains("Информация о банкротах по") && !s.equals("Обратная связь") && !s.equals("Оплата заказа") && !s.equals("Опрос клиентов отдела Сервиса")
                && !s.contains("Родник Алтая") && !s.contains("Оставить отзыв") && !s.equals("Ошибка | ВКонтакте") && !s.equals("Ошибка") && !s.contains("Поиск тур")
                && !s.contains("Ставки на спорт") && !s.contains("sweetmarin.ru") && !s.contains("Травелата") && !s.contains("вашего браузера") && !s.equals("Фото отчет")
                && !s.contains(";&#") && !s.equals("Runtime error!") && !s.equals("Dating Get Naughty!") && !s.equals("Animarender User Account") && !s.contains("ULC")
                ;
    }
    public static void withJsoup(String url) {
        GlobalCount++;
        Document document;
        try {
            document = Jsoup.connect(url).get();
            String title = document.title();
            if (!title.isEmpty() && skryvat(title)) {
                double sec = (double) (System.currentTimeMillis() - start) / 1000;//1 секунда
                double sec2 = (double) (System.currentTimeMillis() - start) % 1000;
                double min = (double) ((System.currentTimeMillis() - start) / 1000) % 60;

                String SECUND = "%d. %s - %s (%d) - %.3f сек. %s\n";
                String MINUTE = "%d. %s - %s (%d) - %.0f мин. и %.0f сек. %s\n";

                LocalDateTime HoursMinutesSeconds = LocalDateTime.now();
                String date2 = HoursMinutesSeconds.getHour() + ":" + HoursMinutesSeconds.getMinute() + ":" + HoursMinutesSeconds.getSecond();


                if (sec < 60) {
                    System.out.printf(SECUND, ++count, url, title, GlobalCount, sec, date2);
                    f.write(String.format(SECUND, count, url, title, GlobalCount, sec, date2));

                } else {
                    System.out.printf(MINUTE, ++count, url, title, GlobalCount, min, sec2, date2);
                    f.write(String.format(MINUTE, count, url, title, GlobalCount, min, sec2, date2));
                }
                f.flush();

                start = System.currentTimeMillis();
                System.gc();
            }
            if (GlobalCount % 100 == 0) {
                System.gc();
            }
        } catch (Exception ignored) {
        }
    }
    public static void clckCod1() { for (int one = 34; one < 62; one++) {/*Y*/for (int two = 26; two < 35; two++) {/*F*/for (int three = 2; three < 62; three++) for (int four = 2; four < 62; four++) for (int five = 0; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } }
        }
    }

    public static void clckCod2() {
        for (int one = 34; one < 62; one++) {//Y
            for (int two = 26; two < 35; two++) {//Q
                for (int three = 2;three < 62; three++) {//
                    for (int four = 2; four < 62; four++) {
                        for (int five = 1; five < 62; five += 50) {
                            String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);
                            withJsoup(url);
                        }
                    }
                }
            }
        }
    }

    public static void clckCod3() {
        for (int one = 34; one < 62; one++) {//W
            for (int two = 26; two < 35; two++) {//
                for (int three = 2;three < 62; three++) {//
                    for (int four = 2; four < 62; four++) {
                        for (int five = 2; five < 62; five += 50) {
                            String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);
                            withJsoup(url);
                        }
                    }
                }
            }
        }
    }

    public static void clckCod4() {
        for (int one = 34; one < 62; one++) {//W
            for (int two = 26; two < 35; two++) {//
                for (int three = 2;three < 62; three++) {//
                    for (int four = 2; four < 62; four++) {
                        for (int five = 3; five < 62; five += 50) {
                            String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);
                            withJsoup(url);
                        }
                    }
                }
            }
        }
    }

    public static void clckCod5() {
        for (int one = 34; one < 62; one++) {//W
            for (int two = 26; two < 35; two++) {//
                for (int three = 2;three < 62; three++) {//
                    for (int four = 2; four < 62; four++) {
                        for (int five = 4; five < 62; five += 50) {
                            String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);
                            withJsoup(url);
                        }
                    }
                }
            }
        }
    }

    public static void clckCod6() {
        for (int one = 34; one < 62; one++) {//W
            for (int two = 26; two < 35; two++) {//
                for (int three = 2;three < 62; three++) {//
                    for (int four = 2; four < 62; four++) {
                        for (int five = 5; five < 62; five += 50) {
                            String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);
                            withJsoup(url);
                        }
                    }
                }
            }
        }
    }

    public static void clckCod7() {
        for (int one = 34; one < 62; one++) {//W
            for (int two = 26; two < 35; two++) {//
                for (int three = 2;three < 62; three++) {//
                    for (int four = 2; four < 62; four++) {
                        for (int five = 6; five < 62; five += 50) {
                            String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);
                            withJsoup(url);
                        }
                    }
                }
            }
        }
    }

    public static void clckCod8() {
        for (int one = 34; one < 62; one++) {//W
            for (int two = 26; two < 35; two++) {//
                for (int three = 2;three < 62; three++) {//
                    for (int four = 2; four < 62; four++) {
                        for (int five = 7; five < 62; five += 50) {
                            String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);
                            withJsoup(url);
                        }
                    }
                }
            }
        }
    }

    public static void clckCod9() {
        for (int one = 34; one < 62; one++) {//W
            for (int two = 26; two < 35; two++) {//
                for (int three = 2;three < 62; three++) {//
                    for (int four = 2; four < 62; four++) {
                        for (int five = 8; five < 62; five += 50) {
                            String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);
                            withJsoup(url);
                        }
                    }
                }
            }
        }
    }

    public static void clckCod10() {
        for (int one = 34; one < 62; one++) {//W
            for (int two = 26; two < 35; two++) {//
                for (int three = 2;three < 62; three++) {//
                    for (int four = 2; four < 62; four++) {
                        for (int five = 9; five < 62; five += 50) {
                            String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);
                            withJsoup(url);
                        }
                    }
                }
            }
        }
    }

    public static void clckCod11() {
        for (int one = 34; one < 62; one++) {//W
            for (int two = 26; two < 35; two++) {//
                for (int three = 2;three < 62; three++) {//
                    for (int four = 2; four < 62; four++) {
                        for (int five = 10; five < 62; five += 50) {
                            String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);
                            withJsoup(url);
                        }
                    }
                }
            }
        }
    }

    public static void clckCod12() {
        for (int one = 34; one < 62; one++) {//W
            for (int two = 26; two < 35; two++) {//
                for (int three = 2;three < 62; three++) {//
                    for (int four = 2; four < 62; four++) {
                        for (int five = 11; five < 62; five += 50) {
                            String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);
                            withJsoup(url);
                        }
                    }
                }
            }
        }
    }

    public static void clckCod13() {
        for (int one = 34; one < 62; one++) {//W
            for (int two = 26; two < 35; two++) {//
                for (int three = 2;three < 62; three++) {//
                    for (int four = 2; four < 62; four++) {
                        for (int five = 12; five < 62; five += 50) {
                            String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);
                            withJsoup(url);
                        }
                    }
                }
            }
        }
    }

    public static void clckCod14() {
        for (int one = 34; one < 62; one++) {//W
            for (int two = 26; two < 35; two++) {//
                for (int three = 2;three < 62; three++) {//
                    for (int four = 2; four < 62; four++) {
                        for (int five = 13; five < 62; five += 50) {
                            String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);
                            withJsoup(url);
                        }
                    }
                }
            }
        }
    }

    public static void clckCod15() {
        for (int one = 34; one < 62; one++) {//W
            for (int two = 26; two < 35; two++) {//
                for (int three = 2;three < 62; three++) {//
                    for (int four = 2; four < 62; four++) {
                        for (int five = 14; five < 62; five += 50) {
                            String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);
                            withJsoup(url);
                        }
                    }
                }
            }
        }
    }

    public static void clckCod16() {
        for (int one = 34; one < 62; one++) {//W
            for (int two = 26; two < 35; two++) {//
                for (int three = 2;three < 62; three++) {//
                    for (int four = 2; four < 62; four++) {
                        for (int five = 15; five < 62; five += 50) {
                            String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);
                            withJsoup(url);
                        }
                    }
                }
            }
        }
    }

    public static void clckCod17() {
        for (int one = 34; one < 62; one++) {//W
            for (int two = 26; two < 35; two++) {//
                for (int three = 2;three < 62; three++) {//
                    for (int four = 2; four < 62; four++) {
                        for (int five = 16; five < 62; five += 50) {
                            String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);
                            withJsoup(url);
                        }
                    }
                }
            }
        }
    }

    public static void clckCod18() {
        for (int one = 34; one < 62; one++) {//W
            for (int two = 26; two < 35; two++) {//
                for (int three = 2;three < 62; three++) {//
                    for (int four = 2; four < 62; four++) {
                        for (int five = 17; five < 62; five += 50) {
                            String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);
                            withJsoup(url);
                        }
                    }
                }
            }
        }
    }

    public static void clckCod19() {
        for (int one = 34; one < 62; one++) {//W
            for (int two = 26; two < 35; two++) {//
                for (int three = 2;three < 62; three++) {//
                    for (int four = 2; four < 62; four++) {
                        for (int five = 18; five < 62; five += 50) {
                            String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);
                            withJsoup(url);
                        }
                    }
                }
            }
        }
    }

    public static void clckCod20() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 19; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    
    public static void clckCod21() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 20; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod22() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 21; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod23() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 22; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod24() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 23; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod25() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 24; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod26() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 25; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod27() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 26; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod28() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 27; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod29() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 28; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod30() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 29; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    
    public static void clckCod31() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 30; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod32() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 31; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod33() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 32; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod34() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 33; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod35() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 34; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod36() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 35; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod37() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 36; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod38() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 37; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod39() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 38; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod40() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 39; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    
    public static void clckCod41() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 40; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod42() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 41; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod43() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 42; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod44() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 43; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod45() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 44; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod46() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 45; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod47() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 46; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod48() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 47; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod49() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 48; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }
    public static void clckCod50() { for (int one = 34; one < 62; one++) {/*W*/for (int two = 26; two < 35; two++) {/**/for (int three = 2;three < 62; three++) {/**/for (int four = 2; four < 62; four++) for (int five = 49; five < 62; five += 50) { String url = String.format("https://clck.ru/%c%c%c%c%c", symbols[one], symbols[two], symbols[three], symbols[four], symbols[five]);withJsoup(url); } } } } }


    public static void main(String[] args) {
        System.out.println("Работу начал...");
        int kolvoPotokov = 50;//самое интересное, здесь по умолчанию стоит 50 потоков!
        ExecutorService service = Executors.newFixedThreadPool(kolvoPotokov);//с помощью ExecutorService создаем 50 потоков

        service.submit(new Thread(ClckThreads50::clckCod1));
        service.submit(new Thread(ClckThreads50::clckCod2));
        service.submit(new Thread(ClckThreads50::clckCod3));
        service.submit(new Thread(ClckThreads50::clckCod4));
        service.submit(new Thread(ClckThreads50::clckCod5));
        service.submit(new Thread(ClckThreads50::clckCod6));
        service.submit(new Thread(ClckThreads50::clckCod7));
        service.submit(new Thread(ClckThreads50::clckCod8));
        service.submit(new Thread(ClckThreads50::clckCod9));
        service.submit(new Thread(ClckThreads50::clckCod10));

        service.submit(new Thread(ClckThreads50::clckCod11));
        service.submit(new Thread(ClckThreads50::clckCod12));
        service.submit(new Thread(ClckThreads50::clckCod13));
        service.submit(new Thread(ClckThreads50::clckCod14));
        service.submit(new Thread(ClckThreads50::clckCod15));
        service.submit(new Thread(ClckThreads50::clckCod16));
        service.submit(new Thread(ClckThreads50::clckCod17));
        service.submit(new Thread(ClckThreads50::clckCod18));
        service.submit(new Thread(ClckThreads50::clckCod19));
        service.submit(new Thread(ClckThreads50::clckCod20));

        service.submit(new Thread(ClckThreads50::clckCod21));
        service.submit(new Thread(ClckThreads50::clckCod22));
        service.submit(new Thread(ClckThreads50::clckCod23));
        service.submit(new Thread(ClckThreads50::clckCod24));
        service.submit(new Thread(ClckThreads50::clckCod25));
        service.submit(new Thread(ClckThreads50::clckCod26));
        service.submit(new Thread(ClckThreads50::clckCod27));
        service.submit(new Thread(ClckThreads50::clckCod28));
        service.submit(new Thread(ClckThreads50::clckCod29));
        service.submit(new Thread(ClckThreads50::clckCod30));

        service.submit(new Thread(ClckThreads50::clckCod31));
        service.submit(new Thread(ClckThreads50::clckCod32));
        service.submit(new Thread(ClckThreads50::clckCod33));
        service.submit(new Thread(ClckThreads50::clckCod34));
        service.submit(new Thread(ClckThreads50::clckCod35));
        service.submit(new Thread(ClckThreads50::clckCod36));
        service.submit(new Thread(ClckThreads50::clckCod37));
        service.submit(new Thread(ClckThreads50::clckCod38));
        service.submit(new Thread(ClckThreads50::clckCod39));
        service.submit(new Thread(ClckThreads50::clckCod40));

        service.submit(new Thread(ClckThreads50::clckCod41));
        service.submit(new Thread(ClckThreads50::clckCod42));
        service.submit(new Thread(ClckThreads50::clckCod43));
        service.submit(new Thread(ClckThreads50::clckCod44));
        service.submit(new Thread(ClckThreads50::clckCod45));
        service.submit(new Thread(ClckThreads50::clckCod46));
        service.submit(new Thread(ClckThreads50::clckCod47));
        service.submit(new Thread(ClckThreads50::clckCod48));
        service.submit(new Thread(ClckThreads50::clckCod49));
        service.submit(new Thread(ClckThreads50::clckCod50));

        service.shutdown();

    }
}
