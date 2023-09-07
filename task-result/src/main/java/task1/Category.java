package task1;

import java.util.HashMap;
import java.util.Map;

public class Category {
    private Long id;
    private String categoryName;
    private Board board;
    private Map<Long, Category> childCategory;

    public Category(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
        this.childCategory = new HashMap<>();
    }

    // 마지막 카테고리에 게시판 객체 입력하고
    // 불필요한 childCategory 객체 생성 하지않도록 한다.
    public Category(Long id, String categoryName, Board board) {
        this.id = id;
        this.categoryName = categoryName;
        this.board = board;
        this.childCategory = null;
    }

    public void addChild(Long categoryId, Category category) {
        childCategory.put(categoryId, category);
    }

    public Map<Long, Category> getChildCategory() {
        return childCategory;
    }

    public Long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
