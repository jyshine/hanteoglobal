package task1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoryTest {
    private Category rootCategory;
    private Category category1;
    private Category category2;
    private Category category3;

    @BeforeEach
    public void setUp() {
        Board board1 = new Board(1L);
        rootCategory = new Category(0L, "root");
        category1 = new Category(1L, "남자");
        category2 = new Category(2L, "여자");
        category3 = new Category(3L, "익명게시판", board1);
    }
    @Test
    public void testAddChild() {
        rootCategory.addChild(1L, category1);
        rootCategory.addChild(2L, category2);
        rootCategory.addChild(3L, category3);

        Map<Long, Category> childCategories = rootCategory.getChildCategory();

        assertTrue(childCategories.containsKey(1L));
        assertTrue(childCategories.containsKey(2L));
        assertTrue(childCategories.containsKey(3L));
        assertEquals(category1, childCategories.get(1L));
        assertEquals(category2, childCategories.get(2L));
        assertEquals(category3, childCategories.get(3L));
    }

    @Test
    public void testGetChildCategory() {
        rootCategory.addChild(1L, category1);
        rootCategory.addChild(2L, category2);
        rootCategory.addChild(3L, category3);

        Map<Long, Category> childCategories = rootCategory.getChildCategory();

        assertEquals(3, childCategories.size());
    }
}