package ua.serheiev.oleksii.task1.category.formatter;

import org.apache.commons.codec.digest.DigestUtils;
import ua.serheiev.oleksii.task1.constant.Const;

import java.util.Comparator;
import java.util.Set;

public class CarsCategoryDataFormatter<T> implements CategoryDataFormatter<Set<String>> {

    @Override
    public String format(String categoryName, Set<String> categoryData) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(categoryName).append(Const.COLON).append(System.lineSeparator());

        categoryData.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(dataItem -> {
                    String hashedDataItem = DigestUtils.md5Hex(dataItem);

                    stringBuilder.append(Const.SIGN).append(Const.WHITE_SPACE).append(dataItem).append(Const.WHITE_SPACE)
                            .append(Const.LEFT_BRACKET).append(hashedDataItem ).append(Const.RIGHT_BRACKET)
                            .append(System.lineSeparator());
                });
        return stringBuilder.toString();
    }
}
