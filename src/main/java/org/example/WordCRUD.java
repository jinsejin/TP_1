package org.example;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class WordCRUD implements ICRUD {
    //
    ArrayList<Word> list;
    Scanner s;
    final String fname = "Dictionaly.txt";
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
        updateItem();
        return 0;
    }

    @Override
    public int delete(Object obj) {
        deleteItem();
        return 0;
    }

    @Override
    public void selectOne(int id) {

    }

    public ArrayList<Integer> listAll(String keyword){
        ArrayList<Integer> idlist = new ArrayList<>();
        int j = 0;
        System.out.println("----------------------");
        for(int i = 0; i < list.size(); i++){
            String word = list.get(i).getWord();
            if(word.contains(keyword)) continue;
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
        System.out.print("=> 수정할 단어을 적으세요 ");
        String keyword = s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("수정할 id 선택하세요! ");
        int id = s.nextInt();
        s.nextLine();
        System.out.print("=> 뜻 입력하세요! ");
        String meaning = s.nextLine();
        Word word = list.get(idlist.get(id - 1));
        word.setMeaning(meaning);
        System.out.println("수정이 완료 되었습니당");
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
    public void loadfile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line;

            br.close();
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
