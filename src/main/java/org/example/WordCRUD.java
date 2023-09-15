package org.example;
import java.io.*;
import java.nio.Buffer;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class WordCRUD implements ICRUD {

    ArrayList<Word> list = WordData.list;
    Scanner s;
    final String fname = "Dictionary.txt";
    WordCRUD(Scanner s){
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
        deleteItem();
        return 0;
    }

    @Override
    public void selectOne(int id) {
        ArrayList<Integer> idlist = new ArrayList<>();
        int j = 0;
        System.out.println("----------------------");
        for(int i = 0; i < list.size(); i++){
            int level = list.get(i).level;
            if(!(level == id)) continue;
            System.out.print((j + 1) + " ");
            System.out.println(list.get(i).toString());
            idlist.add(i);
            j++;
        }
        System.out.println("----------------------");
    }
    public void levelSelect(){
        System.out.print("=> 원하는 레벨을 넣으세요 ");
        int id = s.nextInt();
        this.selectOne(id);
    }

    public ArrayList<Integer> listAll(String keyword){
        ArrayList<Integer> idlist = new ArrayList<>();
        int j = 0;
        System.out.println("----------------------");
        for(int i = 0; i < list.size(); i++){
            String word = list.get(i).getWord();
            if(!word.contains(keyword)) continue;
            System.out.print((j + 1) + " ");
            System.out.println(list.get(i).toString());
            idlist.add(i);
            j++;
        }
        System.out.println("----------------------");
        return idlist;
    }
    public void listAll(){
        System.out.println("----------------------");
        if(list.isEmpty()){
            System.out.println("단어장이 텅텅 비어 있습니다.나만의 단어장을 채워주세요");
        }
        for(int i = 0; i < list.size(); i++){
            System.out.print((i+1) + " ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("----------------------");
    }
    public void updateItem(){
        System.out.print("=> 수정할 단어을 적으세요. ");
        String keyword = s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("수정할 id 선택하세요! ");
        int id = s.nextInt();
        s.nextLine();
        System.out.print("=> 뜻 입력하세요! ");
        String meaning = s.nextLine();
        Word word = list.get(idlist.get(id - 1));
        word.setMeaning(meaning);
        System.out.println("수정이 완료 되었습니당 ");
    }

    public void deleteItem(){
        System.out.print("=> 삭제 단어을 적으세요");
        String keyword = s.next();
        ArrayList<Integer> idlist = listAll(keyword);
        System.out.print("삭제할 번호 선택! ");
        int id = s.nextInt();

        // 삭제할 건지 안할 건지 여부 확인
        System.out.print("=> 진짜 삭제할 건가요? ");
        String answer = s.nextLine();

        if (answer.equalsIgnoreCase("Y")){
            list.remove(idlist.get(id-1)); // 원하는 id 삭제하기
            System.out.println("=> 삭제가 완료되었습니다.");
        }
        else{
            System.out.println("삭제가 취소되었습니다.");
        }
    }
    // 단어 서치 기능
    public void searchWord(){
        System.out.print("=> 검색할 단어 적으세요 ");
        String word = s.next();
        this.listAll(word);
    }

}
