package org.example;
import java.util.Scanner;

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
public class WordManager {
    Scanner s = new Scanner(System.in);
    WordCRUD wordcrud;
    WordManager(){
        wordcrud = new WordCRUD(s);
    }
    public int menu(){
        System.out.println(" *** 영단어 마스터 ***"
                + "******************"
                + "1. 모든 단어 보기"
                + "2. 수준별 단어 보기"
                + "3.단어 검색"
                + "4. 단어 추가"
                + "5. 단어 수정"
                + "6. 단어 삭제"
                + "0. 나가기"
                + "******************"
                + "=> 원하는 메뉴는?"
        );
        return  s.nextInt();
    }
    public void start(){
        while (true) {
            int menuNumver = menu();
            System.out.println(menuNumver);
            if(menuNumver == 0) break;
            else if(menuNumver == 1) {
                // read
                wordcrud.addword();
            }
            else if(menuNumver == 4) {
                wordcrud.add();
                //add
            }
         }
    }

}
