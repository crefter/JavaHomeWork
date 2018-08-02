public class PhraseOMatic {
    public static void main(String[] args) {
        String[] wordOneList = {"круглосуточный","фронтэнд","Взаимный",
                                "Кек","Лол","Чебурек","Орбидол","умная",
                                "хорошая","любимая","прекрасныая","ХЫ","ДЫА",
                                "Здарова","Тварына"};
        String[] wordTwoList = {"пока","привет","до свидания","как",
                                "будьте","жить","здорово","прекрасно",
                                "хорошо","ы","здравствуйте"};
        String[] wordListThree = {"дорогая","прекрасная","лучшая",
                                  "смелая","очаровательная","волшебная"
                                  ,"чудесная","Таня","КЭК","КАК","КЫК"};

        int oneLength = wordOneList.length;
        int twoLength = wordTwoList.length;
        int threeLength = wordListThree.length;

        int rand1 = (int) (Math.random() * oneLength);
        int rand2 = (int) (Math.random() * twoLength);
        int rand3 = (int) (Math.random() * threeLength);

        String phrase = wordOneList[rand1] + " " + wordTwoList[rand2] + " " + wordListThree[rand3];
        System.out.println("Всё, что мне нужно - это " + phrase);
    }
}
