# hanteoglobal
hanteoglobal Task

[1번 문제]
* 게시판 기능을 개발하던중 추가 요구사항이 발생하였습니다. 이 요구사항을 해결하기 위한 자료구조를 구현하여 제출 바랍니다.
* 구현 언어는 Java 입니다.
* 테스트는 자유롭게 하시기 바랍니다.

요구사항 : 게시판은 여러 게시글을 포함하는 객체이자 데이터 이다. 이 게시판이 여러 형태로 카테고리 구분이 되었으면 한다.
카테고리 구분의 예시는 다음과 같다.

공지사항은 이름은 같지만 각각 다른 게시판이며
익명 게시판은 모두 같은 게시판이 각각 다른 카테고리에 소속되어 있다.

카테고리들간의 관계 데이터를 parent_idx, child_id 2개의 값으로만 저장 해야 하며 저장된 값을 임의의 자료구조를 통해 구조화 시켜서 위와 같은 관계 데이터를 얻을 수 있어야 한다.

자료구조는 다음과 같은 기능이 필수로 지원 되야 한다.

1. 카테고리 식별자 및 카테고리명으로 검색이 되어야하며, 검색된 결과 값은 해당 카테고리의 하위 카테고리를 모두 담고 있어야 한다.
2. 자료구조는 Json text 로 응답 될 수 있어야 한다. (Json 구조로 변환이 가능해야 한다)

* 핵심은 요구사항을 만족하는 자료구조의 구현입니다.

