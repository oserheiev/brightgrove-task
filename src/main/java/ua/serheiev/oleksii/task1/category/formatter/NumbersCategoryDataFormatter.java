package ua.serheiev.oleksii.task1.category.formatter;

import ua.serheiev.oleksii.task1.constant.Const;

import java.util.Map;

public class NumbersCategoryDataFormatter implements CategoryDataFormatter<Map<String, Long>> {

    @Override
    public String format(String categoryName, Map<String, Long> categoryData) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(categoryName).append(Const.COLON).append(System.lineSeparator());

        categoryData.forEach((dataItem, frequency) -> {
            stringBuilder.append(dataItem).append(Const.COLON).append(frequency).append(System.lineSeparator());
        });
        return stringBuilder.toString();
    }
}
