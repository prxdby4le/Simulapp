package com.example.simulapp.api;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class EnemApiModels {

    public static class QuestionDetails {
        @SerializedName("title")
        public String title;

        @SerializedName("index")
        public int index;

        @SerializedName("year")
        public int year;

        @SerializedName("language")
        public String language;

        @SerializedName("discipline")
        public String discipline;

        @SerializedName("context")
        public String context;

        @SerializedName("files")
        public List<String> files;

        @SerializedName("correctAlternative")
        public String correctAlternative;

        @SerializedName("alternativesIntroduction")
        public String alternativesIntroduction;

        @SerializedName("alternatives")
        public List<Alternative> alternatives;
    }

    public static class Alternative {
        @SerializedName("letter")
        public String letter;

        @SerializedName("text")
        public String text;

        @SerializedName("file")
        public String file;

        @SerializedName("isCorrect")
        public boolean isCorrect;
    }

    public static class ExamYear {
        @SerializedName("title")
        public String title;

        @SerializedName("year")
        public int year;

        @SerializedName("disciplines")
        public List<Discipline> disciplines;

        @SerializedName("languages")
        public List<Language> languages;
    }

    public static class Discipline {
        @SerializedName("label")
        public String label;

        @SerializedName("value")
        public String value;
    }

    public static class Language {
        @SerializedName("label")
        public String label;

        @SerializedName("value")
        public String value;
    }
}

