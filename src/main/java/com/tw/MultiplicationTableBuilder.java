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
        if (isValid(start, end)) {
            return generateMultiplicationTable(start, end) + "\n";
        }
        return null;
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
        return java.util.stream.IntStream.rangeClosed(start, end)
                .mapToObj(i -> java.util.stream.IntStream.rangeClosed(start, i)
                        .mapToObj(j -> generateMultiplicationResult(j, i))
                        .collect(java.util.stream.Collectors.joining(" ")))
                .collect(java.util.stream.Collectors.joining("\n"));
    }

}
