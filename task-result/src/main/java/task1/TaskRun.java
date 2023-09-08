package task1;

import com.google.gson.Gson;
import java.util.List;

public class TaskRun {
    public static void main(String[] args) {
        // 게시판 등록
        Board board1 = new Board(1L);
        Board board2 = new Board(2L);
        Board board3 = new Board(3L);
        Board board4 = new Board(4L);
        Board board5 = new Board(5L);
        Board board6 = new Board(6L);
        Board board7 = new Board(7L);
        Board board8 = new Board(8L);
        Board board9 = new Board(9L);

        // 카테고리 등록
        CategoryTree categoryTree = new CategoryTree();
        categoryTree.addCategoryTree(0L,1L, "남자",null);
        categoryTree.addCategoryTree(0L,2L, "여자",null);
        categoryTree.addCategoryTree(1L, 3L, "엑소",null);
        categoryTree.addCategoryTree(1L, 4L, "방탄소년단",null);
        categoryTree.addCategoryTree(2L, 5L, "블랙핑크",null);
        categoryTree.addCategoryTree(3L, 6L, "공지사항",board1);
        categoryTree.addCategoryTree(3L, 7L, "첸",board2);
        categoryTree.addCategoryTree(3L, 8L, "백현",board3);
        categoryTree.addCategoryTree(3L, 9L, "시우민",board4);
        categoryTree.addCategoryTree(4L, 10L, "공지사항",board5);
        categoryTree.addCategoryTree(4L, 11L, "익명게시판",board6);
        categoryTree.addCategoryTree(4L, 12L, "뷔",board7);
        categoryTree.addCategoryTree(5L, 13L, "공지사항",board8);
        categoryTree.addCategoryTree(5L, 14L, "익명게시판",board6);
        categoryTree.addCategoryTree(5L, 15L, "로제",board9);


        // id 검색
        Long findId = 4L;
        Category foundById = categoryTree.findCategoryById(categoryTree.getRootCategory(), findId);

        // 카테고리명 검색
        String categoryNameToFind = "엑소";
        List<Category> foundByName = categoryTree.findCategoriesByCategoryName(categoryTree.getRootCategory(), categoryNameToFind);


        // 검색 결과  Json 변환
        Gson gson = new Gson();
        String searchIdResult = gson.toJson(foundById);
        String searchNameResult = gson.toJson(foundByName);
        // 결과 출력
        System.out.println(searchIdResult);
        System.out.println(searchNameResult);

    }
}
