package org.example;

public class Word {
    int id;
    int level;
    String meaning;
    String word;
    Word(){
        //파일 입출력하기
    }
    Word(int id, int level, String meaning, String word){
        this.id = id;
        this.level = level;
        this.meaning = meaning;
        this.word = word;
    }
    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getWord() {
        return word;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        StringBuilder slevel = new StringBuilder();
        for(int i = 0; i<level; i++){
            slevel.append("*");
        }
        String str = String.format("%-3s ", slevel.toString())
                + String.format("%-15s", word) + " " + meaning;
        return str;
    }

    public String toFileString(){
        return this.level + "|" + this.word + "|" + this.meaning;
    }
}
