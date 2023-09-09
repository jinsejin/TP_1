package org.example;
import java.io.BufferedReader;
import java.nio.Buffer;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD {
    //
    ArrayList<Word> list;
    Scanner s;
    WordCRUD(){
        // WordCRUd 값이 할당될때 Text에 있는 정보를 List에 담아 정보를 계속 체크해주어야 된다

    }
    WordCRUD(Scanner s){
        list = new ArrayList<>();
        this.s = s;
    }
    @Override
    public Object add() {
        System.out.println("=> 난이도(1,2,3)입력 & 새 단어 입력 : ");
        int level = s.nextInt();
        String word = s.nextLine();
        System.out.println("뜻 입력 : ");
        String meaning = s.nextLine();
        return new Word(0,level, word, meaning);
    }
    public void addword(){
        Word one = (Word)add();
        list.add(one);
        System.out.println("단어장에 추가 되었습니다.");
    }

    @Override
    public int update(Object obj) {
        return 0;
    }

    @Override
    public int delete(Object obj) {
        return 0;
    }

    @Override
    public void selectOne(int id) {

    }
    public void listAll(){
        System.out.println("----------------------");
        if(list.isEmpty()){
            System.out.println("단어장이 텅텅 비어 있습니다.나만의 단어장을 채워주세요");
        }
        for(int i = 0; i <list.size(); i++){
            System.out.print(i+1);
            System.out.println(list.get(i).toString());
        }
    }
}
