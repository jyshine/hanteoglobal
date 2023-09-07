package task1;

import static org.junit.jupiter.api.Assertions.*;

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

}