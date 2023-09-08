package task1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoryTreeTest {

    private CategoryTree categoryTree;
    @BeforeEach
    public void setUp() {
        categoryTree = new CategoryTree();
    }


    @Test
    public void 카테고리_트리_추가() {
        categoryTree.addCategoryTree(0L,1L, "남자",null);
        categoryTree.addCategoryTree(0L,2L, "여자",null);
        categoryTree.addCategoryTree(1L, 3L, "엑소",null);
        categoryTree.addCategoryTree(1L, 4L, "방탄소년단",null);
        categoryTree.addCategoryTree(2L, 5L, "블랙핑크",null);

        Category rootCategory = categoryTree.getRootCategory();
        assertEquals("root", rootCategory.getCategoryName());
        assertNotNull(rootCategory.getChildCategory());

        Category maleCategory = rootCategory.getChildCategory().get(1L);
        assertEquals("남자", maleCategory.getCategoryName());
        assertNotNull(maleCategory.getChildCategory());

        Category femaleCategory = rootCategory.getChildCategory().get(2L);
        assertEquals("여자", femaleCategory.getCategoryName());
        assertNotNull(femaleCategory.getChildCategory());

        Category exoCategory = maleCategory.getChildCategory().get(3L);
        assertEquals("엑소", exoCategory.getCategoryName());
        assertNotNull(exoCategory.getChildCategory());

        Category btsCategory = maleCategory.getChildCategory().get(4L);
        assertEquals("방탄소년단", btsCategory.getCategoryName());
        assertNotNull(btsCategory.getChildCategory());

        Category blackPinkCategory = femaleCategory.getChildCategory().get(5L);
        assertEquals("블랙핑크", blackPinkCategory.getCategoryName());
        assertNotNull(blackPinkCategory.getChildCategory());
    }

    @Test
    public void 카테고리_검색_카테고리번호() {
        categoryTree.addCategoryTree(null, 1L, "root", null);
        categoryTree.addCategoryTree(1L, 2L, "남자", null);
        categoryTree.addCategoryTree(2L, 3L, "엑소", null);
        categoryTree.addCategoryTree(2L, 4L, "방탄소년단", null);

        Category foundCategory = categoryTree.findCategoryById(categoryTree.getRootCategory(), 3L);
        assertEquals("엑소", foundCategory.getCategoryName());

        foundCategory = categoryTree.findCategoryById(categoryTree.getRootCategory(), 4L);
        assertEquals("방탄소년단", foundCategory.getCategoryName());

        foundCategory = categoryTree.findCategoryById(categoryTree.getRootCategory(), 5L);
        assertNull(foundCategory);


    }

    @Test
    public void 카테고리_검색_카테고리명() {
        // Add categories to the category tree
        categoryTree.addCategoryTree(null, 1L, "root", null);
        categoryTree.addCategoryTree(1L, 2L, "남자", null);
        categoryTree.addCategoryTree(1L, 3L, "여자", null);
        categoryTree.addCategoryTree(2L, 4L, "엑소", null);
        categoryTree.addCategoryTree(2L, 5L, "방탄소년단", null);
        categoryTree.addCategoryTree(3L, 6L, "공지사항", null);
        categoryTree.addCategoryTree(3L, 7L, "첸", null);
        categoryTree.addCategoryTree(4L, 8L, "공지사항", null);

        // Test finding categories by name
        List<Category> foundCategories = categoryTree.findCategoriesByCategoryName(categoryTree.getRootCategory(), "공지사항");
        assertEquals(2, foundCategories.size());

        foundCategories = categoryTree.findCategoriesByCategoryName(categoryTree.getRootCategory(), "엑소");
        assertEquals(1, foundCategories.size());
        assertEquals("엑소", foundCategories.get(0).getCategoryName());

        foundCategories = categoryTree.findCategoriesByCategoryName(categoryTree.getRootCategory(), "블랙핑크"); // Non-existent name
        assertEquals(0, foundCategories.size());
    }
}