package ua.serheiev.oleksii.task1.category.formatter;

import ua.serheiev.oleksii.task1.constant.Const;

import java.util.Set;

public class AnimalsCategoryDataFormatter implements CategoryDataFormatter<Set<String>> {

    @Override
    public String format(String categoryName, Set<String> categoryData) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(categoryName.toUpperCase()).append(Const.COLON).append(System.lineSeparator());
        categoryData.stream()
                .sorted()
                .forEach(categoryItem -> stringBuilder.append(categoryItem)
                        .append(System.lineSeparator()));
        return stringBuilder.toString();
    }
}
