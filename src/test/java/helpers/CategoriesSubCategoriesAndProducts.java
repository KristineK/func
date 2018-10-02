package helpers;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.fail;

public class CategoriesSubCategoriesAndProducts {
    protected static Map categories;
    protected static Map subCategories;
    protected static Map product;

    public CategoriesSubCategoriesAndProducts() {
        categories = new HashMap();
        categories.put("desktops", 20);
        categories.put("laptops & notebooks", 18);
        categories.put("components", 25);
        categories.put("tablets", 57);
        categories.put("software", 17);
        categories.put("phones & pdas", 24);
        categories.put("cameras", 33);
        categories.put("mp3 players", 34);

        subCategories = new HashMap();
        subCategories.put("PC", 26);
        subCategories.put("Bak", 27);
        subCategories.put("Baks", 46);
        subCategories.put("Windows", 45);
        subCategories.put("Mice and Trackballs", 29);
        subCategories.put("Monitors", 28);
        subCategories.put("Printers", 30);
        subCategories.put("Scanners", 31);
        subCategories.put("Web Cameras", 32);
        subCategories.put("test 4", 38);
        subCategories.put("test 5", 39);
        subCategories.put("test 6", 40);
        subCategories.put("test 7", 41);
        subCategories.put("test 8", 42);
        subCategories.put("test 9", 43);
        subCategories.put("test 11", 44);
        subCategories.put("test 12", 45);
        subCategories.put("test 15", 46);
        subCategories.put("test 16", 47);
        subCategories.put("test 17", 48);
        subCategories.put("test 18", 49);
        subCategories.put("test 19", 50);
        subCategories.put("test 20", 51);
        subCategories.put("test 21", 52);
        subCategories.put("test 22", 53);
        subCategories.put("test 23", 54);
        subCategories.put("test 24", 55);

        product = new HashMap();
        product.put("BakBook", 43);
        product.put("opa-Phone", 40);
        ;
        product.put("Appricot Cinema 21''", 42);
        product.put("BP LP3065", 56);
        ;
        product.put("Space Tab 10.1", 49);
    }

    public static Map getCategories() {
        return categories;
    }

    public static String getCategoryValue(@NotNull String categoryName) {
        if (categories.containsKey(categoryName)) {
            return String.valueOf(categories.get(categoryName));
        } else {
            fail("No such category: " + categoryName);
        }
        return "";
    }

    public static String getSubCategoryValue(@NotNull String subCategoryName) {
        if (subCategories.containsKey(subCategoryName)) {
            return String.valueOf(subCategories.get(subCategoryName));
        } else {
            fail("No such category: " + subCategoryName);
        }
        return "";
    }

    public static Map getSubCategories() {
        return subCategories;
    }

    public static String getProductValue(@NotNull String aProductName) {
        if (product.containsKey(aProductName)) {
            return String.valueOf(product.get(aProductName));
        } else {
            fail("No such category: " + aProductName);
        }
        return "";
    }
}
