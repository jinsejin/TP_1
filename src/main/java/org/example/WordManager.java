package org.example;
import java.util.Scanner;

public class WordManager {
    Scanner s = new Scanner(System.in);
    WordCRUD wordcrud;
    UsingFileIO savefile;
    WordManager(){
        wordcrud = new WordCRUD(s);
        savefile = new UsingFileIO(s);
    }
    public int menu(){
        System.out.print(" *** 영단어 마스터 *** \n"
                + "****************** \n"
                + "1. 모든 단어 보기 \n"
                + "2. 수준별 단어 보기 \n"
                + "3. 단어 검색 \n"
                + "4. 단어 추가 \n"
                + "5. 단어 수정 \n"
                + "6. 단어 삭제 \n"
                + "7. 단어 저장 \n"
                + "0. 나가기 \n"
                + "****************** \n"
                + "=> 원하는 메뉴는? "
        );
        return  s.nextInt();
    }
    public void start(){
        savefile.loadfile();
        while (true) {
            int menuNumver = menu();
            if(menuNumver == 0) break;
            else if(menuNumver == 1) {
                // read
                wordcrud.listAll();
            }else if(menuNumver == 3){
                wordcrud.searchWord();
            }
            else if(menuNumver == 4) {
                wordcrud.addword();//add
            }
            else if(menuNumver == 5) {
                // update
                wordcrud.updateItem();
            }
            else if(menuNumver == 6) {
                // delete
                wordcrud.deleteItem();
            }
            else if (menuNumver == 7) {
                savefile.saveFile();
            }
        }
    }
}


/*
    *** 영단어 마스터 ***
    ******************
    1. 모든 단어 보기
    2. 수준별 단어 보기
    3.단어 검색
    4. 단어 추가
    5. 단어 수정
    6. 단어 삭제
    7. 파일 저장
    0. 나가기
    ******************
    => 원하는 메뉴는?
* */
