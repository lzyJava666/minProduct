package entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 斗地主类
 */
public class FightLandowner {
    //存放玩家类
    private Number[] numbers;

    public FightLandowner() {
        numbers = new Number[3];
    }

    /**
     * 游戏开始按钮
     */
    public void run() {
        begin();
        System.out.print("请选择：");
        Scanner in = new Scanner(System.in);
        int type = in.nextInt();
        while (type!=-999) {
            switch (type) {
                case 1: {
                    begin1();
                    begin();
                    type = in.nextInt();
                }
                break;
                case 2: {
                    begin2();
                    type=-999;
                }
                break;
                default: {
                    System.exit(0);
                }
            }
        }
    }

    /**
     * 开始游戏
     */
    private void begin() {
        System.out.println("***************************");
        System.out.println("*******   斗地主    ********");
        System.out.println("*******1、玩家进场 *********");
        System.out.println("*******2、随机发牌 *********");
        System.out.println("*******0、退出游戏 *********");
        System.out.println("***************************");
    }


    //玩家进场
    public void begin1() {
        Scanner in = new Scanner(System.in);
        String name;
        Number number;
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入第" + i + "个玩家名：");
            name = in.nextLine();
            number = new Number(name, "农民");
            numbers[i]=number;
        }
        System.out.println("--------玩家已全部入场-----------");
    }

    //发牌
    public void begin2() {
        //初始化一副扑克牌
        PlayingCard playingCard = new PlayingCard();
        //洗牌
        playingCard.washPlaying();
        /*创建四个集合，三个用来存储玩家的牌，一个用来存储底牌*/
        ArrayList<Integer> name1 = new ArrayList<>();
        ArrayList<Integer> name2 = new ArrayList<>();
        ArrayList<Integer> name0 = new ArrayList<>();
        ArrayList<Integer> Dipai = new ArrayList<>();
        ArrayList<Integer> indexs = playingCard.getIndexs();
        //        /*随机抽一张明牌，不包括3张底牌*/
        double mp = (int) (Math.random() * 51 + 3); //随机生成 [3~54)
        for (int i = 0; i < indexs.size(); i++) {
            //前3张为底牌
            if (i < 3) {
                Dipai.add(indexs.get(i));
                continue;
            }
            switch (i % 3) {
                case 1: {
                    if (i == mp) {
                        //找到地主
                        numbers[1].setType("地主");
                        for (int j = 0; j < Dipai.size(); j++) {
                            name1.add(indexs.get(j));
                        }
                    }
                    name1.add(indexs.get(i));
                }
                break;
                case 2: {
                    if (i == mp) {
                        //找到地主
                        numbers[2].setType("地主");
                        for (int j = 0; j < Dipai.size(); j++) {
                            name2.add(indexs.get(j));
                        }
                    }
                    name2.add(indexs.get(i));
                }
                break;
                case 0: {
                    if (i == mp) {
                        //找到地主
                        numbers[0].setType("地主");
                        for (int j = 0; j < Dipai.size(); j++) {
                            name0.add(indexs.get(j));
                        }
                    }
                    name0.add(indexs.get(i));
                }
                break;
            }
        }

        //排序每个玩家的牌的索引
        Collections.sort(name1);
        Collections.sort(name2);
        Collections.sort(name0);

        lookPokers(name0, 0, playingCard.getPokers());
        lookPokers(name1, 1, playingCard.getPokers());
        lookPokers(name2, 2, playingCard.getPokers());

    }

    //查看牌
    private void lookPokers(ArrayList<Integer> name, int i, ArrayList<String> pokers) {
        System.out.println("身份：" + numbers[i].getType() + "  用户:" + numbers[i].getName());
        System.out.print("牌为：");
        for (Integer j : name) {
            System.out.print(pokers.get(j)+" ");
        }
        System.out.println();
    }


    public Number[] getNumbers() {
        return numbers;
    }

    public void setNumbers(Number[] numbers) {
        this.numbers = numbers;
    }
}
