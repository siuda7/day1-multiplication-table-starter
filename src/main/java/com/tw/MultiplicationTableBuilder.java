package com.tw;

public class MultiplicationTableBuilder {

    public static void main(String[] args) {
        MultiplicationTableBuilder builder = new MultiplicationTableBuilder();
        int start = 2;
        int end = 4;
        String multiplicationTable = builder.build(start, end);

        System.out.println(multiplicationTable);
    }

    public String build(int start, int end) {
        return "";
    }

    public boolean isInRange(int number) {
        return number >= 1 && number <= 1000;
    }

    public boolean isStartNotBiggerThanEnd(int start, int end) {
        return start >= end;
    }

    public boolean isValid(int start, int end) {
        return isInRange(start) && isInRange(end) && !isStartNotBiggerThanEnd(start, end);
    }

    public String generateMultiplicationResult(int start, int row) {
        return String.format("%d*%d=%d", start, row, start * row);
    }

    public String generateMultiplicationTable(int start, int end) {
        StringBuilder multiplicationTable = new StringBuilder();
        for (int i = start; i <= end; i++) {
            for (int j = start; j <= i; j++) {
                multiplicationTable.append(generateMultiplicationResult(j, i));
                if (j != i) {
                    multiplicationTable.append(" ");
                }
            }
            if (i != end) {
                multiplicationTable.append("\n");
            }
        }
        return multiplicationTable.toString();
    }



}
