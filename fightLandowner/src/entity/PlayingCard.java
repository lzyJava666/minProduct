package entity;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 扑克牌类
 */
public class PlayingCard {
    //创建一个集合来存牌
    private ArrayList<String> pokers;
    //创建一个集合用来存储索引
    private ArrayList<Integer> indexs;

    public ArrayList<String> getPokers() {
        return pokers;
    }

    public ArrayList<Integer> getIndexs() {
        return indexs;
    }

    /**
     * 初始化扑克牌
     */
    public PlayingCard() {
        String[] colors = {"♠", "♥", "♦", "♣"};
        String[] numbers = {"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
        pokers = new ArrayList<>();
        indexs = new ArrayList<>();
        int index = 0;
        pokers.add("大王");
        indexs.add(index++);
        pokers.add("小王");
        indexs.add(index++);
        StringBuffer str;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < colors.length; j++) {
                str = new StringBuffer();
                str.append(colors[j]).append(numbers[i]);
                pokers.add(str.toString());
                indexs.add(index++);
            }
        }
    }

    /**
     *  洗牌
     */
    public void washPlaying(){
        Collections.shuffle(indexs);
    }
}
