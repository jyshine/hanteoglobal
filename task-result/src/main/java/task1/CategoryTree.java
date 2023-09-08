package task1;

import java.util.ArrayList;
import java.util.List;

public class CategoryTree {
    private Category rootCategory;

    public CategoryTree() {
        // Root Category 생성
        this.rootCategory = new Category(0L,"root");
    }
    public void addCategoryTree(Long parentId, Long categoryId, String categoryName, Board board){
        Category newCategory;
        if (board != null){
            newCategory = new Category(categoryId, categoryName, board);
        } else {
            newCategory = new Category(categoryId, categoryName);
        }

        if (null == parentId){
            rootCategory.addChild(categoryId, newCategory);
        } else {
            Category parentCategory = findCategoryById(rootCategory, parentId);
            parentCategory.addChild(categoryId,newCategory);
        }
    }
    public Category findCategoryById(Category category, Long categoryId){
        if (category != null && category.getId() != null && category.getId().equals(categoryId)){
            return category;
        }

        if (null != category.getChildCategory()) {
            for (Category subCategory:category.getChildCategory().values()){
                Category result = findCategoryById(subCategory, categoryId);
                if (result != null){
                    return result;
                }
            }
        }

        return null;
    }
    public List<Category> findCategoriesByCategoryName(Category category, String categoryName) {
        List<Category> foundCategories = new ArrayList<>();

        if (category.getCategoryName().equals(categoryName)) {
            foundCategories.add(category);
        }

        if (null != category.getChildCategory()) {
            for (Category childCategory : category.getChildCategory().values()) {
                List<Category> childResults = findCategoriesByCategoryName(childCategory, categoryName);
                foundCategories.addAll(childResults);
            }
        }

        return foundCategories;
    }
    public Category getRootCategory() {
        return rootCategory;
    }
}
