package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UsingFileIO {
    final String fname = "Dictionary.txt";
    ArrayList<Word> list = WordData.list;

    Scanner s;
    UsingFileIO(Scanner s){
        this.s = s;
    }
    public void loadfile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line;
            int count = 0;
            while (true){
                line = br.readLine();
                if(line == null) break;
                String data[] = line.split("\\|");
                int level = Integer.parseInt(data[0]);
                String word = data[1];
                String meaning = data[2];
                list.add(new Word(0, level, meaning, word));
                count++;
            }
            br.close();
            System.out.println("==> " + count + "로딩 완료!!! ");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void saveFile(){
        try {
            PrintWriter pr = new PrintWriter(new FileWriter(fname));
            for(Word one : list){
                pr.write(one.toFileString() + "\n");
            }
            pr.close();
            System.out.println("==> 텍스트 파일에 저장완료!!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
