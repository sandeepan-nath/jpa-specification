package com.demo.searchcriteria;

public class Enum {

    public enum GENDER {
        MALE("MALE"),
        FEMALE("FEMALE");

        public  final String v;

        GENDER(String value) {
            this.v = value;
        }
    }
}
